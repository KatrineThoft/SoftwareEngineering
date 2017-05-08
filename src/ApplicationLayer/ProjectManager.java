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

    /*public Employee getEmployee(){
        return employee;
    }*/

   /* public void setEstTimeUse(Activity act, double estimatedTimeUse) {
        act.setEstimatedTimeUse(estimatedTimeUse);
    }*/

    public void createActivities(){ // called from delegateActivities
        int i = 0;
        while (i < project.getEstimatedTimeUse()/10) {
            project.getActivities().add(new Activity("activity " + (i+1), this.project));
            project.getActivities().get(i).setEstimatedTimeUse(10);
            i++;
        }
        if (project.getEstimatedTimeUse() % 10 != 0){
            project.getActivities().add(new Activity("activity " + (i+1), this.project));
            project.getActivities().get(i).setEstimatedTimeUse(project.getEstimatedTimeUse() % 10);
        }
    }

    public boolean getEmplForProj() { // called from delegateActivities
        if (firm.getFreeEmployees().size() < project.getActivities().size()) {
            return false;
        } else {
            for (int i = 0; i < project.getActivities().size(); i++) {
                project.getWorkingEmployees().add(firm.getFreeEmployees().get(i));
            }
            return true;
        }
    }


    /*public void getEmplForProj() { // called from delegateActivities
        for (int i = 0; i < project.getActivities().size(); i++){
            if (project.firm.getFreeEmployees().get(i) != null) {
                project.getWorkingEmployees().add(project.firm.getFreeEmployees().get(i));
            }// else {
               // return false;
            //}
        }
        //return true;
    }

    public boolean enoughEmpl() {
        if (project.getActivities().size() <= project.firm.getFreeEmployees().size()) {
            return true;
        } else {
            return false;
        }
    }*/

    public void delegateActivities(){
        Map<Activity, Employee> delegatedActivities = new HashMap<Activity, Employee>();
        createActivities();
        if (getEmplForProj()) {
            for (int i = 0; i < project.getActivities().size(); i++) {
                delegatedActivities.put(project.getActivities().get(i), project.getWorkingEmployees().get(i));
                project.getWorkingEmployees().get(i).addActivities(project.getActivities().get(i));
                if (project.getWorkingEmployees().get(i).getActivities().size() >= 10) {
                    project.firm.getFreeEmployees().remove(project.getWorkingEmployees().get(i));
                }
            }
            project.setDelegatedActivities(delegatedActivities);
        } else {
            project.setDelegatedActivities(null);
        }
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

    public String makeProjectReport() {
        String emplAsStr = "";
        for (Employee e : project.getWorkingEmployees()) {
            emplAsStr += e.getName() + "\n";
        }
        String actsAsStr = "";
        for (Activity a : project.getActivities()) {
            actsAsStr += a.getActivityName() + "\n";
        }
        return  "Name = " + project.projectName + "\nID = " + project.getProjectID() + "\nTime used = " + project.getTimeUsed()
                + "\nRemaining time = " + project.getRemainingTime() + "\nEmployees = " + emplAsStr + "\nActivities = " + actsAsStr;
    }

    public void endProject(){
        project.active = false;
    }


}
