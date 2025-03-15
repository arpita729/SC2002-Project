package managers;

import items.OfficerApplication;
import items.Project;
import items.Application.*;
import items.users.*;
import arrays.Applications;
import arrays.OfficerApplications;

public class OfficerApplicationManager {
    public static OfficerApplication apply(Project p) throws IllegalArgumentException {
        Officer o = (Officer) AppUserManager.getCurrentUser();
        // Implementation here
        if (o.getOfficerApplication() != null) throw new IllegalArgumentException("already have an officer application!");
        if (o.getProject() == p) throw new IllegalArgumentException("is project applicant!");
        if (o.getApplication() != null && o.getApplication().getProject() == p) {
            throw new IllegalArgumentException("has applied for project!");
        }

        OfficerApplication ap = new OfficerApplication(o,p);
        OfficerApplications.newApplication(ap);
        o.setOfficerApplication(ap);
        return ap;
    }

    public static void withdraw() throws IllegalArgumentException {
        Officer o = (Officer) AppUserManager.getCurrentUser();
        // Implementation here
        OfficerApplication ap = o.getOfficerApplication();
        if (ap == null) throw new IllegalArgumentException("don't have a project!");
        ap.setWithdrawing(WithdrawStatus.PENDING);
    }

    public static void approve(OfficerApplication ap, boolean approval) throws IllegalAccessException, IllegalArgumentException {
        Manager m = (Manager) AppUserManager.getCurrentUser();
        Project p = ap.getProject();
        if (m.getProjectInCharge() != p) throw new IllegalAccessException("not in charge!");
        if (ap.getStatus() != Status.PENDING) throw new IllegalArgumentException("officer application not pending!");
        if (!approval) {
            ap.setStatus(Status.UNSUCCESSFUL);
            // mark as null
            ((Officer)ap.getApplicant()).setOfficerApplication(null);
            return;
        }
        int oSlots = p.getOfficerSlots();
        if (oSlots < 1) throw new IllegalArgumentException("not enough slots!");
        p.setOfficerSlots(p.getOfficerSlots()-1);
        ap.setStatus(Status.SUCCESSFUL);
    }

    public static void approveWithdraw(OfficerApplication ap, boolean approval) throws IllegalAccessException, IllegalArgumentException {
        Manager m = (Manager) AppUserManager.getCurrentUser();
        Project p = ap.getProject();
        if (m.getProjectInCharge() != p) throw new IllegalAccessException("not in charge!");
        if (ap.getWithdrawing() != WithdrawStatus.PENDING) throw new IllegalArgumentException("application not withdrawing!");
        if (!approval) {
            ap.setWithdrawing(WithdrawStatus.UNSUCCESSFUL);
            return;
        }
        
        // mark as null.
        ((Officer)ap.getApplicant()).setApplication(null);

        // increment oSlots
        if (ap.getStatus() == Status.SUCCESSFUL) p.setOfficerSlots(p.getOfficerSlots()+1);

        Applications.deleteApplication(ap);
    }
}
