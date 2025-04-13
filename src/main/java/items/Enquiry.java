package items;

import items.users.Applicant;
import items.users.User;

/**
 * Represents an enquiry made by an applicant regarding a project.
 */
public class Enquiry extends Item implements Stringifiable {
    private String enquiry;
    private String reply;
    private Applicant applicant;
    private User replier = null;
    private Project project;

    /**
     * Constructs an Enquiry object.
     * 
     * @param a the applicant who made the enquiry
     * @param p the project related to the enquiry
     * @param e the enquiry text
     */
    public Enquiry(Applicant a, Project p, String e) {
        applicant = a;
        enquiry = e;
        project = p;
    };

    /**
     * Returns a string representation of the enquiry.
     * 
     * @return a string describing the enquiry
     */
    public String toString() {
        // implementation here
        return "ID " + getId() + ": " +
            applicant.getName() + ": " +
            enquiry + ((replier != null) ? "\t" +
            replier.getName() + ": " + reply
            : "");
    }

    /**
     * Gets the enquiry text.
     * 
     * @return the enquiry text
     */
    public String getEnquiry() {
        return enquiry;
    }

    /**
     * Gets the reply to the enquiry.
     * 
     * @return the reply text
     */
    public String getReply() {
        return reply;
    }

    /**
     * Gets the applicant who made the enquiry.
     * 
     * @return the applicant
     */
    public Applicant getApplicant() {
        return applicant;
    }

    /**
     * Gets the user who replied to the enquiry.
     * 
     * @return the replier user
     */
    public User getReplier() {
        return replier;
    }

    /**
     * Gets the project associated with this enquiry.
     * 
     * @return the project
     */
    public Project getProject() {
        return project;
    }

    /**
     * Sets the enquiry text.
     * 
     * @param enquiry the new enquiry text
     */
    public void setEnquiry(String enquiry) {
        this.enquiry = enquiry;
    }

    /**
     * Replies to the enquiry.
     * 
     * @param replier the user replying to the enquiry
     * @param reply the reply text
     * @throws IllegalArgumentException if the enquiry has already been replied to
     */
    public void reply(User replier, String reply) throws IllegalArgumentException {
        if (this.replier != null) throw new IllegalArgumentException("already replied!");
        this.replier = replier;
        this.reply = reply;
    }

    /**
     * Sets the reply text.
     * 
     * @param reply the reply text
     */
    public void setReply(String reply) {
        this.reply = reply;
    }
}
