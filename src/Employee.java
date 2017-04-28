
import java.sql.Time;
import java.util.List;

/**
 * Created by katrinethoft on 27/03/17.
 */
public class Employee {
    private String employeeName;
    private List<Activity> ongoingActivities;
    public boolean absence;
    public double registeredHours;

    public Employee(String employeeName, TimeManager firm){
        this.employeeName = employeeName;
        this.absence = false;
        this.registeredHours = 0.0;
        addToFirm(firm);
    }

    public void setActivities(List<Activity> activities) {
        this.ongoingActivities = activities;
    }

    public List<Activity> getActivities() {
        return ongoingActivities;
    }

    public String getName() {
        return employeeName;
    }

    public void updateAbsence(boolean b) {
        this.absence = b;
    }

    public void updateRegisteredHours(double v) {
        this.registeredHours = this.registeredHours + v;
    }

    public void addToFirm(TimeManager firm){
        firm.getEmployees().add(this);
    }


}
