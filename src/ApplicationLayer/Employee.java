package ApplicationLayer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by katrinethoft on 27/03/17.
 */
public class Employee {
    private String employeeName;
    private List<Activity> ongoingActivities;
    public boolean absence;
    public double registeredHours;
    public TimeManager firm;

    public Employee(String employeeName, TimeManager firm){
        this.employeeName = employeeName;
        this.absence = false;
        this.registeredHours = 0.0;
        this.firm = firm;
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

    public void updateAbsence() {
        if (!this.absence) {
            int count = 0;
            for (Activity a : ongoingActivities) {
                if (firm.getFreeEmployees() != null) {
                    a.getProject().projectManager.findSubstitute(a, this);
                    ongoingActivities.remove(a);
                    count++;
                }
                if (count == ongoingActivities.size()){
                    this.absence = true;
                    firm.getFreeEmployees().remove(this);
                }
            }
        } else {
            this.absence = false;
            firm.getFreeEmployees().add(this);
        }
    }

    public void updateRegisteredHours(double h) {
        this.registeredHours = this.registeredHours + h;
    }

    public void regHoursOnAct(double h, Activity act) {
        if (ongoingActivities.contains(act)) {
            act.updateTimeUsed(h);
            updateRegisteredHours(h);
        } else {
            System.out.println("activity is not in your ongoing activities");
        }
    }

    public void addToFirm(TimeManager firm){
        firm.getEmployees().add(this);
        firm.getFreeEmployees().add(this);
    }

    /* For testing purposes only

    public void setOngoingActivities() {
        List<Activity> acts = new ArrayList<Activity>();
        for (int i = 0; i <= 5; i++) {
            acts.add(new Activity("activity" + (i+1)));
        }
        this.ongoingActivities = acts;
    }*/
}
