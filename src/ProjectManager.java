import java.sql.Time;
import java.util.*;

/**
 * Created by katrinethoft on 27/03/17.
 */
public class ProjectManager{
    public Employee employee;
    public Project project;
    private Map<Activity, Employee> delegatedActivities;

    public ProjectManager(Employee employee01, Project project){
        this.employee = employee01;
        this.project = project;
    }

    public void createActivities(List<Activity> actList){
        project.setActivities(actList);
    }

    public void createEmployees() {
        for (int i = 0; i < project.getActivities().size(); i++){
            if (project.firm.getFreeEmployees().get(i) != null) {
                project.getWorkingEmployees().add(project.firm.getFreeEmployees().get(i));
            } else {
                System.out.println("not enough available employees");
                break;
            }
        }
    }

    public void delegateActivities(List<Activity> activities, List<Employee> employees){
        Map<Activity, Employee> delegatedActivities = new HashMap<Activity, Employee>();
        for (int i = 0; i < employees.size(); i++) {
            delegatedActivities.put(activities.get(i), employees.get(i));
            employees.get(i).getActivities().add(activities.get(i));
            if (employees.get(i).getActivities().size() >= 10) {
                project.firm.getFreeEmployees().remove(employees.get(i));
            }
        }
        this.delegatedActivities = delegatedActivities;
    }

    public Map<Activity, Employee> getDelegatedActivities() {
        return delegatedActivities;
    }

    public Employee findSubstitute(Activity act, Employee empl){
        if (project.firm.getFreeEmployees() != null) {
            Employee newEmpl = project.firm.getFreeEmployees().get(0);
            delegatedActivities.replace(act, empl, newEmpl);
            return newEmpl;
        } else {
            System.out.println("not enough available employees");
            return null;
        }
    }

    public void delayProject(double hours){
        project.updateEstimatedTimeUse(hours);
        project.endDate.date = 23 + (int)(hours/8) + 1;    // amount of hours/8 (8 hrs. on a regular work day)
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
