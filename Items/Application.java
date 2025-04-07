package items;

import items.users.Applicant;

/**
 * Represents an application for a housing project.
 */
public class Application extends Item implements Stringifiable, LongStringifiable {
    /**
     * Enumeration of possible application statuses.
     */
    public enum Status {
        PENDING, SUCCESSFUL, UNSUCCESSFUL, BOOKED, WITHDRAWN
    }
    
    /**
     * Enumeration of flat types available for application.
     */
    public enum FlatType {
        TWO_ROOM, THREE_ROOM
    }
    
    /**
     * Enumeration of withdrawal statuses for an application.
     */
    public enum WithdrawStatus {
        NOT, PENDING, UNSUCCESSFUL, SUCCESSFUL
    }

    private Applicant applicant;
    private Project project;
    private Status status = Status.PENDING;
    private WithdrawStatus withdrawing = WithdrawStatus.NOT;
    private FlatType flatType;

    /**
     * Constructs an Application object.
     * 
     * @param a the applicant
     * @param p the project being applied to
     * @param f the type of flat being applied for
     */
    public Application(Applicant a, Project p, FlatType f) {
        applicant = a;
        project = p;
        flatType = f;
    }

    /**
     * Returns a string representation of the application.
     * 
     * @return a string describing the application
     */
    public String toString() {
        // implementation here
        return "ID " + getId() + ": " +
            applicant.getName() + " applying for " +
            project.getName() + ", currently " + 
            status.toString() + " and " +
            withdrawing.toString() + " withdrawing." ;
    }
    
    /**
     * Returns a long string representation of the application.
     * 
     * @return a string fully describing the application
     */
    public String toLongString() {
        return "APPLICATION ID " + getId() + "\n" + 
            "Name: " + applicant.getName() + "\n" +
            "NRIC: " + applicant.getIc() + "\n" + 
            "Age: " + applicant.getAge() + "\n" +
            "Marital Status: " + applicant.getMaritalStatus().toString() + "\n" +
            "Flat Type: " + flatType.toString() + "\n" +
            "Project: " + project.toString() + "\n";
    }

    /**
     * Gets the applicant who submitted this application.
     * 
     * @return the applicant
     */
    public Applicant getApplicant() {
        return applicant;
    }

    /**
     * Gets the project associated with this application.
     * 
     * @return the project
     */
    public Project getProject() {
        return project;
    }

    /**
     * Gets the current status of this application.
     * 
     * @return the application status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Gets the flat type applied for.
     * 
     * @return the flat type
     */
    public FlatType getFlatType() {
        return flatType;
    }

    /**
     * Gets the withdrawal status of this application.
     * 
     * @return the withdrawal status
     */
    public WithdrawStatus getWithdrawing() {
        return withdrawing;
    }

    /**
     * Sets the status of this application.
     * 
     * @param status the new application status
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Sets the withdrawal status of this application.
     * 
     * @param w the new withdrawal status
     */
    public void setWithdrawing(WithdrawStatus w) {
        withdrawing = w;
    }
}
