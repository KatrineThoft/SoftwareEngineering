package ApplicationLayer;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Daniel Hildebrand on 27-03-2017.
 */
public class Project {
    public boolean active;
    public Client client;
    public String projectName;
    public Date endDate;
    private double estimatedTimeUse;
    private double timeUsed;
    public ProjectManager projectManager;
    private String projectID;
    private List<Employee> workingEmployees;
    private List<Activity> activities;
    private Map<Activity, Employee> delegatedActivities;
    public TimeManager firm;

    public Project(Client client, TimeManager firm) {
        this.active = true;
        this.client = client;
        this.projectName = client.projectName;
        this.endDate = client.endDate;
        this.estimatedTimeUse = client.estimatedTimeUse;
        this.timeUsed = 0;
        this.firm = firm;
        this.workingEmployees = new ArrayList<Employee>();
        this.activities = new ArrayList<Activity>();
        this.delegatedActivities = new HashMap<Activity,Employee>();
        if (client.wantedPM != null && firm.getFreeEmployees().contains(client.wantedPM)){
            this.projectManager = new ProjectManager(client.wantedPM, this, this.firm);
        } else if (!firm.getFreeEmployees().isEmpty()) {
            setProjectManager();
        } else {
            this.projectManager = null;
        }
        setProjectID();
        addToFirm(firm);
    }

    public void setProjectManager() {
        Employee empl = this.firm.getFreeEmployees().get(0);
        ProjectManager manager = new ProjectManager(empl,this, this.firm);
        this.projectManager = manager;
    }

    /*public void setSpecficProjectManager(Employee empl){
        ProjectManager manager = new ProjectManager(empl,this, firm);
        this.projectManager = manager;
    }*/

    public void setProjectID() {
        String val = ""+((int)(Math.random()*9000)+1000);
        this.projectID = endDate.year + val;
    }

    public String getProjectID() {
        return projectID;
    }

    public double getEstimatedTimeUse() {
        return estimatedTimeUse;
    }

    public double getTimeUsed() {
        return timeUsed;
    }

    public List<Employee> getWorkingEmployees() {
        return workingEmployees;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setDelegatedActivities(Map<Activity,Employee> delegatedActivities) {
        this.delegatedActivities = delegatedActivities;
    }

    public Map<Activity, Employee> getDelegatedActivities() {
        return delegatedActivities;
    }


    /*    public void setWorkingEmployees(List<Employee> workingEmployees) {
        this.workingEmployees = workingEmployees;
    }
*/
   /* public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }
*/

    public void updateTimeUsed(double timeUsed) {
        this.timeUsed = timeUsed;
    }

    public void updateEstimatedTimeUse(double h) {
        this.estimatedTimeUse = this.estimatedTimeUse + h;
    }

    public double getRemainingTime() {
        double remainingTime=estimatedTimeUse-timeUsed;
        return remainingTime;
    }

    public void addToFirm(TimeManager firm){
        firm.getProjects().add(this);
    }

}
