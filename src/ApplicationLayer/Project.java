package ApplicationLayer;

import GUI.TimeRegStage;

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
        if (client.getTempProject() != null)
            this.projectManager = client.getTempProject().projectManager;
        this.firm = firm;

    }

    public void setProjectManager() {
        Employee empl= firm.getFreeEmployees().get(0);
        ProjectManager manager = new ProjectManager(empl,this, firm);
        this.projectManager = manager;
    }

    public void setSpecficProjectManager(Employee empl){
        ProjectManager manager = new ProjectManager(empl,this, firm);
        this.projectManager = manager;
    }

    public void setProjectID(String newProjectID) {
        projectID = newProjectID;
    }

    public void setWorkingEmployees(List<Employee> workingEmployees) {
        this.workingEmployees = workingEmployees;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public void setDelegatedActivities(Map<Activity,Employee> delegatedActivities) {
        this.delegatedActivities = delegatedActivities;
    }

    public void updateEstimatedTimeUse(double h) {
        this.estimatedTimeUse = this.estimatedTimeUse + h;
    }

    public void updateTimeUsed(double timeUsed) {
        this.timeUsed = timeUsed;
    }

    public double getRemainingTime() {
        double remainingTime=estimatedTimeUse-timeUsed;
        return remainingTime;
    }

    public String makeProjectReport() {
        return  "Name = " + projectName + ", ID = " + projectID + ", Time used = " + timeUsed
                + ", Remaining time = " + (estimatedTimeUse-timeUsed) + ", Employees = " + workingEmployees + ", Activities = " + activities;
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

    public Map<Activity, Employee> getDelegatedActivities() {
        return delegatedActivities;
    }

    public void addToFirm(TimeManager firm){
        firm.getProjects().add(this);
    }

}
