package items;

import java.util.ArrayList;

import items.users.*;
import arrays.*;

public class Project extends Item {
    public enum FlatType {
        TWO_ROOM, THREE_ROOM
    }
    
    private String name;
    private String neighborhood;
    private FlatType flatType;
    private String units;
    private String openingDate;
    private String closingDate;
    private int officerSlots;
    private boolean visibility;
    
    public String getName() {
        return name;
    }
    
    public String getNeighborhood() {
        return neighborhood;
    }
    
    public FlatType getFlatType() {
        return flatType;
    }
    
    public String getUnits() {
        return units;
    }
    
    public String getOpeningDate() {
        return openingDate;
    }
    
    public String getClosingDate() {
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
    
    public ArrayList<Application> getOfficerApplications() {
        return OfficerApplications.filter(this);
    }
    
    public ArrayList<Enquiry> getEnquiries() {
        return Enquiries.filter(this);
    }

    public ArrayList<Officer> getOfficers() {
        return Users.filterOfficers(this);
    }
    
    public Manager getManager() {
        return Users.filterManager(this);
    }

    public String toString() {
        //implementation here
        return "";
    }
}