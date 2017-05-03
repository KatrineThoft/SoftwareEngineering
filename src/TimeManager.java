import javax.management.timer.TimerMBean;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


/**
 * Created by katrinethoft on 03/04/17.
 */
public class TimeManager {
    private List<Client> allClients;
    private List<Project> allProjects;
    private List<Employee> allEmployees;
    private List<Employee> freeEmployees;

    public TimeManager() {
        this.allClients = new ArrayList<>();
        this.allProjects = new ArrayList<>();
        this.allEmployees = new ArrayList<>();
        this.freeEmployees = new ArrayList<>();

    }

    public List<Client> getClients() {
        return allClients;
    }

    public List<Project> getProjects() {
        return allProjects;
    }

    public List<Employee> getEmployees() {
        return allEmployees;
    }

    public List<String> getEmployeeNames() {
        List<String> emplNames = new ArrayList<String>();
        for (Employee e : allEmployees) {
            emplNames.add(e.getName());
        }
        return emplNames;
    }

    public Employee getEmployee(String name) {
        for (Employee e : allEmployees) {
            if (e.getName() == name) {
                return e;
            }
        }
        return null;
    }

    public List<Employee> getFreeEmployees() {
        return freeEmployees;
    }

    public void addClient(Client client) {
        this.allClients.add(client);
    }

    public void addProject(Project project) {
        this.allProjects.add(project);
    }

    public void addEmployee(Employee employee) {
        this.allEmployees.add(employee);
    }

    public void addFreeEmployee(Employee employee) {
        if (employee.absence == false && employee.getActivities().size() < 10) {
            this.freeEmployees.add(employee);
        }
    }

}


