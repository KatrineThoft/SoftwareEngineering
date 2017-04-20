import org.junit.jupiter.api.Test;

//import org.junit.assert.*;
import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Test1 {
    @Test
    public void TimeManagerTest01(){
        // Test TimeManager class here
        Calendar date =  Calendar.getInstance();
        double remainingTime = 0.0d;
        ArrayList<availableEmployee> availible = new ArrayList<availableEmployee>();
        availible.add(employee1);
        availible.add(employee2);


        List<TimeManager> TimeUsedprActivity= new ArrayList<TimeManager>();
        double activity1 = 3.5;
        double activity2 = 4.5;
        TimeUsedprActivity.add(activity1);
        TimeUsedprActivity.add(activity2);

        assertEquals(TimeManager.getCalender,date);
        assertEquals(TimeManager.getremainingTime,remainingTime);
        assertEquals(TimeManager.getavailibleEmployee,availible);
        assertEquals(TimeManager.getTimeUsedprActivity,TimeUsedprActivity);
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

        //Step 3: Test that the end date and estimated time use is correc
        assertEquals(client01.getEndDate(), date);

        assertEquals(client01.getEstimatedTimeUse(),100);
    }

   @Test
    public void ActivityTest(){
        // Creating an Activity
        String activityName = "name";
        double estimatedTimeUse = 100;
        Activity activity1 = new Activity(activityName,estimatedTimeUse);

        // Test of constructor
        assertEquals(activity1.getActivityName(),"name");
        assertEquals(activity1.getEstimatedTimeUse(),estimatedTimeUse);

        // Test of set/get timeUsed
        double timeUsed = 50.5;
        activity1.setTimeUsed(timeUsed);
        assertEquals(activity1.getTimeUsed(),timeUsed);

        // Test of getRemainingTime
        double remainingTime = estimatedTimeUse - timeUsed;
        assertEquals(activity1.getRemainingTime(),remainingTime);
    }

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
        assertEquals(project01.getRemainingTime(),remainingTime);


       // updateEstimatedTimeUse is the same function as
        //delayProject in ProjectManager
        // Test of updateEstimatedTimeUse
        estimatedTimeUse = estimatedTimeUse + 50;
        project01.updateEstimatedTimeUse(estimatedTimeUse);
        assertEquals(project01.getEstimatedTimeUse(),estimatedTimeUse);



        //set / get project manager is not necessary because
        //the project is attatched to a project manager from the beginning
        // Test of set/get ProjectManager
        assertEquals(project01.getProjectManager(),null);
        Employee projMan = new Employee("Helga");
        project01.setProjectManager(projMan,project01);
        assertEquals(project01.getProjectManager(),projMan);

        // Test of set/get WorkingEmployees
        assertEquals(project01.getWorkingEmployees(), null);
        List<Employee> workingEmployees = new ArrayList<Employee>();
        for (int i = 1; i <= 5; i++){
            workingEmployees.add(new Employee("employee"+i));
        }
        project01.setWorkingEmployees(workingEmployees);
        assertEquals(project01.getWorkingEmployees(),workingEmployees);

        // Test of set/get Activities
        assertEquals(project01.getActivities(), null);
        List<Activity> activities = new ArrayList<Activity>();
        for (int i = 1; i <= 5; i++){
            activities.add(new Activity("activity"+i, 10));
        }
        project01.setActivities(activities);
        assertEquals(project01.getActivities(),activities);

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
            activities = activities + a.getActivityName() + ", " + a.getRemainingTime() + "; ";
        }
        // The test
        String projectReport = "Name = " + projectName + ", ID = " + projectID + ", Time used = " + timeUsed
                + ", Remaining time = " + remainingTime + ", Employees = " + employees + ", Activities = " + activities;
        assertEquals(project01.makeProjectReport(),projectReport);
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
        assertTrue(manager.employee == employee01);
        assertTrue(manager.project == project01);

        // Test of createActivities
        assertTrue(manager.project.activities == null);
        manager.createActivities();
        assertFalse(manager.project.activities == null);

        // Test of delegateActivities
        assertFalse(manager.project.activities == null);
        assertTrue(manager.project.workingEmployees == null);
        manager.delegateActivities();
        assertTrue(manager.project.workingEmployees.size() == manager.project.activities.size());

        // Test findSubstitute
        assertTrue(*liste med *);
        assertFalse(manager.project.workingEmployees.size() == manager.project.activities.size());


        // Test of delayProject
        assertTrue(manager.project.estimatedTimeUse == 100);
        assertTrue(manager.project.endDate == endDate);
        manager.delayProject(17.5);

        // updates estimated time use with amount of hours and updates end date with
        estimatedTimeUse = estimatedTimeUse + 17.5;

        // amount of hours/8 (8 hrs. on a regular work day)
        endDate.setDate(23 + (int)(17.5/8) + 1,01,2018);
        assertTrue(manager.project.estimatedTimeUse == estimatedTimeUse);
        assertTrue(manager.project.endDate == endDate);

        // Test of endProject
        assertTrue(manager.project.active);
        manager.endProject();
        assertFalse(manager.project.active);

        // Test of project meeting
        assertEquals(project01.getProjectID,projectID);
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
        assertEquals(project01.getProjectManager,"Hanne");

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
