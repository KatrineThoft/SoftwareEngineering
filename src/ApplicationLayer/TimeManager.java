package ApplicationLayer;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by katrinethoft on 03/04/17.
 */
public class TimeManager {
    private List<Client> allClients;
    private List<Project> allProjects;
    private List<Employee> allEmployees;
    private List<Employee> freeEmployees;
    private List<ProjectManager> allProjectManagers;

    public TimeManager() {
        this.allClients = new ArrayList<Client>();
        this.allProjects = new ArrayList<Project>();
        this.allEmployees = new ArrayList<Employee>();
        this.freeEmployees = new ArrayList<Employee>();
        this.allProjectManagers = new ArrayList<ProjectManager>();
    }

    // adders are only used when creating new clients, projects and employees
    public void addClient(Client client) {
        this.allClients.add(client);
    }

    public void addProject(Project project) {
        this.allProjects.add(project);
    }

    public void addEmployee(Employee employee) {
        this.allEmployees.add(employee);
        this.freeEmployees.add(employee);
    }

    public void addProjectManager(ProjectManager projectManager){ this.allProjectManagers.add(projectManager); }

    public void addFreeEmployee(Employee employee) {
        if (employee.absence == false && employee.getActivities().size() < 10) {
            this.freeEmployees.add(employee);
        }
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

    public List<ProjectManager> getProjectManagers(){ return allProjectManagers; }

    public List<String> getEmployeeNames() {
        List<String> emplNames = new ArrayList<String>();
        for (Employee e : allEmployees) {
            emplNames.add(e.getName());
        }
        return emplNames;
    }

    public Employee getEmployee(String name) {
        for (Employee e : allEmployees) {
            if (e.getName().equals(name)) {
                return e;
            }
        }
        return null;
    }

    public Employee getProjectManagerAsEmployee(Employee emp){
        for (ProjectManager p : allProjectManagers){
            if(p.getEmployee().equals(emp)){
                return p.getEmployee();
            }
        }

        return null;
    }

    public ProjectManager getEmployeeAsProjectManager(Employee emp){
        for(ProjectManager p: allProjectManagers){
            if(p.getEmployee().equals(emp)){
                return p;
            }
        }

        return null;
    }

    public List<Employee> getFreeEmployees() {
        return freeEmployees;
    }

}


