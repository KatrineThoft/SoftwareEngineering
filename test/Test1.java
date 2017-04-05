import org.junit.jupiter.api.Test;

//import org.junit.assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel Hildebrand on 27-03-2017.
 */

public class Test1 {
    @Test
    public void TimeManagerTest01(){
        /* Test TimeManager class here
         *
         *
         *
         */
    }
    @Test
    public void ClientTest01(){
        //Test that the client is correctly constructed
        //Data used to test the client class
        TimeManager endDate = TimeManager.setDate(23,1,2018);
        double estimatedTimeUse = 100;
        String projectName = "novoProject";
        String clientName = "NovoNordisk";


        //Create a new client and a new project
        Client client01 = new Client(clientName, endDate, estimatedTimeUse, projectName);

        Project project01 = new Project(client01);

        //Step 1: Test that the client is non-empty
        assertFalse(client01,null);

        //Step 2: Test that the client name is correct
        assertEquals(client01.getName(),"NovoNordisk" );

        Calendar date = new Calendar(23,1,2018);

        //Step 3: Test that the end date and estimated time use is correct
        assertEquals(client01t.getEndDate(), date);

        assertEquals(client01.getEstimatedTimeUse(),100);
    }

    @Test
    public void ActivityTest(){
        /* Test Activity class here
            *
            *
            *
        */
    }


    @Test
    public void EmployeeTest(){
        // Creating an employee
        String employeename = "Helga";
        Employee employee01 = new Employee(employeename);

        // Test of constructor
        assertEquals(employee01.getName(),"Helga");

        // Test of set/ get Activities
        assertEquals(employee01.getActivities(),null);
        List<Activity> ongoingactivities = new ArrayList<Activity>();
        for (int i = 1; i <= 5; i++){
            ongoingactivities.add(new Activity("activity"+i, 10));
        }
        employee01.setActivities(ongoingactivities);
        assertEquals(employee01.getActivities(), ongoingactivities);

        // Test of absence / updateAbsence
        assertTrue(employee01.absence == false);
        employee01.updateAbsence(true);
        assertTrue(employee01.absence == true);

        // Test of registeredHours / updateRegisteredHours
        assertTrue(employee01.registeredHours == 0.0);
        employee01.updateRegisteredHours(17.5);
        assertTrue(employee01.registeredHours == 17.5);
    }


    @Test
    public void ProjectTest01(){
        // Creating a client (no testing)
        TimeManager endDate = TimeManager.setDate(23,1,2018);
        double estimatedTimeUse = 100;
        String projectName = "novoProject";
        String clientName = "NovoNordisk";

        Client client01 = new Client(clientName, endDate, estimatedTimeUse, projectName);

        // Creating a project
        Project project01 = new Project(client01);

        //Test of constructor
        int projectID = 23011801;
        project01.setProjectID(projectID);
        assertEquals(project01.getProjectID(), projectID);
        assertEquals(project01.getClient(),client01);
        assertEquals(project01.getProjectName(),projectName);
        assertEquals(project01.getEndDate(),endDate);
        assertEquals(project01.getEstimatedTimeUse(),estimatedTimeUse);

        // Test of set/get TimeUsed
        assertEquals(project01.getTimeUsed(),null);
        double timeUsed = 17.5;
        project01.setTimeUsed(timeUsed);
        assertEquals(project01.getTimeUsed(), timeUsed);

        // Test of getRemainingTime
        double remainingTime = estimatedTimeUse - timeUsed;
        assertEqual(project01.getRemainingTime(),remainingTime);

        /*
        updateEstimatedTimeUse is the same function as
        delayProject in ProjectManager
        // Test of updateEstimatedTimeUse
        estimatedTimeUse = estimatedTimeUse + 50;
        project01.updateEstimatedTimeUse(estimatedTimeUse);
        assertEquals(project01.getEstimatedTimeUse(),estimatedTimeUse);
        */

        /* // Test of set/get ProjectManager
        assertEqual(project01.getProjectManager(),null);
        Employee projMan = new Employee("Helga");
        project01.setProjectManager(projMan);
        assertEqual(project01.getProjectManager(),projMan);
        */

        // Test of set/get WorkingEmployees
        assertEqual(project01.getWorkingEmployees(), null);
        List<Employee> workingEmployees = new ArrayList<Employee>();
        for (int i = 1; i <= 5; i++){
            workingEmployees.add(new Employee("employee"+i));
        }
        project01.setWorkingEmployees(workingEmployees);
        assertEqual(project01.getWorkingEmployees(),workingEmployees);

        // Test of makeProjectReport
        // Make employees as String
        String employees = "";
        for (Employee e : workingEmployees){
            employees = employees + e.getName();
        }
        // Make activities and activities as String
        List<Activity> activityList = new ArrayList<Activity>();
        for (int i = 1; i <= 5; i++){
            activityList.add(new Activity("activity"+i, 10));
        }
        String activities = "";
        for (Activity a : activityList){
            activities = activities + a.getName() + ", " + a.getRemainingTime() + "; ";
        }
        // The test
        String projectReport = "Name = " + projectName + ", ID = " + projectID + ", Time used = " + timeUsed
                + ", Remaining time = " + remainingTime + ", Employees = " + employees + ", Activities = " + activities;
        assertEqual(project01.makeProjectReport(),projectReport);
    }

