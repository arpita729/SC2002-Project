package managers;

import items.OfficerApplication;
import items.Project;
import items.Application.*;
import items.users.*;
import arrays.OfficerApplications;

/**
 * This class handles the management of Officer Applications, including the ability
 * to apply for an officer position, approve or withdraw an application, and approve
 * or reject a withdrawal request.
 */
public class OfficerApplicationManager {

    /**
     * Applies for an officer position for a given project.
     *
     * @param p The project for which the officer application is being made.
     * @return The OfficerApplication object representing the application for the officer position.
     * @throws IllegalArgumentException if the officer has already applied for the project, is already an applicant for the project, 
     *         or has an existing application for the project.
     */
    public static OfficerApplication apply(Project p) throws IllegalArgumentException {
        Officer o = (Officer) AppUserManager.getCurrentUser();
        // Check various conditions
        if (o.hasApplication(p)) throw new IllegalArgumentException("already have an officer application!");
        if (o.getProject() == p) throw new IllegalArgumentException("is project applicant!");
        if (o.getApplication() != null && o.getApplication().getProject() == p) {
            throw new IllegalArgumentException("has applied for project!");
        }

        // Validate the project
        Validator.validateNewProject(p.getOpeningDate(), p.getClosingDate(), o.getProjectsInCharge());

        // Create and add officer application
        OfficerApplication ap = new OfficerApplication(o, p);
        OfficerApplications.newOfficerApplication(ap);
        return ap;
    }

    /**
     * Withdraws an officer application.
     *
     * @param ap The OfficerApplication object to be withdrawn.
     * @throws IllegalArgumentException if the current user is not the applicant.
     */
    public static void withdraw(OfficerApplication ap) throws IllegalArgumentException {
        Officer o = (Officer) AppUserManager.getCurrentUser();
        if (ap.getApplicant() != o) throw new IllegalArgumentException("not applicant!");
        ap.setWithdrawing(WithdrawStatus.PENDING);
    }

    /**
     * Approves or rejects an officer application.
     *
     * @param ap The OfficerApplication object to approve or reject.
     * @param approval True to approve the application, false to reject it.
     * @throws IllegalArgumentException if the current user is not a manager and not in charge of the project.
     * @throws IllegalArgumentException if the application status is not pending or there are not enough officer slots.
     */
    public static void approve(OfficerApplication ap, boolean approval) throws IllegalArgumentException {
        Manager m = (Manager) AppUserManager.getCurrentUser();
        Project p = ap.getProject();
        if (!m.inCharge(p)) throw new IllegalArgumentException("not in charge!");
        if (ap.getStatus() != Status.PENDING) throw new IllegalArgumentException("officer application not pending!");
        if (!approval) {
            ap.setStatus(Status.UNSUCCESSFUL);
            return;
        }

        int oSlots = p.getOfficerSlots();
        if (oSlots < 1) throw new IllegalArgumentException("not enough slots!");
        p.setOfficerSlots(p.getOfficerSlots()-1);
        ap.setStatus(Status.SUCCESSFUL);
    }

    /**
     * Approves or rejects the withdrawal of an officer application.
     *
     * @param ap The OfficerApplication object to approve or reject the withdrawal for.
     * @param approval True to approve the withdrawal, false to reject it.
     * @throws IllegalArgumentException if the current user is not a manager and not in charge of the project.
     * @throws IllegalArgumentException if the application is not in withdrawal status.
     */
    public static void approveWithdraw(OfficerApplication ap, boolean approval) throws IllegalArgumentException {
        Manager m = (Manager) AppUserManager.getCurrentUser();
        Project p = ap.getProject();
        if (!m.inCharge(p)) throw new IllegalArgumentException("not in charge!");
        if (ap.getWithdrawing() != WithdrawStatus.PENDING) throw new IllegalArgumentException("application not withdrawing!");
        if (!approval) {
            ap.setWithdrawing(WithdrawStatus.UNSUCCESSFUL);
            return;
        }

        // Mark as null and update project slots if necessary
        ((Officer) ap.getApplicant()).setApplication(null);

        if (ap.getStatus() == Status.SUCCESSFUL) {
            p.setOfficerSlots(p.getOfficerSlots() + 1);
        }

        ap.setStatus(Status.WITHDRAWN);
        ap.setWithdrawing(WithdrawStatus.SUCCESSFUL);
    }
}
