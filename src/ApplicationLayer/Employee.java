package ApplicationLayer;

import java.util.*;

/**
 * Created by katrinethoft on 27/03/17.
 */
//Class representing the employee object
public class Employee {
	//Creating the fields
    private String employeeName;
    public boolean absence;
    private List<Activity> ongoingActivities;
    public Map<Date,Double> registeredHours;
    public TimeManager firm;
    
    //Constructor
    public Employee(String employeeName, TimeManager firm){
        this.employeeName = employeeName;
        this.absence = false;
        this.ongoingActivities = new ArrayList<Activity>();
        this.registeredHours = new HashMap<Date,Double>();
        this.firm = firm;
        addToFirm(firm);
    }

    public String getName() {
        return employeeName;
    }

    public List<Activity> getActivities() {
        return ongoingActivities;
    }

    //Method to add an activity to the employee's list if activities
    public void addActivities(Activity activity) {
        this.ongoingActivities.add(activity);
    }

    //Method for registering as absent
    public void updateAbsence() {
        if (!this.absence) {
           
            if (firm.getFreeEmployees().size() >= ongoingActivities.size()) {
                for (Activity a : ongoingActivities) {
                    
                    a.getProject().projectManager.findSubstitute(a, this);    
                }  
                ongoingActivities.removeAll(ongoingActivities);
                this.absence = true;
                firm.getFreeEmployees().remove(this);
            }
        } else {
            this.absence = false;
            firm.getFreeEmployees().add(this);
        }
    }

    //Method for edit registered hours
    public boolean updateRegisteredHours(Date date, double h) {
        Calendar date1 = Calendar.getInstance();
        int thisDay = date1.get(Calendar.DATE);
        int thisMonth = date1.get(Calendar.MONTH)+1;
        int thisYear = date1.get(Calendar.YEAR);
        if (date.year > thisYear || (date.month > thisMonth && date.year == thisYear) || (date.date > thisDay && date.month == thisMonth && date.year == thisYear))
            return false;
        if (h <= 8) {
            if (this.registeredHours.containsKey(date)) {
                this.registeredHours.replace(date, h);
                return true;
            } else {
                this.registeredHours.put(date, h);
                return true;
            }
        } else {
            if (this.registeredHours.containsKey(date)) {
                this.registeredHours.replace(date, 8.0);
                return true;
            } else {
                this.registeredHours.put(date, 8.0);
                return true;
            }
        }
    }

    //Method for registering hours on a specific activity
    public void regHoursOnAct(double h, Activity act) {
        if (this.ongoingActivities.contains(act) && h+act.getTimeUsed() <= act.getEstimatedTimeUse()) {
            act.updateTimeUsed(h);
        }
    }

    //Adding the employee to our timemanager
    public void addToFirm(TimeManager firm){
        firm.getEmployees().add(this);
        firm.getFreeEmployees().add(this);
    }

}
