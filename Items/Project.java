package items;

import java.util.ArrayList;
import java.time.LocalDate;

import items.users.*;
import arrays.*;

public class Project extends Item {    
    private String name;
    private String neighborhood;
    private int num2Room;
    private int num3Room;
    private LocalDate openingDate;
    private LocalDate closingDate;
    private int officerSlots;
    private boolean visibility = true;
    private Manager manager;

    public Project(String name, String neigh, int room2, int room3, LocalDate od, LocalDate cd, int oSlots, Manager m) {
        this.name = name;
        neighborhood = neigh;
        num2Room = room2;
        num3Room = room3;
        openingDate = od;
        closingDate = cd;
        officerSlots = oSlots;
        manager = m;
    }
    
    public String getName() {
        return name;
    }
    
    public String getNeighborhood() {
        return neighborhood;
    }
    
    public int getNum2Room() {
        return num2Room;
    }
    
    public int getNum3Room() {
        return num3Room;
    }
    
    public LocalDate getOpeningDate() {
        return openingDate;
    }
    
    public LocalDate getClosingDate() {
        return closingDate;
    }
    
    public int getOfficerSlots() {
        return officerSlots;
    }
    
    public boolean isVisible() {
        return visibility;
    }
    
    public ArrayList<Application> getApplications() {
        return Applications.filter(this);
    }
    
    public ArrayList<OfficerApplication> getOfficerApplications() {
        return OfficerApplications.filter(this);
    }
    
    public ArrayList<Enquiry> getEnquiries() {
        return Enquiries.filter(this);
    }

    public ArrayList<Applicant> getApplicants() {
        return Users.filterApplicants(this);
    }

    public ArrayList<Officer> getOfficers() {
        return OfficerApplications.getOfficers(this);
    }
    
    public Manager getManager() {
        return manager;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }
    
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
    
    public void setNum2Room(int num2Room) {
        this.num2Room = num2Room;
    }
    
    public void setNum3Room(int num3Room) {
        this.num3Room = num3Room;
    }
    
    public void setOpeningDate(LocalDate openingDate) {
        this.openingDate = openingDate;
    }
    
    public void setClosingDate(LocalDate closingDate) {
        this.closingDate = closingDate;
    }
    
    public void setOfficerSlots(int officerSlots) {
        this.officerSlots = officerSlots;
    }
    
    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    public String toString() {
        //implementation here
        return "";
    }
}