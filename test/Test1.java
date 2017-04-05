import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Daniel Hildebrand on 27-03-2017.
 */

public class Test1 {
    @Test
    public void TimeManagerTest01(){
        // Test TimeManager class here
        Calendar date =  Calendar.getInstance();
        double remainingTime = 0.0d;
        List<availibleEmployee> availible = new ArrayList<availibleEmployee>(){
            String employee1;
            String employee2;
        };
        List<TimeUsedprActivity> TimeUsedprActivity= new ArrayList<TimeUsedprActivity>(){
            double activity1 = 3.5;
            double activity2 = 4.5;
        }

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

        //Step 3: Test that the end date and estimated time use is correct
        assertEquals(client01.getEndDate, date);

        assertEquals(client01.getEstimatedTimeUse,100);
    }

    @Test
    public void ActivityTest(){
        /* Test Activity class here*/
        String activityName = "name";
        double estimatedTimeUse = 100;
        double timeUsed = 50.5;
        double remainingTime= estimatedTimeUse - timeUsed;

        assertEquals(Activity.getactivityName,"name");
        assertEquals(Activity.getestimatedTimeUse,estimatedTimeUse);
        assertEquals(Activity.getTimeused,timeUsed);
        assertEquals(Activity.getremainingTime,remainingTime);


    }


    @Test
    public void EmployeeTest(){
        /* Test employee class here
            *
            *
            *
        */
    }

    @Test
    public void ProjectManagerTest(){
        /* Test ProjectManager class here
         *
         *
         *
         */
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

        // Test of updateEstimatedTimeUse
        estimatedTimeUse = estimatedTimeUse + 50;
        project01.updateEstimatedTimeUse(estimatedTimeUse);
        assertEquals(project01.getEstimatedTimeUse(),estimatedTimeUse);

        // Test of set/get ProjectManager
        assertEquals(project01.getProjectManager(),null);
        Employee projMan = new Employee("Helga");
        project01.setProjectManager(projMan);
        assertEquals(project01.getProjectManager(),projMan);

        // Test of set/get WorkingEmployees
        assertEquals(project01.getWorkingEmployees, null);
        List<Employee> workingEmployees = new ArrayList<Employee>();
        for (int i = 1; i <= 5; i++){
            workingEmployees.add(new Employee("employee"+i));
        }
        project01.setWorkingEmployees(workingEmployees);
        assertEquals(project01.getWorkingEmployees(),workingEmployees);

        // Test of makeProjectReport
        // Make employees as String
        String employees = "";
        for (Employee e : workingEmployees){
            employees = employees + e.getName();
        }
        // Make activities and acticities as String
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
        assertEquals(project01.makeProjectReport(),projectReport);
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
