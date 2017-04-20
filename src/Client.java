import java.util.Calendar;

/**
 * Created by EmilieKvist on 29-03-2017.
 */

public class Client {
    public String clientName;
    public TimeManager endDate;
    public double estimatedTimeUse;
    public String projectName;

    public Client (String clientName, TimeManager endDate, double estimatedTimeUse, String projectName){
        this.clientName = clientName;
        this.endDate = endDate;
        this.estimatedTimeUse = estimatedTimeUse;
        this.projectName = projectName;
    }

    public Client (String clientName,TimeManager endDate, double estimatedTimeUse, String projectName, Employee projectManager){
        this.clientName = clientName;
        this.endDate = endDate;
        this.estimatedTimeUse = estimatedTimeUse;
        this.projectName = projectName;
        designateProjectManager(projectManager);
    }


    public static void designateProjectManager(Employee empl){
       // Project.setProjectManager(empl);
    }

    public String getName() {
        return clientName;
    }


    public TimeManager getEndDate() {
        return endDate;
    }


    public double getEstimatedTimeUse() {
        return estimatedTimeUse;
    }
}
