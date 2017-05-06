package ApplicationLayer;

import java.util.*;

/**
 * Created by katrinethoft on 27/03/17.
 */
public class ProjectManager{
    public Employee employee;
    public Project project;
    public TimeManager firm;


    public ProjectManager(Employee employee01, Project project, TimeManager firm){
        this.employee = employee01;
        this.project = project;
        this.firm = firm;
        addToFirm(firm);
    }

    public void addToFirm(TimeManager firm){
        firm.getProjectManagers().add(this);
    }

    public void setEstTimeUse(Activity act, double estimatedTimeUse) {
        act.setEstimatedTimeUse(estimatedTimeUse);
    }

    public void createActivities(){ // called from delegateActivities
        int i = 0;
        List<Activity> activities = new ArrayList<Activity>();
        while (i <= project.getEstimatedTimeUse()) {
            activities.add(new Activity("activity" + (i/10+1)));
            activities.get(i/10).setEstimatedTimeUse(10);
            i+=10;
        }
        if (i-10 < project.getEstimatedTimeUse()){
            activities.add(new Activity("activity" + (i/10+1)));
            activities.get(i/10).setEstimatedTimeUse(project.getEstimatedTimeUse()-(i-10));
        }
    }

    public boolean getEmplForProj() { // called from delegateActivities
        for (int i = 0; i < project.getActivities().size(); i++){
            if (project.firm.getFreeEmployees().get(i) != null) {
                project.getWorkingEmployees().add(project.firm.getFreeEmployees().get(i));
            } else {
                return false;
            }
        }
        return true;
    }

    public void delegateActivities(){
        Map<Activity, Employee> delegatedActivities = new HashMap<Activity, Employee>();
        createActivities();
        if (getEmplForProj()) {
            for (int i = 0; i < project.getWorkingEmployees().size(); i++) {
                delegatedActivities.put(project.getActivities().get(i), project.getWorkingEmployees().get(i));
                project.getWorkingEmployees().get(i).getActivities().add(project.getActivities().get(i));
                if (project.getWorkingEmployees().get(i).getActivities().size() >= 10) {
                    project.firm.getFreeEmployees().remove(project.getWorkingEmployees().get(i));
                }
            }
            project.setDelegatedActivities(delegatedActivities);
        } else {
            project.setDelegatedActivities(null);
        }
    }

    public Employee getEmployee(){
        return employee;
    }

    public void findSubstitute(Activity act, Employee empl){ // only called from updateAbsence (Employee class)
        Employee newEmpl = project.firm.getFreeEmployees().get(0);
        project.getDelegatedActivities().replace(act, empl, newEmpl);
    }

    public void delayProject(double hours){
        project.updateEstimatedTimeUse(hours);
        project.endDate.date = project.endDate.date + (int)(Math.ceil(hours/8));    // amount of hours/8 (8 hrs. on a regular work day)
        while (project.endDate.date > 30) {
            project.endDate.date = project.endDate.date - 30;
            project.endDate.month += 1;
        }
        while (project.endDate.month > 12) {
            project.endDate.month = project.endDate.month - 12;
            project.endDate.year += 1;
        }
    }

    public void endProject(){
        project.active = false;
    }


}
