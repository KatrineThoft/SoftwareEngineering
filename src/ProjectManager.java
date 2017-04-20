import java.util.ArrayList;
import java.util.List;

/**
 * Created by katrinethoft on 27/03/17.
 */
public class ProjectManager{// extends Employee  {
    public Employee employee;
    public Project project;

    public ProjectManager(Employee employee01, Project project){//, String employeeName, List<Activity> ongoingActivities){
        //super(employeeName, ongoingActivities);
        this.employee = employee01;
        this.project = project;
    }

    public List<Activity> createActivities(List<Activity>){
        project.setActivities();
        return act;
    }

   /* public List<Activity, Employee> delegateActivities(List<Employee> employees, List<Activity> activities){
        List<Activity, Employee> list = new List<Activity, Employee>;
        //Do stuff
        return list;
    }
    */

    public void projectMeeting(String projectID){
        //Do stuff
    }

    public Employee findSubstitute(Activity act){
        //Do stuff
        return null;
    }

    public void informClient(String projectID, String message){
        //Do stuff
    }

    public void delayProject(String projectID){
        //Do stuff
    }

    public void endProject(String projectID){
        //Do stuff
    }

}
