package ApplicationLayer;

import java.util.*;

/**
 * Created by katrinethoft on 27/03/17.
 */
//Class representing the project manager object.
//ProjectManager is a subclass of the Employee class
public class ProjectManager{
	//Creating the fields
    public Employee employee;
    public Project project;
    public TimeManager firm;

    //Constructor
    public ProjectManager(Employee employee01, Project project, TimeManager firm){
        this.employee = employee01;
        this.project = project;
        this.firm = firm;
        addToFirm(firm);
    }

    //Adding the project manager to the TimeManager
    public void addToFirm(TimeManager firm){
        firm.getProjectManagers().add(this);
    }

    //Creating activities for the project using the estimated time
    //As a starting point all activities have an estimated time use of 10 hours
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

    //Method that checks whether or not there is enough free employees to take all the activities in the project
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

    //Method which delegates the activities from project to employees found in getEmplForProj()
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

    //Method for finding a substitute for an employee who is registering as absent
    public void findSubstitute(Activity act, Employee empl){ // only called from updateAbsence (Employee class)
        Employee newEmpl = project.firm.getFreeEmployees().get(0);
        project.getDelegatedActivities().replace(act, empl, newEmpl);
    }

    //Method for delaying a project with a given number of hours
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

    //Method for creating a project repport
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

    //Method for ending a project, makes it inactive.
    public void endProject(){
        project.active = false;
    }


}
