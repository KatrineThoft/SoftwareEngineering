package ApplicationLayer;

import java.util.*;




/**
 * Created by katrinethoft on 27/03/17.
 */
public class Employee {
    private String employeeName;
    private List<Activity> ongoingActivities;
    public boolean absence;
    public Map<Date,Double> registeredHours;
    public TimeManager firm;

    public Employee(String employeeName, TimeManager firm){
        this.employeeName = employeeName;
        this.absence = false;
        this.registeredHours = new HashMap<Date,Double>();

        this.ongoingActivities = new ArrayList<Activity>();
        this.firm = firm;
        addToFirm(firm);
    }

    public void addActivities(Activity activity) {
        this.ongoingActivities.add(activity);
    }

    public List<Activity> getActivities() {
        return ongoingActivities;
    }

    public String getName() {
        return employeeName;
    }

    public void updateAbsence() {
        if (!this.absence) {
            //int count = 0;
            if (firm.getFreeEmployees().size() >= ongoingActivities.size()) {
                for (Activity a : ongoingActivities) {
                    //if (firm.getFreeEmployees() != null) {
                    a.getProject().projectManager.findSubstitute(a, this);
                    //ongoingActivities.remove(a);
                    //count++;
                }
                //if (count == ongoingActivities.size()){
                ongoingActivities.removeAll(ongoingActivities);
                this.absence = true;
                firm.getFreeEmployees().remove(this);
                //}
            }
        } else {
            this.absence = false;
            firm.getFreeEmployees().add(this);
        }
    }

    public boolean updateRegisteredHours(Date date, double h) {
        Calendar date1 = Calendar.getInstance();
        int thisDay = date1.get(Calendar.DATE);
        int thisMonth = date1.get(Calendar.MONTH)+1;
        int thisYear = date1.get(Calendar.YEAR);
        System.out.println("in employee: d: " + thisDay + " m: " + thisMonth + " y: " + thisYear);
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

    public void regHoursOnAct(double h, Activity act) {
        if (this.ongoingActivities.contains(act) && h+act.getTimeUsed() <= act.getEstimatedTimeUse()) {
            act.updateTimeUsed(h);
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
