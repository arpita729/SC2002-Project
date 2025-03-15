package tests;

import java.util.ArrayList;

import arrays.*;
import items.*;
import items.users.*;
import items.users.User.MaritalStatus;
import items.Application.*;
import managers.*;

public class Test {
    public static void main(String[] args) {
        try {
            ArrayList<User> u = new ArrayList<>();
            Manager m = new Manager("M",  "password", 99, MaritalStatus.SINGLE);
            Officer o = new Officer("O",  "password", 90, MaritalStatus.MARRIED);
            Applicant a = new Applicant("A",  "password", 35, MaritalStatus.SINGLE);
            // Edit to check applicability
            Applicant b = new Applicant("B",  "password", 35, MaritalStatus.MARRIED);
            u.add(m);
            u.add(o);
            u.add(a);
            u.add(b);
            Users.setUsers(u);

            // TEST WRONG PW
            //AppUserManager.login("M","paswd"); // wrong pwd
            //ApplicationManager.apply(p,null);//null

            // TEST CREATE
            AppUserManager.login("M", "password");
            //AppUserManager.login("M", "password"); //alr logged in
            Project p = ProjectManager.create("a", "a", 1, 3, null, null, 1);
            AppUserManager.changePassword("password", "testtest");
            //AppUserManager.changePassword("password", "testtest"); // wrong pwd
            AppUserManager.logout();

            // TEST OFFICER APPLY
            AppUserManager.login("O","password");
            OfficerApplication op = OfficerApplicationManager.apply(p);
            //Application op2 = OfficerApplicationManager.apply(p); // already have
            AppUserManager.logout();
            
            // TEST APPLICANT APPLY & ENQUIRY
            AppUserManager.login("A","password");
            Application ap = ApplicationManager.apply(p, FlatType.TWO_ROOM);
            //Application ap2 = ApplicationManager.apply(p, FlatType.TWO_ROOM); // already have
            Enquiry e1 = EnquiryManager.create(p, "why r u gae");
            System.out.println(e1 == Enquiries.getEnquiry(0));
            Enquiry e2 = EnquiryManager.create(p, "who says im gae");
            AppUserManager.logout();
            AppUserManager.login("B","password");
            //p.setVisibility(false); // not visible
            Application bp = ApplicationManager.apply(p, FlatType.THREE_ROOM);
            //EnquiryManager.reply(e1, "i am error"); // wrong usertype
            AppUserManager.logout();
            p.setVisibility(false);

            // TEST NOT YET OFFICER
            AppUserManager.login("O","password");
            //EnquiryManager.reply(e2, "errors"); // not in charge
            //ApplicationManager.approve(ap, false); // cannot be cast
            //EnquiryManager.edit(e2,"error"); // not valid applicant
            //ApplicationManager.book(ap); // not in charge
            AppUserManager.logout();

            // TEST APPROVALS
            AppUserManager.login("M", "testtest");
            AppUserManager.changePassword("testtest", "password");
            //System.out.println(o.getProjectInCharge().getId()); // is null
            OfficerApplicationManager.approve(op, true);
            ApplicationManager.approve(ap,true);
            ApplicationManager.approve(bp, false);
            // EnquiryManager.editReply(e1, "errrorrrr"); // not valid applicant
            EnquiryManager.reply(e1, "u are gae");
            EnquiryManager.editReply(e1, "actually ur not");
            AppUserManager.logout();

            // TEST BOOKING
            AppUserManager.login("O","password");
            System.out.println(o.getProjectInCharge().getId());
            //Application op2 = OfficerApplicationManager.apply(p); // already have
            //System.out.println(a.getProject().getId()); // is null
            ApplicationManager.book(ap);
            EnquiryManager.reply(e2, "why r u gae");
            //EnquiryManager.reply(e2, "im error"); // already reply
            System.out.println(a.getProject().getId());
            //ApplicationManager.book(bp);
            AppUserManager.logout();

            p.setVisibility(true);

            // TEST WITHDRAWAL
            AppUserManager.login("A","password");
            EnquiryManager.edit(e2, "nah jokes");
            ApplicationManager.withdraw();
            //Application ap2 = ApplicationManager.apply(p, FlatType.TWO_ROOM); //already have
            AppUserManager.logout();
            
            // TEST OVERBOOKING
            AppUserManager.login("B","password");
            Application bp2 = ApplicationManager.apply(p, FlatType.TWO_ROOM);
            AppUserManager.logout();

            AppUserManager.login("M", "password");
            System.out.println(o.getProjectInCharge().getId());
            //OfficerApplicationManager.approve(op, true); // not pending
            //ApplicationManager.approve(bp2, true); //not enough units
            ApplicationManager.approveWithdraw(ap,true);
            ApplicationManager.approve(bp2, true);
            // OfficerApplicationManager.apply(p); // cannot be cast
            // ApplicationManager.apply(p,null); // cannot be cast
            AppUserManager.logout();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}
