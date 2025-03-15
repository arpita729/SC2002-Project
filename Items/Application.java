package items;

import items.users.Applicant;
import managers.AppUserManager;

public class Application extends Item {
    public enum Status {
        PENDING, SUCCESSFUL, UNSUCCESSFUL, BOOKED, WITHDRAWING, WITHDRAWN
    }

    private Applicant applicant;
    private Project project;
    private Status status = Status.PENDING;

    public Application(Project project) {
        this.applicant = (Applicant)AppUserManager.getCurrentUser();
        this.project = project;
    }

    // Getters
    public Applicant getApplicant() {
        return applicant;
    }

    public Project getProject() {
        return project;
    }

    public Status getStatus() {
        return status;
    }

    public String toString() {
        // implementation here
        return "";
    }
}
