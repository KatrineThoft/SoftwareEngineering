
import ApplicationLayer.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
    public void ClientTest01(){
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
    }

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
        // Creating a client (no testing)
        TimeManager firm01 = new TimeManager();
        Date endDate = new Date(23,1,2018);
        double estimatedTimeUse = 100;
        String projectName = "novoProject";
        String clientName = "NovoNordisk";
        Client client01 = new Client(clientName, endDate, estimatedTimeUse, projectName, firm01);
        // Creating a project (no testing)
        Project project01 = new Project(client01, firm01);

        // Creating an employee
        String employeename = "Helga";
        Employee employee01 = new Employee(employeename, firm01);

        // Test of constructor, getName and getActivities
        assertEquals(employee01.getName(),"Helga");
        assertFalse(employee01.absence);
        assertTrue(employee01.getActivities().isEmpty());
        assertTrue(employee01.registeredHours.isEmpty());
        assertEquals(employee01.firm, firm01);

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
        employee01.getActivities().add(activity01);

        // Test01 of updateAbsence
        employee01.updateAbsence();
        assertFalse(employee01.absence);

        // creating an extra employee
        Employee employee02 = new Employee("Arne", firm01);

        // Test02 of updateAbsence
        employee01.updateAbsence();
        assertTrue(employee01.absence);

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
        //employee01.regHoursOnAct();
    }

    @Test
    public void ProjectTest(){
        // Creating a client (no testing)
        TimeManager firm01 = new TimeManager();
        Date endDate = new Date(23,1,2018);
        double estimatedTimeUse = 100;
        String projectName = "novoProject";
        String clientName = "NovoNordisk";

        Client client01 = new Client(clientName, endDate, estimatedTimeUse, projectName, firm01);

        // Creating a project
        Project project01 = new Project(client01, firm01);

        //Test of constructor
        assertTrue(project01.active);
        assertEquals(project01.client,client01);
        assertEquals(project01.projectName,projectName);
        assertEquals(project01.endDate,endDate);
        assertEquals(project01.getEstimatedTimeUse(),estimatedTimeUse);
        assertEquals(project01.getTimeUsed(),0);

        // Test of set ProjectID
        String projectID = "23011801";
        project01.setProjectID();
        assertEquals(project01.getProjectID(), projectID);

        // Test of update TimeUsed
        double timeUsed = 17.5;
        project01.updateTimeUsed(timeUsed);
        assertEquals(project01.getTimeUsed(), timeUsed);

        // Test of getRemainingTime
        double remainingTime = estimatedTimeUse - timeUsed;
        assertEquals(project01.getRemainingTime(),remainingTime);

       // updateEstimatedTimeUse is the same function as
        //delayProject in ApplicationLayer.ProjectManager
        // Test of updateEstimatedTimeUse
        estimatedTimeUse = estimatedTimeUse + 50;
        project01.updateEstimatedTimeUse(50);
        assertEquals(project01.getEstimatedTimeUse(),estimatedTimeUse);


        // Test of set/get ApplicationLayer.ProjectManager
        assertEquals(project01.projectManager,null);
        Employee man = new Employee("Helga", firm01);
//        project01.setSpecficProjectManager(man);
        ProjectManager projMan = new ProjectManager(man, project01, firm01);
        assertEquals(project01.projectManager,projMan);

        // Test of set WorkingEmployees
        assertEquals(project01.getWorkingEmployees(), null);
        List<Employee> workingEmployees = new ArrayList<Employee>();
        for (int i = 1; i <= 5; i++){
            workingEmployees.add(new Employee("employee"+i, firm01));
        }
        project01.setWorkingEmployees(workingEmployees);
        assertEquals(project01.getWorkingEmployees(),workingEmployees);

/*        // Test of set Activities
        assertEquals(project01.getActivities(), null);
        List<Activity> activities = new ArrayList<Activity>();
        for (int i = 1; i <= 5; i++){
            activities.add(new Activity("activity"+i));
        }
        project01.setActivities(activities);
        assertEquals(project01.getActivities(),activities);

        // Test of makeProjectReport
        // Make employees as String
        String employees = "";
        for (Employee e : workingEmployees){
            employees = employees + e.getName();
        }
        // Make activities as String
        String activitiesStr = "";
        for (Activity a : activities){
            activitiesStr = activitiesStr + a.getActivityName() + ", " + a.getRemainingTime() + "; ";
        }
        // The test
        String projectReport = "Name = " + projectName + ", ID = " + projectID + ", Time used = " + timeUsed
                + ", Remaining time = " + remainingTime + ", Employees = " + employees + ", Activities = " + activities;
        assertEquals(project01.makeProjectReport(),projectReport);
 */   }

    @Test
    public void ProjectManagerTest(){
        // Creating an employee to be project manager
        TimeManager firm01 = new TimeManager();
        String employeename = "Helga";
        Employee employee01 = new Employee(employeename, firm01);

        // Creating a client (to create a project)
        Date endDate = new Date(23,1,2018);
        double estimatedTimeUse = 100;
        String projectName = "novoProject";
        String clientName = "NovoNordisk";

        Client client01 = new Client(clientName, endDate, estimatedTimeUse, projectName, firm01);

        // Creating a project
        Project project01 = new Project(client01, firm01);
        String projectID = "23011801";
        project01.setProjectID();

        // setting ongoing activities
        List<Activity> ongoingactivities = new ArrayList<Activity>();
        for (int i = 1; i <= 5; i++){
            ongoingactivities.add(new Activity("activity"+i, project01));
        }
        //employee01.setActivities(ongoingactivities);

        // Creating a projectManager
        ProjectManager manager = new ProjectManager(employee01, project01, firm01);

        // Test of constructor
        assertTrue(manager.employee == employee01);
        assertTrue(manager.project == project01);

        // Test of createActivities
        assertTrue(manager.project.getActivities() == null);
        manager.createActivities();
        assertFalse(manager.project.getActivities() == null);

        /*// Test of setEstTimeUse
        for (Activity a : manager.project.getActivities()) {
            manager.setEstTimeUse(a, 10);
        }
        assertTrue(manager.project.getActivities().get(0).getEstimatedTimeUse() == 10);
*/
        // Test of getEmplForProj
        assertTrue(manager.project.getWorkingEmployees() == null);
        assertFalse(manager.project.firm.getFreeEmployees() == null);
        manager.getEmplForProj();
        assertFalse(manager.project.getWorkingEmployees() == null);

        // Test of delegateActivities and getDelegatedActivities
        assertTrue(manager.project.getActivities().size() == manager.project.getWorkingEmployees().size());
        manager.delegateActivities();
        assertFalse(manager.project.getDelegatedActivities() == null);

        // Test findSubstitute
        Employee employee02 = manager.project.getWorkingEmployees().get(0);
        assertTrue(employee02.getActivities().size() == 1);
        Activity activity02 = employee02.getActivities().get(0);
        assertFalse(manager.project.firm.getFreeEmployees() == null);
        employee02.updateAbsence();              // FindSubstitute is called from updateAbsent
        assertTrue(employee02.absence == true);
        assertTrue(manager.project.getWorkingEmployees().size() == manager.project.getActivities().size());

        // Test of delayProject
        assertTrue(manager.project.getEstimatedTimeUse() == 100);
        assertTrue(manager.project.endDate == endDate);
        manager.delayProject(17.5);
        estimatedTimeUse = estimatedTimeUse + 17.5;
        endDate.alterDate(23 + (int)(17.5/8) + 1,01,2018);    // amount of hours/8 (8 hrs. on a regular work day)
        assertTrue(manager.project.getEstimatedTimeUse() == estimatedTimeUse);
        assertTrue(manager.project.endDate == endDate);

        // Test of endProject
        assertTrue(manager.project.active);
        manager.endProject();
        assertFalse(manager.project.active);

        // Test of project meeting
        assertEquals(project01.getProjectID(),projectID);
    }


    @Test
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
    }

}
