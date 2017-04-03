import java.util.Calendar;

/**
 * Created by EmilieKvist on 29-03-2017.
 */

public class Client {
    public TimeManager endDate;
    public Project newProject;

    public Client (TimeManager endDate, Project newProject){
        this.endDate = endDate;
        this.newProject = newProject;
    }

    public static void designateProjectManager(Employee empl){
        newProject.projectManager = empl;
    }
}
