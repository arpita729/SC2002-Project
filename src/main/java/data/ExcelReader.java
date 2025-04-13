/**
 * The {@code ExcelReader} class provides utility methods to load user and project data
 * from Excel spreadsheets into the application.
 * <p>
 * It supports reading and parsing applicant, officer, and manager details,
 * as well as project data with associated officers and managers.
 */
package data;

import java.io.FileInputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import arrays.*;
import items.OfficerApplication;
import items.Project;
import items.Application.Status;
import items.users.*;
import items.users.User.MaritalStatus;

public class ExcelReader {

    /**
     * Date formatter used to parse project start and end dates
     * in the format "d-MMM-yyyy" (e.g., "15-Feb-2025").
     */
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");

    /**
     * Retrieves a {@link User} object by name from the system's user list.
     *
     * @param name the name of the user to find
     * @return the {@code User} object matching the provided name
     */
    public static User getUser(String name) {
        return Users.getAllUsers().stream().filter(
            (user) -> user.getName().equals(name)
        ).toList().get(0);
    }

    /**
     * Functional interface for adding a user, used to generalize loading
     * different types of users (Applicant, Officer, Manager).
     */
    private interface AddUser {
        /**
         * Adds a user with the given attributes.
         *
         * @param ic the identity card number of the user
         * @param name the name of the user
         * @param password the password for the user
         * @param age the age of the user
         * @param m the marital status of the user
         */
        void addUser(String ic, String name, String password, int age, MaritalStatus m);
    }

    /**
     * Loads users from the specified Excel file and applies a custom user-adding function.
     *
     * @param filename the path to the Excel file
     * @param addUser a lambda or functional implementation for creating and storing users
     */
    public static void loadUsersFromFile(String filename, AddUser addUser) {
        try {
            FileInputStream file = new FileInputStream(filename);
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                addUser.addUser(
                    row.getCell(1).toString(),
                    row.getCell(0).toString(),
                    row.getCell(4).toString(),
                    (int) row.getCell(2).getNumericCellValue(),
                    row.getCell(3).toString().equals("Single") ? MaritalStatus.SINGLE : MaritalStatus.MARRIED
                );
            }

            workbook.close();
        } catch (Exception e) {
            System.out.println("Error loading users.");
            e.printStackTrace();
        }
    }

    /**
     * Loads all types of users (Applicants, Officers, Managers) from their respective Excel files
     * and stores them in the application's global user list.
     */
    public static void loadUsers() {
        loadUsersFromFile("Details/ApplicantList.xlsx", (ic, name, password, age, m) -> {
            User u = new Applicant(ic, name, password, age, m);
            Users.newUser(u);
        });
        loadUsersFromFile("Details/OfficerList.xlsx", (ic, name, password, age, m) -> {
            User u = new Officer(ic, name, password, age, m);
            Users.newUser(u);
        });
        loadUsersFromFile("Details/ManagerList.xlsx", (ic, name, password, age, m) -> {
            User u = new Manager(ic, name, password, age, m);
            Users.newUser(u);
        });
        System.out.println("Users Loaded.");
    }

    /**
     * Loads project data from an Excel file, including associated managers and officers.
     * <p>
     * Each project is created with its corresponding metadata, assigned manager,
     * and successful officer applications.
     */
    public static void loadProjects() {
        try {
            FileInputStream file = new FileInputStream("Details/ProjectList.xlsx");
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);

                Manager m = (Manager) getUser(row.getCell(10).toString());

                Project p = new Project(
                    row.getCell(0).toString(),
                    row.getCell(1).toString(),
                    (int) row.getCell(3).getNumericCellValue(),
                    (int) row.getCell(6).getNumericCellValue(),
                    LocalDate.parse(row.getCell(8).toString(), formatter),
                    LocalDate.parse(row.getCell(9).toString(), formatter),
                    (int) row.getCell(11).getNumericCellValue(),
                    m
                );
                Projects.newProject(p);

                // Handle officer applications for the project
                for (String name : row.getCell(12).toString().split(",")) {
                    OfficerApplication oa = new OfficerApplication((Officer) getUser(name), p);
                    oa.setStatus(Status.SUCCESSFUL);
                    OfficerApplications.newOfficerApplication(oa);
                }
            }
            System.out.println("Projects Loaded.");
            workbook.close();
        } catch (Exception e) {
            System.out.println("Error loading projects.");
            e.printStackTrace();
        }
    }
}
