
import ApplicationLayer.*;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.junit.Test;

public class Test1 {

    // Test af ApplicationLayer.Date klassen

    @Test
    public void TimeManagerTest01(){
        // creating a ApplicationLayer.TimeManager
        TimeManager firm01 = new TimeManager();

        // test of constructor and get clients/projects/employees/freeEmployees
        assertTrue(firm01.getClients().isEmpty());
        assertTrue(firm01.getProjects().isEmpty());
        assertTrue(firm01.getEmployees().isEmpty());
        assertTrue(firm01.getFreeEmployees().isEmpty());
        assertTrue(firm01.getProjectManagers().isEmpty());

        // creating clients
        Date endDate = new Date(23,1,2018);
        double estimatedTimeUse = 100;
        List<Client> clients = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            clients.add(new Client("client" + i, endDate, estimatedTimeUse, "project" + i, firm01));
        }
        // test of getClients
        /*for (Client c : clients) {
            firm01.addClient(c);
        }*/
        assertEquals(firm01.getClients(),clients);

        // creating projects
        List<Project> projects = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            projects.add(new Project(clients.get(i), firm01));
        }
        // test of getProjects
        /*for (Project p : projects) {
            firm01.addProject(p);
        }*/
        assertEquals(firm01.getProjects(),projects);

        // creating Employees
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            employees.add(new Employee("employee" + i, firm01));
        }
        // test of getEmployees
        /*for (Employee e : employees) {
            firm01.addEmployee(e);
        }*/
        // Test of getEmployees
        assertEquals(firm01.getEmployees(),employees);

        // Test of getFreeEmployees
        assertTrue(firm01.getFreeEmployees().size() == 10);

        /*// setting some of the Employees unavailable
        for (int i = 0; i < 5; i++) {
            employees.get(i).absence = true;
        }
        // test of add / get FreeEmployees
        //for (Employee e : employees) {
          //  firm01.addFreeEmployee(e);
        //}
        // Test of getFreeEmployees
        assertTrue(firm01.getFreeEmployees().size() == 5);*/

        // creating ProjectManagers
        List<ProjectManager> projectMans = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            projectMans.add(new ProjectManager(employees.get(i),projects.get(i),firm01));
        }

        // Test of getProjectManagers
        assertEquals(firm01.getProjectManagers(),projectMans);

        // Test of getEmployeeNames
        for (int i = 0; i < 10; i++) {
            assertEquals(firm01.getEmployeeNames().get(i), firm01.getEmployees().get(i).getName());
        }

        // Test of getEmployee
        assertEquals(firm01.getEmployee("employee0"), firm01.getEmployees().get(0));

        // Test of getProjectManagerAsEmployee
        assertEquals(firm01.getProjectManagerAsEmployee(firm01.getEmployees().get(0)),firm01.getEmployees().get(0));

        // Test of getEmployeeAsProjectManager
        assertEquals(firm01.getEmployeeAsProjectManager(firm01.getEmployees().get(0)),firm01.getProjectManagers().get(0));
    }

    @Test
    public void ClientTest(){
        //Data used to test the client class
        TimeManager firm01 = new TimeManager();
        Date endDate = new Date(23,1,2018);
        double estimatedTimeUse = 100;
        String projectName = "novoProject";
        String clientName = "NovoNordisk";

        //Create a new client
        Client client01 = new Client(clientName, endDate, estimatedTimeUse, projectName, firm01);

        // Test of first constructor
        assertFalse(client01 == null);
        assertEquals(client01.clientName,clientName);
        assertEquals(client01.endDate, endDate);
        assertEquals(client01.estimatedTimeUse,estimatedTimeUse);
        assertEquals(client01.projectName, projectName);
        assertEquals(client01.firm, firm01);
        assertTrue(client01.wantedPM == null);
        assertTrue(client01.projectManager == null);

        // creating an employee
        String eName01 = "Hanne";
        Employee employee01 = new Employee(eName01, firm01);

        //Create new client with a chosen project manager
        Client client02 = new Client(clientName, endDate, estimatedTimeUse, projectName, employee01, firm01);

        // Test of second constructor
        assertFalse(client02 == null);
        assertEquals(client02.clientName,clientName);
        assertEquals(client02.endDate, endDate);
        assertEquals(client02.estimatedTimeUse,estimatedTimeUse);
        assertEquals(client02.projectName, projectName);
        assertEquals(client02.firm, firm01);
        assertEquals(client02.wantedPM, employee01);
        assertTrue(client02.projectManager == null);

        // Test of addToFirm (method is being called in constructor: client01 and 02 are added)
        assertFalse(firm01.getClients().isEmpty());
    }

   /* @Test
    public void ClientTest02(){
        //Check that client can designate a project manager

        //Data used to test the client class
        TimeManager firm01 = new TimeManager();
        Date endDate = new Date(23,1,2018);
        double estimatedTimeUse = 100;
        String projectName = "novoProject";
        String clientName = "NovoNordisk";
        String eName01 = "Hanne";
        Employee employee01 = new Employee(eName01, firm01);

        //Create new client with a chosen project manager and a new project
        Client client01 = new Client(clientName, endDate, estimatedTimeUse, projectName, employee01, firm01);

//        assertFalse(client01.getTempProject() == null);
        Project project01 = new Project(client01, firm01);

        //Test that it is the correct project manager
        assertEquals(project01.projectManager.employee.getName(),"Hanne");
    }*/

   @Test
    public void ActivityTest(){
       // Creating a client (no testing)
       TimeManager firm01 = new TimeManager();
       Date endDate = new Date(23,1,2018);
       double estimatedTimeUse = 100;
       String projectName = "novoProject";
       String clientName = "NovoNordisk";
       Client client01 = new Client(clientName, endDate, estimatedTimeUse, projectName, firm01);
       // Creating a project (no testing)
       Project project01 = new Project(client01, firm01);

        // Creating an Activity
        String activityName = "name";
        double estimatedTimeUseAct = 10;
        Activity activity1 = new Activity(activityName, project01);

        // Test of constructor, getActivityName, getTimeUsed, getProject and getEstimatedTimeUse
        assertEquals(activity1.getActivityName(),"name");
        assertEquals(activity1.getTimeUsed(), 0);
        assertEquals(activity1.getProject(), project01);
        assertEquals(activity1.getEstimatedTimeUse(), 0.0);

        // Test of set/get estimatedTimeUse
        activity1.setEstimatedTimeUse(estimatedTimeUseAct);
        assertEquals(activity1.getEstimatedTimeUse(),estimatedTimeUseAct);

        // Test of update/get timeUsed
        double timeUsed = 50.5;
        activity1.updateTimeUsed(timeUsed);
        assertEquals(activity1.getTimeUsed(),timeUsed);

        // Test of getRemainingTime
        double remainingTime = estimatedTimeUseAct - timeUsed;
        assertEquals(activity1.getRemainingTime(),remainingTime);
    }

    @Test
    public void EmployeeTest(){
        // Data for creating a client (no testing)
        TimeManager firm01 = new TimeManager();
        Date endDate = new Date(23,1,2018);
        double estimatedTimeUse = 100;
        String projectName = "novoProject";
        String clientName = "NovoNordisk";

        // Creating an employee
        String employeename = "Helga";
        Employee employee01 = new Employee(employeename, firm01);

        // Test of constructor, getName and getActivities
        assertEquals(employee01.getName(),"Helga");
        assertFalse(employee01.absence);
        assertTrue(employee01.getActivities().isEmpty());
        assertTrue(employee01.registeredHours.isEmpty());
        assertEquals(employee01.firm, firm01);

        // Creating a client with wanted PM: Helga
        Client client01 = new Client(clientName, endDate, estimatedTimeUse, projectName, employee01, firm01);
        // Creating a project (no testing)
        Project project01 = new Project(client01, firm01);

/*        // Test of set/ get Activities
        assertEquals(employee01.getActivities(),null);
        List<Activity> ongoingactivities = new ArrayList<Activity>();
        for (int i = 1; i <= 5; i++){
            ongoingactivities.add(new Activity("activity"+i, project01));
        }
        //employee01.setActivities(ongoingactivities);
        assertEquals(employee01.getActivities(), ongoingactivities);
*/
        // creating activities for Helga
        String activityName = "name";
        Activity activity01 = new Activity(activityName, project01);
        activity01.setEstimatedTimeUse(10);

        // Test of addActivities
        employee01.addActivities(activity01);

        // creating dates
        Date date01 = new Date(1,5,2017); // in the past
        Calendar date02H = Calendar.getInstance();
        int day = date02H.get(Calendar.DATE);
        int month = date02H.get(Calendar.MONTH)+1;
        int year = date02H.get(Calendar.YEAR);
        Date date02 = new Date(day, month, year); // current
        Date date03 = new Date(1,5,2020); // in the future

        // Test of updateRegisteredHours
        assertTrue(employee01.updateRegisteredHours(date01, 7.5));
        assertTrue(employee01.updateRegisteredHours(date02, 7.5));
        assertFalse(employee01.updateRegisteredHours(date03, 7.5));
        
        // Test of regHoursOnAct
        employee01.regHoursOnAct(2.0, activity01);
        assertTrue(activity01.getTimeUsed() == 2.0);

        // Testing update absence
        // Making sure there are no freeEmployees
        firm01.getFreeEmployees().removeAll(firm01.getFreeEmployees());

        // Test01 of updateAbsence
        employee01.updateAbsence();
        assertFalse(employee01.absence);

        // creating an extra employee (who is automatically added to freeEmployees
        Employee employee02 = new Employee("Arne", firm01);

        // Test02 of updateAbsence
        employee01.updateAbsence();
        assertTrue(employee01.absence);

        // Test of addToFirm (method is being called in constructor: employee01 and 02 are added
        assertFalse(firm01.getEmployees().isEmpty());
        assertFalse(firm01.getFreeEmployees().isEmpty());
    }

    @Test
    public void ProjectTest(){
        // Creating a client (no testing)
        TimeManager firm01 = new TimeManager();
        Employee employee01 = new Employee("Hanne", firm01); // is automatically added to freeEmployees
        Employee employee02 = new Employee("Helga", firm01); // is automatically added to freeEmployees
        Date endDate = new Date(23,1,2018);
        double estimatedTimeUse = 100;
        String projectName = "novoProject";
        String clientName = "NovoNordisk";
        // client without wanted PM
        Client client01 = new Client(clientName, endDate, estimatedTimeUse, projectName, firm01);

        // Creating a project
        Project project01 = new Project(client01, firm01);

        //Test of constructor without wanted PM (also test of setProjectManager,
        // getEstimatedTimeUse, getTimeUsed, getWorkingEmployees, getActivities
        // and getDelegatedActivities)
        assertTrue(project01.active);
        assertEquals(project01.client,client01);
        assertEquals(project01.projectName,projectName);
        assertEquals(project01.endDate,endDate);
        assertEquals(project01.getEstimatedTimeUse(),estimatedTimeUse);
        assertEquals(project01.getTimeUsed(),0);
        assertEquals(project01.firm, firm01);
        assertTrue(project01.getWorkingEmployees().isEmpty());
        assertTrue(project01.getActivities().isEmpty());
        assertTrue(project01.getDelegatedActivities().isEmpty());
        assertEquals(project01.projectManager.employee, employee01); // chooses first freeEmployee
                                                                          // bcs. no PM was set by client
        // Creating a client with a wanted PM: Helga
        Client client02 = new Client(clientName, endDate, estimatedTimeUse, projectName, employee02, firm01);

        // Creating a project
        Project project02 = new Project(client02, firm01);

        // Test of constructor with a wanted PM: Helga
        assertEquals(project02.projectManager.employee, employee02); //employee02 was wanted PM

        // Test of set/get ProjectID (method is called in constructor so projectID is set)
        assertFalse(project01.getProjectID() == null);

        // Test of set/get DelegatedActivities
        Activity activity01 = new Activity("activity02", project01);
        Map<Activity,Employee> delegated = new HashMap<>();
        delegated.put(activity01,employee01);
        project01.setDelegatedActivities(delegated);
        assertEquals(project01.getDelegatedActivities().get(activity01), employee01);

        // Test of update TimeUsed
        double timeUsed = 17.5;
        project01.updateTimeUsed(timeUsed);
        assertEquals(project01.getTimeUsed(), timeUsed);

        // Test of updateEstimatedTimeUse
        double newEstimatedTimeUse = estimatedTimeUse + 50;
        project01.updateEstimatedTimeUse(50);
        assertEquals(project01.getEstimatedTimeUse(),newEstimatedTimeUse);

        // Test of getRemainingTime
        double remainingTime = newEstimatedTimeUse - timeUsed;
        assertEquals(project01.getRemainingTime(),remainingTime);

        // Test of addToFirm (method is being called in constructor: project01 and 02 are added
        assertFalse(firm01.getProjects().isEmpty());
    }

    @Test
    public void ProjectManagerTest(){
        // Creating an employee to be project manager
        TimeManager firm01 = new TimeManager();
        String employeename = "Helga";
        Employee employee01 = new Employee(employeename, firm01);

        // Creating a client (to create a project)
        Date endDate = new Date(23,1,2018);
        double estimatedTimeUse = 10;
        String projectName = "novoProject";
        String clientName = "NovoNordisk";

        Client client01 = new Client(clientName, endDate, estimatedTimeUse, projectName, firm01);

        // Creating a project
        Project project01 = new Project(client01, firm01);

       /* // setting ongoing activities
        List<Activity> ongoingactivities = new ArrayList<Activity>();
        for (int i = 1; i <= 5; i++){
            ongoingactivities.add(new Activity("activity"+i, project01));
        }
        //employee01.setActivities(ongoingactivities);
*/
        // Creating a projectManager
        ProjectManager manager = new ProjectManager(employee01, project01, firm01);

        // Test of constructor
        assertEquals(manager.employee, employee01);
        assertEquals(manager.project, project01);
        assertEquals(manager.firm, firm01);

        // Test of addToFirm (method is being called in constructor: manager are added
        assertFalse(firm01.getProjectManagers().isEmpty());

        // Test of createActivities
        assertTrue(manager.project.getActivities().isEmpty());
        manager.createActivities();
        assertTrue(manager.project.getActivities().size() == 1); // 1 activity created bcs. estimatedTimeUse = 10

        /*// Test of setEstTimeUse
        for (Activity a : manager.project.getActivities()) {
            manager.setEstTimeUse(a, 10);
        }
        assertTrue(manager.project.getActivities().get(0).getEstimatedTimeUse() == 10);
*/
        // Test of getEmplForProj
        assertTrue(manager.project.getWorkingEmployees().isEmpty());
        assertFalse(manager.project.firm.getFreeEmployees().isEmpty());
        manager.getEmplForProj();
        assertTrue(manager.project.getWorkingEmployees().size() == 1); // 1 working employee created: Helga

        // Resetting workingEmployees and activities (methods being recalled in delegateActivities)
        manager.project.getActivities().removeAll(manager.project.getActivities());
        manager.project.getWorkingEmployees().removeAll(manager.project.getWorkingEmployees());

        // Test of delegateActivities and getDelegatedActivities
        assertTrue(manager.project.getActivities().isEmpty());
        assertTrue(manager.project.getWorkingEmployees().isEmpty());
        assertTrue(manager.project.getDelegatedActivities().isEmpty());
        assertFalse(manager.project.firm.getFreeEmployees().isEmpty());
        manager.delegateActivities();
        assertFalse(manager.project.getDelegatedActivities().isEmpty());

        // Test findSubstitute
        assertTrue(employee01.getActivities().size() == 1); // employee01 has one activity
        manager.firm.getFreeEmployees().remove(employee01); // employee01 is no longer a freeEmployee (absent)

        Employee employee02 = new Employee("Margot", firm01); //employee02 is now a freeEmpl
        assertFalse(manager.project.firm.getFreeEmployees().isEmpty());

        Activity activity01 = manager.project.getActivities().get(0);

        manager.findSubstitute(activity01, employee01);

        assertEquals(manager.project.getDelegatedActivities().get(activity01), employee02);
        assertTrue(manager.project.getWorkingEmployees().size() == manager.project.getActivities().size());

        // Test of delayProject
        assertTrue(manager.project.getEstimatedTimeUse() == 10);
        assertTrue(manager.project.endDate == endDate);
        manager.delayProject(17.5);
        estimatedTimeUse = estimatedTimeUse + 17.5;
        endDate.alterDate(23 + (int)(17.5/8) + 1,01,2018);    // amount of hours/8 (8 hrs. on a regular work day)
        assertTrue(manager.project.getEstimatedTimeUse() == estimatedTimeUse);
        assertTrue(manager.project.endDate == endDate);

        // Test of makeProjectReport
        // Make employees as String
        String emplAsStr = "";
        for (Employee e : manager.project.getWorkingEmployees()) {
            emplAsStr += e.getName() + "\n";
        }
        // Make activities as String
        String actsAsStr = "";
        for (Activity a : manager.project.getActivities()) {
            actsAsStr += a.getActivityName() + "\n";
        }
        // The test
        String projectReport = "Name = " + manager.project.projectName + "\nID = " + manager.project.getProjectID() + "\nTime used = " + manager.project.getTimeUsed()
                + "\nRemaining time = " + manager.project.getRemainingTime() + "\nEmployees = " + emplAsStr + "\nActivities = " + actsAsStr;
        assertEquals(manager.makeProjectReport(),projectReport);

        // Test of endProject
        assertTrue(manager.project.active);
        manager.endProject();
        assertFalse(manager.project.active);
    }

}
