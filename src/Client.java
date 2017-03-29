/**
 * Created by EmilieKvist on 29-03-2017.
 */

public class Client {
    public Date endDate;
    public Project newProject;

    public Client (Date endDate, Project newProject){
        this.endDate = endDate;
        this.newProject = newProject;
    }

    public static void designateProjectManager(Employee empl){
        newProject.projectManager = empl;
    }
}
