package managers;

import items.Enquiry;
import items.Project;
import items.users.*;
import items.users.Applicant;
import items.users.User.UserType;
import arrays.Enquiries;

/**
 * EnquiryManager is responsible for managing enquiries related to projects.
 * It allows users to create, reply to, edit, and manage the status of enquiries.
 */
public class EnquiryManager {

    /**
     * Creates a new enquiry for a given project and enquiry text.
     * @param p the project associated with the enquiry
     * @param enquiry the text content of the enquiry
     * @return the newly created Enquiry object
     */
    public static Enquiry create(Project p, String enquiry) {
        Enquiry e = new Enquiry((Applicant)AppUserManager.getCurrentUser(), p, enquiry);
        Enquiries.newEnquiry(e);
        return e;
    }

    /**
     * Allows a Manager or Officer to reply to an enquiry.
     * @param e the enquiry to reply to
     * @param reply the text content of the reply
     * @throws IllegalAccessException if the user doesn't have permission to reply to the enquiry
     */
    public static void reply(Enquiry e, String reply) throws IllegalAccessException {
        User user = AppUserManager.getCurrentUser();
        Project p = e.getProject();
        
        // Check if user is authorized to reply
        if (user.getType() != UserType.MANAGER && user.getType() != UserType.OFFICER) {
            throw new IllegalAccessException("wrong usertype!");
        }
        if (user.getType() == UserType.OFFICER) {
            if (!((Officer)user).inCharge(p)) throw new IllegalAccessException("not in charge!");
        }
        if (user.getType() == UserType.MANAGER) {
            if (!((Manager)user).inCharge(p)) throw new IllegalAccessException("not in charge!");
        }
        
        // Proceed with replying
        e.reply(AppUserManager.getCurrentUser(), reply);
    }

    /**
     * Allows the applicant to edit their enquiry text.
     * @param e the enquiry to edit
     * @param enquiry the new enquiry text
     * @throws IllegalAccessException if the current user is not the applicant for the enquiry
     */
    public static void edit(Enquiry e, String enquiry) throws IllegalAccessException {
        if (e.getApplicant() != AppUserManager.getCurrentUser()) {
            throw new IllegalAccessException("not valid applicant!");
        }
        e.setEnquiry(enquiry);
    }

    /**
     * Allows the replier (Manager/Officer) to edit the reply to the enquiry.
     * @param e the enquiry whose reply is to be edited
     * @param reply the new reply text
     * @throws IllegalAccessException if the current user is not authorized to edit the reply
     */
    public static void editReply(Enquiry e, String reply) throws IllegalAccessException {
        if (e.getReplier() != AppUserManager.getCurrentUser()) {
            throw new IllegalAccessException("not valid applicant!");
        }
        e.setReply(reply);
    }
}
