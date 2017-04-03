
import java.util.List;

/**
 * Created by katrinethoft on 27/03/17.
 */
public class Employee {
    private String employeeName;
    private List<Activity> ongoingActivities;

    public Employee(String employeeName){
        this.employeeName = employeeName;

    }

    public boolean checkAbsense(String employeeName){
        //Do stuff

        return false;
    }


    public void timeRegistering(double hours, String employeeName){
        //Do stuff
    }

    public void editRegisteredTime(double hours, String employeeName, TimeManager day){
        //Do stuff
    }

    public String getEmployeeName(){
        return employeeName;
    }

    public List<Activity> getOngoingActivities(){
        return ongoingActivities;
    }

    public void setOngoingActivities(List<Activity> ongoingActivities){
        this.ongoingActivities = ongoingActivities;
    }
}
