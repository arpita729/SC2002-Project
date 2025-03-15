package items;

import items.users.Applicant;

public class Application extends Item {
    public enum Status {
        PENDING, SUCCESSFUL, UNSUCCESSFUL, BOOKED
    }
    public enum FlatType {
        TWO_ROOM, THREE_ROOM
    }
    public enum WithdrawStatus {
        NONE, PENDING, UNSUCCESSFUL
    }

    private Applicant applicant;
    private Project project;
    private Status status = Status.PENDING;
    private WithdrawStatus withdrawing = WithdrawStatus.NONE;
    private FlatType flatType;

    public Application(Applicant a, Project p, FlatType f) {
        applicant = a;
        project = p;
        flatType = f;
    }

    public String toString() {
        // implementation here
        return "";
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

    public FlatType getFlatType() {
        return flatType;
    }

    public WithdrawStatus getWithdrawing() {
        return withdrawing;
    }

    // Setters
    public void setStatus(Status status) {
        this.status = status;
    }

    public void setWithdrawing(WithdrawStatus w) {
        withdrawing = w;
    }
}
