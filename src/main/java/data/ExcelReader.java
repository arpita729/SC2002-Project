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
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");

    public static User getUser(String name) {
        return Users.getAllUsers().stream().filter(
            (user)->user.getName().equals(name)
        ).toList().get(0);
    }

    private interface AddUser {
        public void addUser(String ic, String name, String password, int age, MaritalStatus m);
    }

    public static void loadUsersFromFile(String filename, AddUser addUser) {
        try {
            FileInputStream file = new FileInputStream(filename);
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);

            for (int i=1;i<=sheet.getLastRowNum();i++) {
                Row row = sheet.getRow(i);
                addUser.addUser(
                    row.getCell(1).toString(), 
                    row.getCell(0).toString(), 
                    row.getCell(4).toString(), 
                    (int)row.getCell(2).getNumericCellValue(), 
                    row.getCell(3).toString().equals("Single") ? MaritalStatus.SINGLE : MaritalStatus.MARRIED
                );
            }

            workbook.close();
        } catch (Exception e) {
            System.out.println("Error loading users.");
            e.printStackTrace();
        }
    }

    public static void loadUsers() {
        loadUsersFromFile("Details/ApplicantList.xlsx",(ic, name, password, age, m)->{
            User u = new Applicant(ic, name, password, age, m);
            Users.newUser(u);
        });
        loadUsersFromFile("Details/OfficerList.xlsx",(ic, name, password, age, m)->{
            User u = new Officer(ic, name, password, age, m);
            Users.newUser(u);
        });
        loadUsersFromFile("Details/ManagerList.xlsx",(ic, name, password, age, m)->{
            User u = new Manager(ic, name, password, age, m);
            Users.newUser(u);
        });
        System.out.println("Users Loaded.");
    }
    public static void loadProjects() {
        try {
            FileInputStream file = new FileInputStream("Details/ProjectList.xlsx");
            Workbook workbook = new XSSFWorkbook(file);

            Sheet sheet = workbook.getSheetAt(0);

            for (int i=1;i<=sheet.getLastRowNum();i++) {
                Row row = sheet.getRow(i);

                Manager m = (Manager)getUser(row.getCell(10).toString());

                Project p = new Project(
                    row.getCell(0).toString(), 
                    row.getCell(1).toString(), 
                    (int)row.getCell(3).getNumericCellValue(), 
                    (int)row.getCell(6).getNumericCellValue(), 
                    LocalDate.parse(row.getCell(8).toString(), formatter), 
                    LocalDate.parse(row.getCell(9).toString(), formatter), 
                    (int)row.getCell(11).getNumericCellValue(), 
                    m
                );
                Projects.newProject(p);

                // handle officers
                for (String name:row.getCell(12).toString().split(",")) {
                    OfficerApplication oa =  new OfficerApplication((Officer)getUser(name), p);
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