/**
 * Created by Daniel Hildebrand on 03-05-2017.
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.Test;
import ApplicationLayer.Client;
import ApplicationLayer.Date;
import ApplicationLayer.Employee;
import ApplicationLayer.Project;
import ApplicationLayer.TimeManager;

public class BlackBoxTest {
    @Test
    public void NewProjectTest(){
        TimeManager firm01 = new TimeManager();
        Date endDate = new Date(23,1,2018);
        double estimatedTimeUse = 30;
        String projectName = "novoProject";
        String clientName = "NovoZyme";
        Employee employee01 = new Employee("Alice", firm01);

        // 3 activities will be created for project bcs. estimatedTimeUse = 30
        // so 2 more free employees are created
        Employee employee02 = new Employee("Bob", firm01);
        Employee employee03 = new Employee("Cori", firm01);

        // Client without wanted project manager
        Client client01 = new Client(clientName, endDate, estimatedTimeUse, projectName, firm01);
        // Client with wanted project manager
        Client client02 = new Client(clientName, endDate, estimatedTimeUse, projectName, employee03, firm01);

        // A
        // creating a project
        Project project01 = new Project(client01, firm01);
        // test that all is correct
        assertTrue(project01.active);
        assertEquals(project01.client,client01);
        assertEquals(project01.projectName,projectName);
        assertEquals(project01.endDate,endDate);
        assertEquals(project01.getEstimatedTimeUse(),estimatedTimeUse,0);
        assertEquals(project01.getTimeUsed(),0,0);
        assertTrue(project01.active);
        assertFalse(project01.projectManager == null); // pm has been chosen at random
        // delegating activities
        project01.projectManager.delegateActivities();
        // test that activities have been delegated
        assertEquals(project01.getDelegatedActivities().get(project01.getActivities().get(0)), project01.getWorkingEmployees().get(0));

        // B
        // creating a project
        Project project02 = new Project(client02, firm01);
        // test that all is correct
        assertEquals(project02.client,client02);
        assertEquals(project02.projectName,projectName);
        assertEquals(project02.endDate,endDate);
        assertEquals(project02.getEstimatedTimeUse(),estimatedTimeUse,0);
        assertEquals(project02.getTimeUsed(),0,0);
        assertTrue(project02.active);
        assertEquals(project02.projectManager.employee.getName(),"Cori"); // employee01 has been chosen by the firm to be pm
        // delegate activities
        project02.projectManager.delegateActivities();
        // test that activities have been delegated
        //assertTrue(project02.getDelegatedActivities() == null);
        assertEquals(project02.getDelegatedActivities().get(project02.getActivities().get(0)), project02.getWorkingEmployees().get(0));

        // removing all freeEmployees
        firm01.getFreeEmployees().removeAll(firm01.getFreeEmployees());
        // adding one employee to be pm
        Employee employee04 = new Employee("Deana", firm01);
        // new client that wants employee04 as pm
        Client client03 = new Client(clientName, endDate, estimatedTimeUse, projectName, employee04, firm01);

        // C
        // creating a project
        Project project03 = new Project(client01, firm01);
        // test that all is correct
        assertEquals(project03.client,client01);
        assertEquals(project03.projectName,projectName);
        assertEquals(project03.endDate,endDate);
        assertEquals(project03.getEstimatedTimeUse(),estimatedTimeUse,0);
        assertEquals(project03.getTimeUsed(),0,0);
        assertTrue(project03.active);
        assertFalse(project03.projectManager == null); // pm has been chosen at random
        // delegate activities
        project03.projectManager.delegateActivities();
        // test that activities have not been delegated
        assertTrue(project03.getDelegatedActivities() == null);

        // D
        // creating a project
        Project project04 = new Project(client03, firm01);
        // test that all is correct
        assertEquals(project04.client,client03);
        assertEquals(project04.projectName,projectName);
        assertEquals(project04.endDate,endDate);
        assertEquals(project04.getEstimatedTimeUse(),estimatedTimeUse,0);
        assertEquals(project04.getTimeUsed(),0,0);
        assertTrue(project04.active);
        assertEquals(project04.projectManager.employee.getName(), "Deana"); // employee04 has been chosen by the firm to be pm
        // delegate activities
        project04.projectManager.delegateActivities();
        // test that activities have not been delegated
        assertTrue(project04.getDelegatedActivities() == null);

        // removing all freeEmployees
        firm01.getFreeEmployees().removeAll(firm01.getFreeEmployees());

        // E
        // creating a project
        Project project05 = new Project(client03, firm01);
        // test that pm was not created
        assertEquals(project05.client,client03);
        assertEquals(project05.projectName,projectName);
        assertEquals(project05.endDate,endDate);
        assertEquals(project05.getEstimatedTimeUse(),estimatedTimeUse,0);
        assertEquals(project05.getTimeUsed(),0,0);
        assertTrue(project05.active);
        assertTrue(project05.projectManager == null); // pm not created
    }

    @Test
    public void TimeRegisteringTest(){
        TimeManager firm01 = new TimeManager();
        String employeename = "Helga";
        Employee employee01 = new Employee(employeename, firm01);
        Date date01 = new Date(1,5,2017); // in the past
        Calendar date02H = Calendar.getInstance();
        int day = date02H.get(Calendar.DATE);
        int month = date02H.get(Calendar.MONTH)+1;
        int year = date02H.get(Calendar.YEAR);
        Date date02 = new Date(day, month, year); // current
        Date date03 = new Date(1,5,2020); // in the future

        // A
        assertTrue(employee01.updateRegisteredHours(date01, 7.5));

        // B
        assertTrue(employee01.updateRegisteredHours(date01, 10));
        assertEquals(employee01.registeredHours.get(date01), (Double) 8.0);

        // C
        assertTrue(employee01.updateRegisteredHours(date02, 7.5));

        // D
        assertTrue(employee01.updateRegisteredHours(date02, 10));
        assertEquals(employee01.registeredHours.get(date02), (Double) 8.0);

        // E
        assertFalse(employee01.updateRegisteredHours(date03, 7.5));
    }

    @Test
    public void RegisteringAbsenceTest(){
        TimeManager firm01 = new TimeManager();

        String employeename01 = "Helga";
        Employee employee01 = new Employee(employeename01, firm01);
        String employeename02 = "Margot";
        Employee employee02 = new Employee(employeename02, firm01);
        String employeename03 = "Helle";
        Employee employee03 = new Employee(employeename03, firm01);

        Date endDate = new Date(23,1,2018);
        double estimatedTimeUse = 30;
        String projectName = "novoProject";
        String clientName = "NovoZyme";

        Client client01 = new Client(clientName, endDate, estimatedTimeUse, projectName, employee01, firm01);
        Project project01 = new Project(client01, firm01); // project with Helga as pm
        project01.projectManager.delegateActivities();

        // A
        employee02.updateAbsence();
        assertTrue(employee02.absence);

        // B
        // removing all free employees
        project01.firm.getFreeEmployees().removeAll(project01.firm.getFreeEmployees());

        employee03.updateAbsence();
        assertFalse(employee03.absence);

        // C
        employee02.updateAbsence();
        assertFalse(employee02.absence);
    }

}
