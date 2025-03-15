package items;

import items.users.Applicant;
import items.users.User;
import items.users.User.UserType;
import managers.AppUserManager;

public class Enquiry extends Item {
    private String enquiry;
    private String reply;
    private Applicant applicant;
    private User replier;
    private Project project;

    public Enquiry(Project project, String enquiry) {
        this.applicant = (Applicant)AppUserManager.getCurrentUser();
        this.enquiry = enquiry;
        this.project = project;
    };

    public void reply(User replier, String reply) throws IllegalAccessException{
        User user = AppUserManager.getCurrentUser();
        if (user.getType() != UserType.MANAGER && user.getType() != UserType.OFFICER) throw new IllegalAccessException("wrong usertype!");
        this.replier = AppUserManager.getCurrentUser();
        this.reply = reply;
    }

    public void editEnquiry(String enquiry) throws IllegalAccessException {
        if (applicant != AppUserManager.getCurrentUser()) {
            throw new IllegalAccessException("not valid applicant!");
        }
        this.enquiry = enquiry;
    }

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
}
