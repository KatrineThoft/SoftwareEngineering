package ApplicationLayer;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by katrinethoft on 03/04/17.
 */
//Class representing the company or firm
public class TimeManager {
	//Creating the fields
    private List<Client> allClients;
    private List<Project> allProjects;
    private List<Employee> allEmployees;
    private List<Employee> freeEmployees;
    private List<ProjectManager> allProjectManagers;

    //Constructor
    public TimeManager() {
        this.allClients = new ArrayList<Client>();
        this.allProjects = new ArrayList<Project>();
        this.allEmployees = new ArrayList<Employee>();
        this.freeEmployees = new ArrayList<Employee>();
        this.allProjectManagers = new ArrayList<ProjectManager>();
    }

    //Getter and setter methods for the fields
    public List<Client> getClients() {
        return allClients;
    }

    public List<Project> getProjects() {
        return allProjects;
    }

    public List<Employee> getEmployees() {
        return allEmployees;
    }

    public List<Employee> getFreeEmployees() {
        return freeEmployees;
    }

    public List<ProjectManager> getProjectManagers(){ return allProjectManagers; }

    //Method to get all employee names 
    public List<String> getEmployeeNames() {
        List<String> emplNames = new ArrayList<String>();
        for (Employee e : allEmployees) {
            emplNames.add(e.getName());
        }
        return emplNames;
    }

    //Method to get an employee using their name
    public Employee getEmployee(String name) {
        for (Employee e : allEmployees) {
            if (e.getName().equals(name)) {
                return e;
            }
        }
        return null;
    }

    //Method return the project manager as an employee object
    public Employee getProjectManagerAsEmployee(Employee emp){
        for (ProjectManager p : allProjectManagers){
            if(p.employee.equals(emp)){
                return p.employee;
            }
        }
        return null;
    }

    //Method return the employee as a project manager object
    public ProjectManager getEmployeeAsProjectManager(Employee emp){
        for(ProjectManager p: allProjectManagers){
            if(p.employee.equals(emp)){
                return p;
            }
        }
        return null;
    }

}


