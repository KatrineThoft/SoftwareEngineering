import java.sql.Time;


/**
 * Created by EmilieKvist on 29-03-2017.
 */

public class Client {
    public String clientName;
    public Date endDate;
    public double estimatedTimeUse;
    public String projectName;
    private Project tempProject;
    public TimeManager firm;

    public Client (String clientName, Date endDate, double estimatedTimeUse, String projectName, TimeManager firm){
        this.clientName = clientName;
        this.endDate = endDate;
        this.estimatedTimeUse = estimatedTimeUse;
        this.projectName = projectName;
        this.firm = firm;
        addToFirm(firm);
    }

    public Client (String clientName, Date endDate, double estimatedTimeUse, String projectName, Employee projectManager, TimeManager firm){
        this.clientName = clientName;
        this.endDate = endDate;
        this.estimatedTimeUse = estimatedTimeUse;
        this.projectName = projectName;
        this.firm = firm;
        addToFirm(firm);
        designateProjectManager(projectManager);
    }

    public void designateProjectManager(Employee empl){
        if (this.firm.getFreeEmployees().contains(empl)) {
            this.tempProject = new Project(this, this.firm);
            this.tempProject.setProjectManager(empl);
        } else {
            this.tempProject = null;
        }
    int i = 1;
    }

    public Project getTempProject() {
        return tempProject;
    }

    public void addToFirm(TimeManager firm){
        firm.getClients().add(this);
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
