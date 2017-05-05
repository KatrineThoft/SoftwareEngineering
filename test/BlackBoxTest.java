/**
 * Created by Daniel Hildebrand on 03-05-2017.
 */
import org.junit.jupiter.api.Test;
import ApplicationLayer.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class BlackBoxTest {
    @Test
    public void NewProjectTest(){
        TimeManager firm01 = new TimeManager();
        Date endDate = new Date(23,1,2018);
        double estimatedTimeUse = 100;
        String projectName = "novoProject";
        String clientName = "NovoZyme";
        Employee employee01 = new Employee("Alice", firm01);

        // Client without wanted project manager
        Client client01 = new Client(clientName, endDate, estimatedTimeUse, projectName, firm01);
        // Client with wanted project manager
        Client client02 = new Client(clientName, endDate, estimatedTimeUse, projectName, employee01, firm01);

        // A
        Project project01 = new Project(client01, firm01);
        assertTrue(project01.active);
        assertEquals(project01.client,client01);
        assertEquals(project01.projectName,projectName);
        assertEquals(project01.endDate,endDate);
        assertEquals(project01.getEstimatedTimeUse(),estimatedTimeUse);
        assertEquals(project01.getTimeUsed(),0);
        assertTrue(project01.active);

        // B
        Project project03 = new Project(client02, firm01);
        assertEquals(project03.client,client01);
        assertEquals(project03.projectName,projectName);
        assertEquals(project03.endDate,endDate);
        assertEquals(project03.getEstimatedTimeUse(),estimatedTimeUse);
        assertEquals(project03.getTimeUsed(),0);
        assertTrue(project03.active);
        assertEquals(project03.projectManager.employee.getName(),"Hanne");

        // C
        Project project02 = new Project(null, null);
        assertEquals(project02, null);

        // D
        ProjectManager projMan01 = project03.projectManager;
        List<Activity> activities = new ArrayList<Activity>();
        for (int i = 1; i <= 5; i++){
            activities.add(new Activity("activity"+i));
        }
        projMan01.createActivities(activities);
        assertEquals(projMan01.project.getActivities(), activities);

        // E
        projMan01.createActivities(null);
        assertEquals(projMan01.project.getActivities(), null);

        // F
        projMan01.createActivities(activities);
        projMan01.setEstTimeUse(projMan01.project.getActivities().get(0),10);
        assertTrue(projMan01.project.getActivities().get(0).getEstimatedTimeUse() == 10);

        // G
        projMan01.setEstTimeUse(null, 0);
        assertEquals(projMan01.project.getActivities().get(0).getEstimatedTimeUse(), null);

        // H
        List<Employee> employees = new ArrayList<Employee>();
        for (int i = 1; i <= 5; i++){
            employees.add(new Employee("employee"+i, firm01));
            projMan01.project.firm.addFreeEmployee(new Employee("employee"+i, firm01));
        }
        projMan01.getEmplForProj();
        assertEquals(projMan01.project.getWorkingEmployees(), employees);

        // I
        projMan01.delegateActivities(projMan01.project.getActivities(),projMan01.project.getWorkingEmployees());
        assertEquals(projMan01.getDelegatedActivities().get(projMan01.project.getActivities().get(0)), projMan01.project.getWorkingEmployees().get(0));

        // J
        projMan01.delegateActivities(null,null);
        assertEquals(projMan01.getDelegatedActivities().get(projMan01.project.getActivities().get(0)), null);
    }

    @Test
    public void TimeRegisteringTest(){
        TimeManager firm01 = new TimeManager();
        String employeename = "Helga";
        Employee employee01 = new Employee(employeename, firm01);
        Date endDate = new Date(23,1,2018);
        double estimatedTimeUse = 100;
        String projectName = "novoProject";
        String clientName = "NovoZyme";

        Client client01 = new Client(clientName, endDate, estimatedTimeUse, projectName, firm01);
        Project project01 = new Project(client01, firm01);



        //check the hours is registertet.
        double timeUsed = 17.5;
        employee01.updateRegisteredHours(timeUsed);
        assertTrue(employee01.registeredHours == 17.5);

        project01.updateTimeUsed(timeUsed);

    }

    @Test
    public void RegisteringAbsenceTest(){
        TimeManager firm01 = new TimeManager();
        String employeename01 = "Helga";
        Employee employee01 = new Employee(employeename01, firm01);
        String employeename02 = "Margot";
        Employee employee02 = new Employee(employeename02, firm01);
        Date endDate = new Date(23,1,2018);
        double estimatedTimeUse = 100;
        String projectName = "novoProject";
        String clientName = "NovoZyme";

        Client client01 = new Client(clientName, endDate, estimatedTimeUse, projectName, firm01);
        Project project01 = new Project(client01, firm01);
        project01.setProjectManager(employee01);
        List<Activity> acts = new ArrayList<Activity>();
        acts.add(new Activity("act01"));
        project01.projectManager.createActivities(acts);
        project01.firm.addFreeEmployee(employee02);
        project01.projectManager.getEmplForProj();
        assertTrue(project01.getWorkingEmployees().get(0) == employee02);
        project01.firm.getFreeEmployees().remove(employee02);

        // A
        employee02.updateAbsence();
        assertTrue(employee02.absence == false);

        String employeename03 = "Alice";
        Employee employee03 = new Employee(employeename03, firm01);
        project01.firm.addFreeEmployee(employee03);

        // B
        employee02.updateAbsence();
        assertTrue(employee02.absence == true);

    }



}