    @Test
    public void ProjectManagerTest(){
        // Creating an employee
        String employeename = "Helga";
        Employee employee01 = new Employee(employeename);
        List<Activity> ongoingactivities = new ArrayList<Activity>();
        for (int i = 1; i <= 5; i++){
            ongoingactivities.add(new Activity("activity"+i, 10));
        }
        employee01.setActivities(ongoingactivities);

        // Creating a client (to create a project)
        TimeManager endDate = TimeManager.setDate(23,1,2018);
        double estimatedTimeUse = 100;
        String projectName = "novoProject";
        String clientName = "NovoNordisk";

        Client client01 = new Client(clientName, endDate, estimatedTimeUse, projectName);

        // Creating a project
        Project project01 = new Project(client01);
        int projectID = 23011801;
        project01.setProjectID(projectID);

        // Creating a projectManager
        ProjectManager manager = new ProjectManager(employee01, project01);

        // Test of constructor
        Assertions.assertTrue(manager.employee == employee01);
        assertTrue(manager.project == project01);

        // Test of delegateActivities

        assert
        // Test of delayProject
        assertTrue(manager.project.estimatedTimeUse == 100);
        assertTrue(manager.project.endDate == endDate);
        manager.delayProject(17.5);                 // updates estimated time use with amount of hours and updates end date with
        estimatedTimeUse = estimatedTimeUse + 17.5; // amount of hours/8 (8 hrs. on a regular work day)
        endDate.setDate(23 + (int)(17.5/8) + 1,01,2018);
        assertTrue(manager.project.estimatedTimeUse == estimatedTimeUse);
        assertTrue(manager.project.endDate == endDate);

        // Test of endProject
        assertTrue(manager.project.active);
        manager.endProject();
        assertFalse(manager.project.active);
    }

    @Test
    public void ClientTest02(){
        //Check that client can designate a project manager

        //Data used to test the client class
        TimeManager endDate = TimeManager.setDate(23,1,2018);
        double estimatedTimeUse = 100;
        String projectName = "novoProject";
        String clientName = "NovoNordisk";
        String eName01 = "Hanne";
        Employee employee01 = new Employee(eName01);

        //Create new client with a chosen project manager and a new project
        Client client01 = new Client(clientName, endDate, estimatedTimeUse, projectName, employee01);

        Project project01 = new Project(client01);

        //Step 1: Test that it is the correct project manager
        assertEqual(project01.getProjectManager,"Hanne");

        //Step 2:  Test that when the wished project manager is unavailiable another employee is chosen
        String eName02 = "Niels";
        Employee employee02 = new Employee(eName02);

        for(int i = 0; i < 20; i++){
            employee02.ongoingActivities.add(new Activity("act" + i, 10));
        }

        Client client02 = new Client(clientName, endDate, estimatedTimeUse, projectName, employee02);

        assertFalse()

    }
}
