package items;

import java.util.ArrayList;
import java.time.LocalDate;

import items.users.*;
import arrays.*;

/**
 * Represents a housing project with different types of flats, managed by a manager.
 */
public class Project extends Item implements Stringifiable, LongStringifiable {    
    private String name;
    private String neighborhood;
    private int num2Room;
    private int num3Room;
    private LocalDate openingDate;
    private LocalDate closingDate;
    private int officerSlots;
    private boolean visibility = true;
    private Manager manager;

    /**
     * Constructs a new Project with the specified details.
     * 
     * @param name the name of the project
     * @param neigh the neighborhood where the project is located
     * @param room2 the number of 2-room flats available
     * @param room3 the number of 3-room flats available
     * @param od the opening date of the project
     * @param cd the closing date of the project
     * @param oSlots the number of officer slots available
     * @param m the manager overseeing the project
     */
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

    /**
     * Edits the Project with the specified details.
     * 
     * @param name the name of the project
     * @param neigh the neighborhood where the project is located
     * @param room2 the number of 2-room flats available
     * @param room3 the number of 3-room flats available
     * @param od the opening date of the project
     * @param cd the closing date of the project
     * @param oSlots the number of officer slots available
     * @param m the manager overseeing the project
     */
    public void edit(String name, String neigh, int room2, int room3, LocalDate od, LocalDate cd, int oSlots, Manager m) {
        this.name = name;
        neighborhood = neigh;
        num2Room = room2;
        num3Room = room3;
        openingDate = od;
        closingDate = cd;
        officerSlots = oSlots;
        manager = m;
    }
    
    /**
     * @return the name of the project
     */
    public String getName() {
        return name;
    }
    
    /**
     * @return the neighborhood of the project
     */
    public String getNeighborhood() {
        return neighborhood;
    }
    
    /**
     * @return the number of 2-room flats available
     */
    public int getNum2Room() {
        return num2Room;
    }
    
    /**
     * @return the number of 3-room flats available
     */
    public int getNum3Room() {
        return num3Room;
    }
    
    /**
     * @return the opening date of the project
     */
    public LocalDate getOpeningDate() {
        return openingDate;
    }
    
    /**
     * @return the closing date of the project
     */
    public LocalDate getClosingDate() {
        return closingDate;
    }
    
    /**
     * @return the number of officer slots available
     */
    public int getOfficerSlots() {
        return officerSlots;
    }
    
    /**
     * @return whether the project is visible
     */
    public boolean isVisible() {
        return visibility;
    }
    
    /**
     * @return a list of applications for the project
     */
    public ArrayList<Application> getApplications() {
        return Applications.filter(this);
    }
    
    /**
     * @return a list of officer applications for the project
     */
    public ArrayList<OfficerApplication> getOfficerApplications() {
        return OfficerApplications.filter(this);
    }
    
    /**
     * @return a list of enquiries related to the project
     */
    public ArrayList<Enquiry> getEnquiries() {
        return Enquiries.filter(this);
    }

    /**
     * @return a list of applicants for the project
     */
    public ArrayList<Applicant> getApplicants() {
        return Users.filterApplicants(this);
    }

    /**
     * @return a list of officers assigned to the project
     */
    public ArrayList<Officer> getOfficers() {
        return OfficerApplications.getOfficers(this);
    }
    
    /**
     * @return the manager overseeing the project
     */
    public Manager getManager() {
        return manager;
    }

    // Setters

    /**
     * Sets the project name.
     * @param name the new project name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Sets the project neighborhood.
     * @param neighborhood the new neighborhood
     */
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
    
    /**
     * Sets the number of 2-room flats available.
     * @param num2Room the new number of 2-room flats
     */
    public void setNum2Room(int num2Room) {
        this.num2Room = num2Room;
    }
    
    /**
     * Sets the number of 3-room flats available.
     * @param num3Room the new number of 3-room flats
     */
    public void setNum3Room(int num3Room) {
        this.num3Room = num3Room;
    }
    
    /**
     * Sets the opening date of the project.
     * @param openingDate the new opening date
     */
    public void setOpeningDate(LocalDate openingDate) {
        this.openingDate = openingDate;
    }
    
    /**
     * Sets the closing date of the project.
     * @param closingDate the new closing date
     */
    public void setClosingDate(LocalDate closingDate) {
        this.closingDate = closingDate;
    }
    
    /**
     * Sets the number of officer slots.
     * @param officerSlots the new number of officer slots
     */
    public void setOfficerSlots(int officerSlots) {
        this.officerSlots = officerSlots;
    }
    
    /**
     * Sets the visibility of the project.
     * @param visibility the new visibility status
     */
    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    /**
     * Returns a string representation of the project.
     * 
     * @return a string describing the project
     */
    public String toString() {
        // Implementation here
        return "ID "+ getId() + ": " + name + " in " + neighborhood + ". Open from " + 
            openingDate.toString() + " to " + closingDate.toString() + ".";
    }

    /**
     * Returns a longer string representation of the project.
     * 
     * @return a string fully describing the project
     */
    public String toLongString() {
        return "Project ID " + getId() + ":\n" +
            "Name: " + name + "\n" +
            "Neighbourhood: " + neighborhood + "\n" +
            "2 Room Units Available: " + num2Room + "\n" +
            "3 Room Units Available: " + num3Room + "\n" +
            "Application Period: " + openingDate.toString() + " to " + 
                closingDate.toString() + "\n" +
            "Visible: " + ((visibility) ? "yes" : "no") + "\n";
    }
}
