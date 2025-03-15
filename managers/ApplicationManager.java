package managers;

import items.Application;
import items.Project;
import items.Application.*;
import items.users.*;
import items.users.User.MaritalStatus;
import items.users.User.UserType;

import arrays.Applications;

public class ApplicationManager {
    public static Application apply(Project p, FlatType f) throws IllegalArgumentException {
        Applicant a = (Applicant) AppUserManager.getCurrentUser();
        // Implementation here
        if (a.getApplication() != null) throw new IllegalArgumentException("already have an application!");
        if (a.getType() == UserType.OFFICER) {
            Officer o = (Officer) a;
            if (o.getProjectInCharge() == p) throw new IllegalArgumentException("is project in charge!");
            if (o.getOfficerApplication() != null && o.getOfficerApplication().getProject() == p) {
                throw new IllegalArgumentException("has applied to be officer for project!");
            }
        }
        // check user statuses
        if (a.getMaritalStatus() == MaritalStatus.MARRIED) {
            if (a.getAge() < 21) throw new IllegalArgumentException("not of age!");
        } else { // not married
            if (a.getAge() < 35) throw new IllegalArgumentException("not of age!");
            if (f != FlatType.TWO_ROOM) throw new IllegalArgumentException("inapplicable flattype!");
        }
        
        Application ap = new Application(a,p,f);
        Applications.newApplication(ap);
        a.setApplication(ap);
        return ap;
    }

    public static void withdraw() throws IllegalArgumentException {
        Applicant a = (Applicant) AppUserManager.getCurrentUser();
        // Implementation here
        Application ap = a.getApplication();
        if (ap == null) throw new IllegalArgumentException("don't have a project!");
        ap.setWithdrawing(WithdrawStatus.PENDING);
    }

    private static void checkUnits(Project p, FlatType f, boolean minus) {
        
        int units=-1;
        if (f == FlatType.TWO_ROOM) units = p.getNum2Room();
        if (f == FlatType.THREE_ROOM) units = p.getNum3Room();

        if (units < 1) throw new IllegalArgumentException("not enought units!");
        if (!minus) return;
        
        units--;
        if (f == FlatType.TWO_ROOM) p.setNum2Room(units);
        if (f == FlatType.THREE_ROOM) p.setNum3Room(units);
    }

    public static void book(Application ap) throws IllegalAccessException, IllegalArgumentException {
        Officer o = (Officer) AppUserManager.getCurrentUser();
        Project p = ap.getProject();
        if (o.getProjectInCharge() != p) throw new IllegalAccessException("not in charge!");
        if (ap.getStatus() != Status.SUCCESSFUL) throw new IllegalArgumentException("application not successful!");
        
        FlatType f = ap.getFlatType();
        checkUnits(p, f,true);

        ap.setStatus(Status.BOOKED);
    }

    public static void approve(Application ap, boolean approval) throws IllegalAccessException, IllegalArgumentException {
        Manager m = (Manager) AppUserManager.getCurrentUser();
        Project p = ap.getProject();
        if (m.getProjectInCharge() != p) throw new IllegalAccessException("not in charge!");
        if (ap.getStatus() != Status.PENDING) throw new IllegalArgumentException("application not pending!");
        if (!approval) {
            ap.setStatus(Status.UNSUCCESSFUL);
            // mark as null
            ap.getApplicant().setApplication(null);
            return;
        }

        FlatType f = ap.getFlatType();
        checkUnits(p, f, false);

        ap.setStatus(Status.SUCCESSFUL);
    }

    public static void approveWithdraw(Application ap, boolean approval) throws IllegalAccessException, IllegalArgumentException {
        Manager m = (Manager) AppUserManager.getCurrentUser();
        Project p = ap.getProject();
        if (m.getProjectInCharge() != p) throw new IllegalAccessException("not in charge!");
        if (ap.getWithdrawing() != WithdrawStatus.PENDING) throw new IllegalArgumentException("application not withdrawing!");
        
        if (!approval) {
            ap.setWithdrawing(WithdrawStatus.UNSUCCESSFUL);
            return;
        }

        // mark as null.
        ap.getApplicant().setApplication(null);

        // increment flattype
        if (ap.getStatus() == Status.BOOKED) {
            FlatType f = ap.getFlatType();
            if (f == FlatType.TWO_ROOM) p.setNum2Room(p.getNum2Room()+1);
            if (f == FlatType.THREE_ROOM) p.setNum3Room(p.getNum3Room()+1);
        }
    }
}
