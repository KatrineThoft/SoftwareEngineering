import java.util.Calendar;

/**
 * Created by EmilieKvist on 29-03-2017.
 */

public class Client {
    public String clientName;
    public Date endDate;
    public double estimatedTimeUse;
    public String projectName;
    private Project tempProject;

    public Client (String clientName, Date endDate, double estimatedTimeUse, String projectName){
        this.clientName = clientName;
        this.endDate = endDate;
        this.estimatedTimeUse = estimatedTimeUse;
        this.projectName = projectName;
    }

    public Client (String clientName,Date endDate, double estimatedTimeUse, String projectName, Employee projectManager){
        this.clientName = clientName;
        this.endDate = endDate;
        this.estimatedTimeUse = estimatedTimeUse;
        this.projectName = projectName;
        designateProjectManager(projectManager);
    }

    public void designateProjectManager(Employee empl){
    /*    if (TimeManager.getFreeEmployees().contains(empl)) {
            this.tempProject = new Project(this);
            this.tempProject.setProjectManager(empl);
        } else {
            this.tempProject = null;
        }*/
    int i = 1;
    }

    public Project getTempProject() {
        return tempProject;
    }

    // getter functions are not needed when fields are public
    /*
    public String getName() {
        return clientName;
    }


    public Date getEndDate() {
        return endDate;
    }


    public double getEstimatedTimeUse() {
        return estimatedTimeUse;
    }
    */
}
