import java.util.Calendar;

/**
 * Created by EmilieKvist on 29-03-2017.
 */

public class Client {
    public String clientName;
    public TimeManager endDate;
    public Project newProject;

    public Client (String clientName,TimeManager endDate, Project newProject){
        this.clientName = clientName;
        this.endDate = endDate;
        this.newProject = newProject;
    }

    public Client (String clientName,TimeManager endDate, Project newProject, Employee projectManager){
        this.clientName = clientName;
        this.endDate = endDate;
        this.newProject = newProject;
        designateProjectManager(projectManager);
    }


    public static void designateProjectManager(Employee empl){
        newProject.setProjectManager(empl);
    }
}
