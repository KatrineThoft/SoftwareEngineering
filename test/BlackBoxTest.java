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
        Employee employee01 = new Employee("Alice", firm01);

        Client client01 = new Client(clientName, endDate, estimatedTimeUse, projectName, firm01);
        Client client02 = new Client(clientName, endDate, estimatedTimeUse, projectName, employee01, firm01);

        // 1.1 + 3.2
        Project project01 = new Project(client01, firm01);
        assertTrue(project01.active);
        assertEquals(project01.client,client01);
        assertEquals(project01.projectName,projectName);
        assertEquals(project01.endDate,endDate);
        assertEquals(project01.getEstimatedTimeUse(),estimatedTimeUse);
        assertEquals(project01.getTimeUsed(),0);
        assertTrue(project01.active);

        // 1.2 + 3.3
        Project project02 = new Project(null, null);
        assertEquals(project02, null);

        // 3.1
        Project project03 = new Project(client02, firm01);
        assertEquals(project03.client,client01);
        assertEquals(project03.projectName,projectName);
        assertEquals(project03.endDate,endDate);
        assertEquals(project03.getEstimatedTimeUse(),estimatedTimeUse);
        assertEquals(project03.getTimeUsed(),0);
        assertTrue(project03.active);
        assertEquals(project03.projectManager.employee.getName(),"Hanne");

        // 4.1
        ProjectManager projMan01 = project03.projectManager;
        List<Activity> activities = new ArrayList<Activity>();
        for (int i = 1; i <= 5; i++){
            activities.add(new Activity("activity"+i));
        }
        projMan01.createActivities(activities);
        assertEquals(projMan01.project.getActivities(), activities);

        // 4.2
        projMan01.createActivities(null);
        assertEquals(projMan01.project.getActivities(), null);

        // 5.1
        projMan01.createActivities(activities);
        projMan01.setEstTimeUse(project03.getActivities().get(0),10);
        assertTrue(projMan01.project.getActivities().get(0).getEstimatedTimeUse() == 10);

        // 5.2
        projMan01.setEstTimeUse(null, estimatedTimeUse);

        // 6.1
        List<Employee> employees = new ArrayList<Employee>();
        for (int i = 1; i <= 5; i++){
            employees.add(new Employee("employee"+i, firm01));
        }
        projMan01.delegateActivities(activities,employees);
        assertEquals(projMan01.getDelegatedActivities().get(projMan01.project.getActivities().get(0)), employees.get(0));

        // 6.2
        projMan01.delegateActivities(null,null);
        assertEquals(projMan01.getDelegatedActivities().get(projMan01.project.getActivities().get(0)), null);
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
