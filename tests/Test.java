package tests;

import java.time.LocalDate;
import java.util.ArrayList;

import arrays.*;
import items.*;
import items.users.*;
import items.users.User.MaritalStatus;
import items.Application.*;
import managers.*;

public class Test {
    static Project p;
    static Project p2;
    static Project p3;
    static Project p4;
    static OfficerApplication op;
    static Application ap;
    static Application bp;
    static Enquiry e1;
    static Enquiry e2;
    static Officer o;
    static Officer o2;
    static Manager m;
    static Manager m2;
    static Applicant a;
    static Applicant b;
    static Applicant c;
    static Applicant d;
    static Applicant e;
    static Applicant f;
    static Applicant g;

    public static void main(String[] args) {
        try {
            ArrayList<User> u = new ArrayList<>();
            m = new Manager("S1234567M",  "password", 99, MaritalStatus.SINGLE);
            o = new Officer("S7654321O",  "password", 90, MaritalStatus.MARRIED);
            m2 = new Manager("S1234569M",  "password", 99, MaritalStatus.SINGLE);
            o2 = new Officer("S7654329O",  "password", 90, MaritalStatus.MARRIED);
            a = new Applicant("T7654321A",  "password", 35, MaritalStatus.SINGLE);
            b = new Applicant("T7654321B",  "password", 21, MaritalStatus.MARRIED);
            c = new Applicant("T7654321C", "password", 35, MaritalStatus.SINGLE); // Single, 35 years old
            d = new Applicant("T7654321D", "password", 25, MaritalStatus.MARRIED); // Married, 25 years old
            e = new Applicant("T7654321E", "password", 40, MaritalStatus.MARRIED); // Married, 40 years old
            f = new Applicant("T7654321F", "password", 34, MaritalStatus.SINGLE); // Single, under 21
            g = new Applicant("T7654321G", "password", 20, MaritalStatus.MARRIED); // Married, under 21
            u.add(m);
            u.add(o);
            u.add(m2);
            u.add(o2);
            u.add(a);
            u.add(b);
            u.add(c);
            u.add(d);
            u.add(e);
            u.add(f);
            u.add(g);
            Users.setUsers(u);

            testCase1_ValidUserLogin();
            testCase2_InvalidIC();
            testCase3_IncorrectPassword();
            testCase4_PasswordChangeFunctionality();
            testCase17_CreateBTOProject();
            testCase18_WrongApplicationPeriod();
            testCase10_OfficerApply();
            testCase6_ApplicantApply();
            testCase8_MultipleProjects();
            p.setVisibility(false);
            testCase9_EnquiryManagement();
            testCase24_NotYetOfficer();
            testCase21_22_ApproveApplication();
            testCase10_OfficerApplyDates();
            testCase14_EnquiryReply();
            p.setVisibility(true);
            testCase15_Booking();
            testCase22_Withdrawal();

            System.out.println("Passed!");

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
    }

    public static void testCase1_ValidUserLogin() {
        try {
            ApplicationManager.apply(p, null);
            throw new RuntimeException("Test Case 1 Failed: Able to act without logging in.");
        } catch (Exception e) {};
        try {
            AppUserManager.login("S1234567M", "password");
            AppUserManager.logout();
        } catch (Exception e) {
            System.out.println(e.toString());
            throw new RuntimeException("Test Case 1 Failed: Valid user login unsuccessful");
        }
    }

    public static void testCase2_InvalidIC() {
        try {
            AppUserManager.login("A1234567B","password");
            throw new RuntimeException("Test Case 1 Failed: Able to act without logging in.");
        } catch (Exception e) {};
        try {
            AppUserManager.login("S12345678A","password");
            throw new RuntimeException("Test Case 1 Failed: Able to act without logging in.");
        } catch (Exception e) {};
        try {
            AppUserManager.login("S12345678","password");
            throw new RuntimeException("Test Case 1 Failed: Able to act without logging in.");
        } catch (Exception e) {};
    }

    public static void testCase3_IncorrectPassword() {
        try {
            AppUserManager.login("S1234567M", "paswd");
            throw new RuntimeException("Test Case 3 Failed: Logged in with incorrect password");
        } catch (Exception e) {
            // Expected behavior, do nothing
        }
    }

    public static void testCase4_PasswordChangeFunctionality() {
        try {
            AppUserManager.login("S1234567M", "password");
            AppUserManager.changePassword("password", "testtest");
            AppUserManager.logout();
            AppUserManager.login("S1234567M", "testtest"); // Should work with new password
            AppUserManager.changePassword("testtest", "password");
            AppUserManager.logout();
        } catch (Exception e) {
            System.out.println(e.toString());
            throw new RuntimeException("Test Case 4 Failed: Password change unsuccessful");
        }
    }

    public static void testCase10_OfficerApply() {
        try {
            AppUserManager.login("S7654321O", "password");
            op = OfficerApplicationManager.apply(p);
            if (op.getStatus() != Status.PENDING) throw new AssertionError("expected pending state.");

            try {
                OfficerApplicationManager.apply(p); // already have
                throw new AssertionError("Expected error: Officer should not be able to apply twice.");
            } catch (Exception e) {
                // Expected error, do nothing
            }

            AppUserManager.logout();
        } catch (Exception e) {
            System.out.println(e.toString());
            throw new RuntimeException("Test Case 10 Failed");
        }
    }

    public static void testCase17_CreateBTOProject() {
        try {
            AppUserManager.login("S1234567M", "password");
            p = ProjectManager.create("a", "a", 1, 3, LocalDate.of(2025,3,2), LocalDate.of(2025,3,10), 1);
            p2 = ProjectManager.create("a", "a", 1, 3, LocalDate.of(2025,3,11), LocalDate.of(2025,3,13), 1);
            p3 = ProjectManager.create("a", "a", 1, 3, LocalDate.of(2025,3,1), LocalDate.of(2025,3,1), 1);
            AppUserManager.logout();

            AppUserManager.login("S1234569M", "password");
            p4 = ProjectManager.create("a", "a", 1, 3, LocalDate.of(2025,2,1), LocalDate.of(2025,3,2), 1);
            AppUserManager.logout();
        } catch (Exception e) {
            System.out.println(e.toString());
            throw new RuntimeException("Test Case 17 Failed: Project creation unsuccessful");
        }
    }

    public static void testCase18_WrongApplicationPeriod() {
        try {
            AppUserManager.login("S1234567M", "password");
            try {
                ProjectManager.create("a", "a", 1, 3, LocalDate.of(2026,3,2), LocalDate.of(2026,1,10), 1);
                throw new AssertionError("Expected error: end date before start date");
            } catch (Exception e) {}
            try {
                ProjectManager.create("a", "a", 1, 3, LocalDate.of(2025,2,1), LocalDate.of(2025,3,1), 1);
                throw new AssertionError("Expected error: overlap");
            } catch (Exception e) {}
            try {
                ProjectManager.create("a", "a", 1, 3, LocalDate.of(2025,3,13), LocalDate.of(2025,3,14), 1);
                throw new AssertionError("Expected error: overlap");
            } catch (Exception e) {}
            AppUserManager.logout();
        } catch (Exception e) {
            System.out.println(e.toString());
            throw new RuntimeException("Test Case 18 Failed");
        }
    }
        
    public static void testCase6_ApplicantApply() {
        try {
            AppUserManager.login("T7654321A", "password");
            ap = ApplicationManager.apply(p, FlatType.TWO_ROOM);
            if (ap.getStatus() != Status.PENDING) throw new AssertionError("expected pending state");
            AppUserManager.logout();

            AppUserManager.login("T7654321B","password");
            bp = ApplicationManager.apply(p, FlatType.THREE_ROOM);
            AppUserManager.logout();
            
            AppUserManager.login("T7654321C", "password");
            try {
                // Should fail - cannot apply for 3-Room
                ApplicationManager.apply(p, FlatType.THREE_ROOM); // Should fail
                throw new AssertionError("Expected failure: Single applicant above 35 should not be able to apply for a 3-Room flat.");
            } catch (Exception e1) {
                // Expected error when trying to apply for 3-Room, do nothing
            }
            ApplicationManager.apply(p, FlatType.TWO_ROOM); // Should succeed
            AppUserManager.logout();

            // Test for Married, 21 and above - Can apply for any flat type (2-Room or 3-Room)
            AppUserManager.login("T7654321D", "password");
            ApplicationManager.apply(p, FlatType.THREE_ROOM); // Should succeed
            AppUserManager.logout();

            AppUserManager.login("T7654321E", "password");
            ApplicationManager.apply(p, FlatType.THREE_ROOM); // Should succeed
            AppUserManager.logout();

            // Test for Underage Single Applicant (under 34) - Should fail to apply
            AppUserManager.login("T7654321F", "password");
            try {
                // Should fail - cannot apply if underage (single, below 21)
                ApplicationManager.apply(p, FlatType.TWO_ROOM); // Should fail
                throw new AssertionError("Expected failure: Single applicant under 21 should not be able to apply for any flat.");
            } catch (Exception e1) {
                // Expected error, do nothing
            }
            AppUserManager.logout();

            // Test for Underage Married Applicant (under 21) - Should fail to apply
            AppUserManager.login("T7654321G", "password");
            try {
                // Should fail - cannot apply if underage (married, below 21)
                ApplicationManager.apply(p, FlatType.TWO_ROOM); // Should fail
                throw new AssertionError("Expected failure: Married applicant under 21 should not be able to apply for any flat.");
            } catch (Exception e1) {
                // Expected error, do nothing
            }
            AppUserManager.logout();
        } catch (Exception e) {
            System.out.println(e.toString());
            throw new RuntimeException("Test Case 6 Falied");
        }
    }

    public static void testCase8_MultipleProjects() {
        try {
            AppUserManager.login("T7654321A", "password");
            try {
                ApplicationManager.apply(p4, FlatType.TWO_ROOM); // already have
                throw new AssertionError("Expected error: Applicant should not be able to apply twice.");
            } catch (Exception e) {
                // Expected error, do nothing
            }
            AppUserManager.logout();

            AppUserManager.login("T7654321B","password");
            try {
                ApplicationManager.apply(p2, FlatType.TWO_ROOM); // already have
                throw new AssertionError("Expected error: Applicant should not be able to apply twice.");
            } catch (Exception e) {
                // Expected error, do nothing
            }
            AppUserManager.logout();
            
        } catch (Exception e) { 
            System.out.println(e.toString());
            throw new RuntimeException("Test Case 9 Failed");
        }
    }
    
    public static void testCase9_EnquiryManagement() {
        try {
            AppUserManager.login("T7654321A","password");
            e1 = EnquiryManager.create(p, "why r u gae");
            if (e1 != Enquiries.getEnquiry(0)) {
                throw new AssertionError("Enquiry creation or retrieval failed.");
            }
        
            e2 = EnquiryManager.create(p, "who says im gae");
            AppUserManager.logout();
            
            AppUserManager.login("T7654321B", "password");
            try {
                EnquiryManager.reply(e1, "i am error"); // wrong user type
                throw new AssertionError("Expected error: Incorrect user type should not be able to reply.");
            } catch (Exception e) {
                // Expected error, do nothing
            }
            AppUserManager.logout();
        } catch (Exception e) { 
            System.out.println(e.toString());
            throw new RuntimeException("Test Case 9 Failed");
        }
    }

    public static void testCase24_NotYetOfficer() {
        try {
            AppUserManager.login("S7654321O", "password");
        
            try {
                EnquiryManager.reply(e2, "errors"); // not in charge
                throw new AssertionError("Expected error: Officer should not be able to reply to an enquiry they are not in charge of.");
            } catch (Exception e) {
                // Expected error, do nothing
            }
        
            try {
                ApplicationManager.approve(ap, false); // cannot be cast
                throw new AssertionError("Expected error: Officer should not be able to approve an application.");
            } catch (Exception e) {
                // Expected error, do nothing
            }
        
            try {
                EnquiryManager.edit(e2, "error"); // not valid applicant
                throw new AssertionError("Expected error: Non-applicant should not be able to edit enquiry.");
            } catch (Exception e) {
                // Expected error, do nothing
            }
        
            try {
                ApplicationManager.book(ap); // not in charge
                throw new AssertionError("Expected error: Officer should not be able to book a flat when not in charge.");
            } catch (Exception e) {
                // Expected error, do nothing
            }
        
            AppUserManager.logout();
        } catch (Exception e) { 
            System.out.println(e.toString());
            throw new RuntimeException("Test Case 24 Failed");
        }
    }

    public static void testCase21_22_ApproveApplication() {
        try {
            AppUserManager.login("S1234567M", "password");
    
            OfficerApplicationManager.approve(op, true); // approval process
            ApplicationManager.approve(ap, true); // approving application
            ApplicationManager.approve(bp, false); // disapproving application

            if (op.getStatus() != Status.SUCCESSFUL || ap.getStatus() != Status.SUCCESSFUL || bp.getStatus() != Status.UNSUCCESSFUL) {
                throw new AssertionError("Expected status to change!");
            }
    
            AppUserManager.logout();

            // TEST OVERBOOKING
            AppUserManager.login("T7654321B","password");
            try {
                ApplicationManager.apply(p, FlatType.TWO_ROOM);
                throw new AssertionError("Expected error: Applying when no more rooms should fail.");
            } catch (Exception e) {
                // Expected error, do nothing
            }
            AppUserManager.logout();
        } catch (Exception e) {
            System.out.println(e.toString());
            throw new RuntimeException("Test Case 21_22 ApproveApplication Failed");
        }
    }

    public static void testCase10_OfficerApplyDates() {
        try {
            AppUserManager.login("S7654321O", "password");
            try {
                OfficerApplicationManager.apply(p); // already have
                throw new AssertionError("Expected error: already have");
            } catch (Exception e) {
                // Expected error, do nothing
            }

            try {
                OfficerApplicationManager.apply(p4);
                throw new AssertionError("Expected error: Overlap");
            } catch (Exception e) {
                // Expected error, do nothing
            }

            OfficerApplicationManager.apply(p2);
            ApplicationManager.apply(p4,FlatType.TWO_ROOM);
            AppUserManager.logout();
        } catch (Exception e) {
            System.out.println(e.toString());
            throw new RuntimeException("Test Case 10 Failed");
        }
    }

    public static void testCase14_EnquiryReply() {
        try {
            AppUserManager.login("S1234567M", "password");
    
            EnquiryManager.reply(e1, "u are gae"); // reply to an enquiry
            EnquiryManager.editReply(e1, "actually ur not"); // editing the reply
    
            AppUserManager.logout();

            AppUserManager.login("S7654321O", "password");
            EnquiryManager.reply(e2, "why r u gae"); // reply to an enquiry as Officer
        

            try {
                EnquiryManager.reply(e2, "im error"); // already replied
                throw new AssertionError("Expected error: Officer should not be able to reply again after already replying.");
            } catch (Exception e) {
                // Expected error, do nothing
            }

            AppUserManager.logout();
        } catch (Exception e) {
            System.out.println(e.toString());
            throw new RuntimeException("Test Case 14 Failed");
        }
    }
    
    public static void testCase15_Booking() {
        try {
            AppUserManager.login("S7654321O", "password");
            System.out.println(o.getProjectsInCharge().get(0).getId()); // check if Officer has projects in charge
    
            try {
                OfficerApplicationManager.apply(p); // already have
                throw new AssertionError("Expected Officer to be in charge, but an error occurred.");
            } catch (Exception e) {
                
            }
            
            try {
                System.out.println(a.getProject().getId()); // printing project id for validation
                throw new AssertionError("Expected project to be null, but an error occurred.");
            } catch (Exception e) {
                
            }
            
            ApplicationManager.book(ap); // booking application
            if (ap.getStatus() != Status.BOOKED) throw new AssertionError("Expected booked status.");
    
            try {
                ApplicationManager.book(bp); // try booking another application
                throw new AssertionError("Expected error: Booking an already booked application should fail.");
            } catch (Exception e) {
                // Expected error, do nothing
            }
    
            AppUserManager.logout();

            // TEST OVERBOOKING
            System.out.println(p.getNum2Room());

            AppUserManager.logout();

            
        } catch (Exception e) {
            System.out.println(e.toString());
            throw new RuntimeException("Test Case 15 Failed");
        }
    }

    public static void testCase22_Withdrawal() {
        try {
            AppUserManager.login("T7654321A", "password");
            if (ap.getWithdrawing() != WithdrawStatus.NONE) throw new AssertionError("Expected none Wstatus.");
            ApplicationManager.withdraw();
            if (ap.getWithdrawing() != WithdrawStatus.PENDING) throw new AssertionError("Expected pending Wstatus.");
    
            try {
                ApplicationManager.apply(p, FlatType.TWO_ROOM); // already have
                throw new AssertionError("Expected error: User should not be able to apply for a new application when they already have one.");
            } catch (Exception e) {
                // Expected error, do nothing
            }
    
            AppUserManager.logout();

            AppUserManager.login("T7654321B", "password");
            bp = ApplicationManager.apply(p, FlatType.TWO_ROOM);
            AppUserManager.logout();
    
            AppUserManager.login("S1234567M", "password");
            System.out.println(o.getProjectsInCharge().get(0).getId());

    
            // Testing invalid approval: application not pending
            try {
                OfficerApplicationManager.approve(op, true); // not pending
                throw new AssertionError("Expected error: Application should not be approved as it is not pending.");
            } catch (Exception e) {
                // Expected error, do nothing
            }
    
            // Testing invalid approval: not enough units
            try {
                ApplicationManager.approve(bp, true); // not enough units
                throw new AssertionError("Expected error: Application approval should fail due to insufficient units.");
            } catch (Exception e) {
                // Expected error, do nothing
            }

            ApplicationManager.approveWithdraw(ap, true); // approving the withdrawal of an application
            if (ap.getStatus() != Status.WITHDRAWN) throw new AssertionError("expected withdrawn status");
            if (ap.getWithdrawing() != WithdrawStatus.SUCCESSFUL) throw new AssertionError("expected success Wstatus");
            ApplicationManager.approve(bp, true); // approving application bp

            try {
                OfficerApplicationManager.apply(p); // cannot be cast
                throw new AssertionError("Expected error: Officer cannot apply.");
            } catch (Exception e) {
                // Expected error, do nothing
            }
    
            // ApplicationManager.apply with null FlatType - expecting cast failure
            try {
                ApplicationManager.apply(p, null); // cannot be cast
                throw new AssertionError("Expected error: Application cannot be applied with null FlatType.");
            } catch (Exception e) {
                // Expected error, do nothing
            }
    
            AppUserManager.logout();
        } catch (Exception e) {
            System.out.println(e.toString());
            throw new RuntimeException("Test Case 22 Failed");
        }
    }
}
