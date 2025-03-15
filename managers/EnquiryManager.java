package managers;

import items.Enquiry;
import items.Project;
import items.users.*;
import items.users.Applicant;
import items.users.User.UserType;
import arrays.Enquiries;

public class EnquiryManager {
    public static Enquiry create(Project p, String enquiry) {
        Enquiry e = new Enquiry((Applicant)AppUserManager.getCurrentUser(), p, enquiry);
        Enquiries.newEnquiry(e);
        return e;
    }

    public static void reply(Enquiry e, String reply) throws IllegalAccessException {
        User user = AppUserManager.getCurrentUser();
        if (user.getType() != UserType.MANAGER && user.getType() != UserType.OFFICER) {
            throw new IllegalAccessException("wrong usertype!");
        }
        if (user.getType() == UserType.OFFICER) {
            if (e.getProject() != ((Officer)user).getProjectInCharge()) throw new IllegalAccessError("not in charge!");
        }
        if (user.getType() == UserType.MANAGER) {
            if (e.getProject() != ((Manager)user).getProjectInCharge()) throw new IllegalAccessError("not in charge!");
        }
        e.reply(AppUserManager.getCurrentUser(), reply);
    }

    public static void edit(Enquiry e, String enquiry) throws IllegalAccessException {
        if (e.getApplicant() != AppUserManager.getCurrentUser()) {
            throw new IllegalAccessException("not valid applicant!");
        }
        e.setEnquiry(enquiry);
    }

    public static void editReply(Enquiry e, String reply) throws IllegalAccessException {
        if (e.getReplier() != AppUserManager.getCurrentUser()) {
            throw new IllegalAccessException("not valid applicant!");
        }
        e.setReply(reply);
    }

}
