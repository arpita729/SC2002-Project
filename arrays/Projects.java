package arrays;

import java.util.ArrayList;

import items.Project;

public class Projects {
    private static ArrayList<Project> projectList = new ArrayList<>();
    private static int size=0;

    // Static method to get a project by its ID
    public static Project getProject(int id) {
        return projectList.get(id);
    }

    // Static method to add a new project
    public static void newProject(Project project) {
        project.setId(projectList.size());
        projectList.add(project);
        size++;
    }

    // Static method to delete a project
    public static void deleteProject(Project project) {
        project.delete();
        size--;
    }

    // Static method to get all projects in the list
    public static ArrayList<Project> getAllProjects() {
        return new ArrayList<>(projectList);
    }

    public static int getSize() { return size; };

    public static void setProjects(ArrayList<Project> p) {
        projectList = p;
        size = p.size(); // assume no deleteds
    }

    // TODO filters for flattype, location, etc. 
}
