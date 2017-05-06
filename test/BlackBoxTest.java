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
        double estimatedTimeUse = 50;
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
        Project project02 = new Project(client02, firm01);
        assertEquals(project02.client,client01);
        assertEquals(project02.projectName,projectName);
        assertEquals(project02.endDate,endDate);
        assertEquals(project02.getEstimatedTimeUse(),estimatedTimeUse);
        assertEquals(project02.getTimeUsed(),0);
        assertTrue(project02.active);
        assertEquals(project02.projectManager.employee.getName(),"Hanne");

        // C
        Project project03 = new Project(null, null);
        assertEquals(project03, null);

        // D
        ProjectManager projMan01 = project02.projectManager;
        projMan01.createActivities(); // creates 5 activities bcs. estimatedTimeUse = 50
        assertTrue(projMan01.project.getActivities().size() == 5);

        // E
        projMan01.setEstTimeUse(projMan01.project.getActivities().get(0),10);
        assertTrue(projMan01.project.getActivities().get(0).getEstimatedTimeUse() == 10);

        // F
        projMan01.setEstTimeUse(null, 0);
        assertEquals(projMan01.project.getActivities().get(0).getEstimatedTimeUse(), null);

        // G
        List<Employee> employees = new ArrayList<Employee>();
        for (int i = 1; i <= 5; i++){
            employees.add(new Employee("employee"+i, firm01));
            projMan01.project.firm.addFreeEmployee(new Employee("employee"+i, firm01));
        }
        projMan01.getEmplForProj();
        assertEquals(projMan01.project.getWorkingEmployees(), employees);

        // H
        projMan01.delegateActivities();
        assertEquals(projMan01.project.getDelegatedActivities().get(projMan01.project.getActivities().get(0)), projMan01.project.getWorkingEmployees().get(0));
    }

    @Test
    public void TimeRegisteringTest(){
        TimeManager firm01 = new TimeManager();
        String employeename = "Helga";
        Employee employee01 = new Employee(employeename, firm01);



        /*Date endDate = new Date(23,1,2018);
        double estimatedTimeUse = 50;
        String projectName = "novoProject";
        String clientName = "NovoZyme";

        Client client01 = new Client(clientName, endDate, estimatedTimeUse, projectName, firm01);
        Project project01 = new Project(client01, firm01);

        */


    }

    @Test
    public void RegisteringAbsenceTest(){
        TimeManager firm01 = new TimeManager();
        String employeename01 = "Helga";
        Employee employee01 = new Employee(employeename01, firm01);
        String employeename02 = "Margot";
        Employee employee02 = new Employee(employeename02, firm01);
        Date endDate = new Date(23,1,2018);
        double estimatedTimeUse = 50;
        String projectName = "novoProject";
        String clientName = "NovoZyme";

        // adding employees to free employees in firm01
        List<Employee> employees = new ArrayList<Employee>();
        for (int i = 1; i <= 5; i++){
            firm01.addFreeEmployee(new Employee("employee"+i, firm01));
        }

        Client client01 = new Client(clientName, endDate, estimatedTimeUse, projectName, firm01);
        Project project01 = new Project(client01, firm01);
        project01.firm.addFreeEmployee(employee02);
        project01.setProjectManager(); // is going to be set to employee02
        project01.projectManager.createActivities();  // creates 10 activities bcs. estimatedTimeUse = 100
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
