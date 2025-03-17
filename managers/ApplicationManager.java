package managers;

import items.Application;
import items.Project;
import items.Application.*;
import items.users.*;
import items.users.User.MaritalStatus;
import items.users.User.UserType;

import arrays.Applications;


/**
 * This class manages the application process for the users (Applicants, Officers, and Managers).
 * It handles actions such as applying, withdrawing, booking, and approving applications.
 */
public class ApplicationManager {
    /**
     * Allows an applicant to apply for a project with a specified flat type.
     * This method checks various conditions like marital status, age, project visibility, etc.
     * 
     * @param p the project the applicant is applying for
     * @param f the flat type the applicant wants to apply for
     * @return the created Application
     * @throws IllegalArgumentException if any of the validation checks fail
     */
    public static Application apply(Project p, FlatType f) throws IllegalArgumentException {
        Applicant a = (Applicant) AppUserManager.getCurrentUser();
        // Implementation here
        if (a.getApplication() != null) throw new IllegalArgumentException("already have an application!");
        if (a.getType() == UserType.OFFICER) {
            Officer o = (Officer) a;
            if (o.inCharge(p)) throw new IllegalArgumentException("is project in charge!");
            if (o.hasApplication(p)) throw new IllegalArgumentException("has applied to be officer for project!");
        }
        // check user statuses
        if (a.getMaritalStatus() == MaritalStatus.MARRIED) {
            if (a.getAge() < 21) throw new IllegalArgumentException("not of age!");
        } else { // not married
            if (a.getAge() < 35) throw new IllegalArgumentException("not of age!");
            if (f != FlatType.TWO_ROOM) throw new IllegalArgumentException("inapplicable flattype!");
        }

        // check visibility
        if (!p.isVisible()) throw new IllegalArgumentException("project not visible!");
        
        Application ap = new Application(a,p,f);
        Applications.newApplication(ap);
        a.setApplication(ap);
        return ap;
    }

    /**
     * Allows an applicant to withdraw their application.
     * The application status is set to pending withdrawal.
     * 
     * @throws IllegalArgumentException if the applicant doesn't have an application
     */
    public static void withdraw() throws IllegalArgumentException {
        Applicant a = (Applicant) AppUserManager.getCurrentUser();
        // Implementation here
        Application ap = a.getApplication();
        if (ap == null) throw new IllegalArgumentException("don't have a project!");
        ap.setWithdrawing(WithdrawStatus.PENDING);
    }

    /**
     * Checks the number of available units for a specified flat type.
     * 
     * @param p the project in which the applicant is applying
     * @param f the flat type being applied for
     * @param minus boolean indicating whether the unit count should be decreased (true) or not (false)
     * @throws IllegalArgumentException if there are not enough available units
     */
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

    /**
     * Allows an officer to book an application that has been successful.
     * The number of available units for the specified flat type is decremented.
     * 
     * @param ap the application being booked
     * @throws IllegalAccessException if the officer is not in charge of the project
     * @throws IllegalArgumentException if the application is not successful
     */
    public static void book(Application ap) throws IllegalAccessException, IllegalArgumentException {
        Officer o = (Officer) AppUserManager.getCurrentUser();
        Project p = ap.getProject();
        if (!o.inCharge(p)) throw new IllegalAccessException("not in charge!");
        if (ap.getStatus() != Status.SUCCESSFUL) throw new IllegalArgumentException("application not successful!");
        
        FlatType f = ap.getFlatType();
        checkUnits(p, f,true);

        ap.setStatus(Status.BOOKED);
    }

    /**
     * Allows a manager to approve or reject an application.
     * If approved, the application is marked as successful and the number of available units is decremented.
     * If rejected, the application is marked as unsuccessful.
     * 
     * @param ap the application to approve/reject
     * @param approval boolean indicating whether the approval is granted or not
     * @throws IllegalAccessException if the manager is not in charge of the project
     * @throws IllegalArgumentException if the application is not in a pending state
     */
    public static void approve(Application ap, boolean approval) throws IllegalAccessException, IllegalArgumentException {
        Manager m = (Manager) AppUserManager.getCurrentUser();
        Project p = ap.getProject();
        if (!m.inCharge(p)) throw new IllegalAccessException("not in charge!");
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

    /**
     * Allows a manager to approve or reject a withdrawal request for an application.
     * If approved, the application is marked as withdrawn, and the flat units are incremented back.
     * 
     * @param ap the application to approve/reject for withdrawal
     * @param approval boolean indicating whether the withdrawal approval is granted or not
     * @throws IllegalAccessException if the manager is not in charge of the project
     * @throws IllegalArgumentException if the application is not in a withdrawing state
     */
    public static void approveWithdraw(Application ap, boolean approval) throws IllegalAccessException, IllegalArgumentException {
        Manager m = (Manager) AppUserManager.getCurrentUser();
        Project p = ap.getProject();
        if (!m.inCharge(p)) throw new IllegalAccessException("not in charge!");
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

        ap.setStatus(Status.WITHDRAWN);
        ap.setWithdrawing(WithdrawStatus.SUCCESSFUL);
    }
}
