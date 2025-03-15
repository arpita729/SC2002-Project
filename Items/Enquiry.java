package items;

import items.users.Applicant;
import items.users.User;

public class Enquiry extends Item {
    private String enquiry;
    private String reply;
    private Applicant applicant;
    private User replier=null;
    private Project project;

    public Enquiry(Applicant a, Project p, String e) {
        applicant = a;
        enquiry = e;
        project = p;
    };

    public String toString() {
        // implementation here
        return "";
    }

    public String getEnquiry() {
        return enquiry;
    }

    public String getReply() {
        return reply;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public User getReplier() {
        return replier;
    }

    public Project getProject() {
        return project;
    }

    public void setEnquiry(String enquiry) {
        this.enquiry = enquiry;
    }

    public void reply(User replier, String reply) throws IllegalAccessException {
        if (this.replier != null) throw new IllegalAccessException("already replied!");
        this.replier = replier;
        this.reply = reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

}
