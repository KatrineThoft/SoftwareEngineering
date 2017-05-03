/**
 * Created by Daniel Hildebrand on 03-05-2017.
 */
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class BlackBoxTest {
    @Test
    public void NewProjectTest(){
        TimeManager firm01 = new TimeManager();
        Date endDate = new Date(23,1,2018);
        double estimatedTimeUse = 100;
        String projectName = "novoProject";
        String clientName = "NovoZyme";

        Client client01 = new Client(clientName, endDate, estimatedTimeUse, projectName, firm01);
        Project project01 = new Project(client01, firm01);

        //Test of Project is made
        assertTrue(project01.active);
        assertEquals(project01.projectName,projectName);
        String projectID = "23011801";
        project01.setProjectID(projectID);
        assertEquals(project01.getProjectID(), projectID);

        assertEquals(project01.endDate,endDate);
        //a wish employee from the client
        Employee man = new Employee("Helga", firm01);
        project01.setProjectManager(man);
        ProjectManager projMan = new ProjectManager(man, project01);
        assertEquals(project01.projectManager,projMan);



        //estimated time on project
        assertEquals(project01.getEstimatedTimeUse(),estimatedTimeUse);

        //test work employee
        List<Employee> workingEmployees = new ArrayList<Employee>();
        for (int i = 1; i <= 5; i++){
            workingEmployees.add(new Employee("employee"+i, firm01));
        }
        project01.setWorkingEmployees(workingEmployees);
        assertEquals(project01.getWorkingEmployees(),workingEmployees);

        //make a project repport
        List<Activity> activities = new ArrayList<Activity>();
        for (int i = 1; i <= 5; i++){
            activities.add(new Activity("activity"+i, 10));
        }
        project01.setActivities(activities);

        String employees = "";
        for (Employee e : workingEmployees){
            employees = employees + e.getName();
        }
        // Make activities as String
        String activitiesStr = "";
        for (Activity a : activities){
            activitiesStr = activitiesStr + a.getActivityName() + ", " + a.getRemainingTime() + "; ";
        }

        double timeUsed = 0.0;
        project01.updateTimeUsed(timeUsed);

        double remainingTime = estimatedTimeUse - timeUsed;

        // The test
        String projectReport = "Name = " + projectName + ", ID = " + projectID + ", Time used = " + timeUsed
                + ", Remaining time = " + remainingTime + ", Employees = " + employees + ", Activities = " + activities;
        assertEquals(project01.makeProjectReport(),projectReport);

    }

    @Test
    public void Timerestering(){
        TimeManager firm01 = new TimeManager();
        String employeename = "Helga";
        Employee employee01 = new Employee(employeename, firm01);
        Date endDate = new Date(23,1,2018);
        double estimatedTimeUse = 100;
        String projectName = "novoProject";
        String clientName = "NovoZyme";

        Client client01 = new Client(clientName, endDate, estimatedTimeUse, projectName, firm01);
        Project project01 = new Project(client01, firm01);



        //chech the hours is registertet.
        double timeUsed = 17.5;
        employee01.updateRegisteredHours(timeUsed);
        assertTrue(employee01.registeredHours == 17.5);

        project01.updateTimeUsed(timeUsed);

    }

    @Test
    public void RegisteringAbsentTest(){
        TimeManager firm01 = new TimeManager();
        String employeename = "Helga";
        Employee employee01 = new Employee(employeename, firm01);
        Date endDate = new Date(23,1,2018);
        double estimatedTimeUse = 100;
        String projectName = "novoProject";
        String clientName = "NovoZyme";

        Client client01 = new Client(clientName, endDate, estimatedTimeUse, projectName, firm01);
        Project project01 = new Project(client01, firm01);
        // Creating a projectManager
        ProjectManager manager = new ProjectManager(employee01, project01);
        //employee is absent
        Employee employee02 = manager.project.getWorkingEmployees().get(0);
        Activity activity02 = manager.project.getActivities().get(0);
        employee02.updateAbsence(true);
        assertTrue(employee02.absence == true);

        //find subitut
        manager.findSubstitute(activity02,employee02);
        assertTrue(manager.project.getWorkingEmployees().size() == manager.project.getActivities().size());


    }



}
