package arrays;

import java.util.ArrayList;

import items.Project;

public class Projects {
    private static ArrayList<Project> projectList = new ArrayList<>();
    private static int size=0;

    // Static method to get a project by its ID
    static Project getProject(int id) {
        return projectList.get(id);
    }

    // Static method to add a new project
    static void newProject(Project project) {
        project.setId(projectList.size());
        projectList.add(project);
        size++;
    }

    // Static method to delete a project
    static void deleteProject(Project project) {
        project.delete();
        size--;
    }

    // Static method to get all projects in the list
    static ArrayList<Project> getAllProjects() {
        return new ArrayList<>(projectList);
    }

    static int getSize() { return size; };
}
