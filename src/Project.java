import java.sql.Time;
import java.util.List;

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
    private String projectID;
    public ProjectManager projectManager;
    private List<Employee> workingEmployees;
    private List<Activity> activities;

    public Project(Client client) {
        this.active = true;
        this.client = client;
        this.projectName = client.projectName;
        this.endDate = client.endDate;
        this.estimatedTimeUse = client.estimatedTimeUse;
        this.timeUsed = 0;
    }

    public void setProjectID(String newProjectID) {
        projectID = newProjectID;
    }

    public void setProjectManager(Employee projectManager) {
        ProjectManager manager = new ProjectManager(projectManager,this);
        this.projectManager = manager;
    }

    public void setWorkingEmployees(List<Employee> workingEmployees) {
        this.workingEmployees = workingEmployees;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public double updateEstimatedTimeUse(double estimatedTimeUse) {
        return estimatedTimeUse;
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

}
