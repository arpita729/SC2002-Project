package items;

import items.users.Officer;

/**
 * Represents an officer's application to a project.
 */
public class OfficerApplication extends Application {
    /**
     * Constructs an OfficerApplication object.
     *
     * @param o the officer applying for the project
     * @param p the project the officer is applying to
     */
    public OfficerApplication(Officer o, Project p) {
        super(o, p, null);
    }
}
