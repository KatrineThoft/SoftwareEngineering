/**
 * Created by Daniel Hildebrand on 03-05-2017.
 */
import ApplicationLayer.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

//import org.junit.jupiter.api.Test;
public class WhiteBoxTest {
/*
	@Test
    public void delayProjectTest(){
        //pre
        TimeManager firm01 = new TimeManager();
        String employeename = "Helga";
        Employee employee01 = new Employee(employeename, firm01);
        Date endDate = new Date(23,1,2018);
        double estimatedTimeUse = 100;
        String projectName = "novoProject";
        String clientName = "NovoZyme";

        Client client01 = new Client(clientName, endDate, estimatedTimeUse, projectName, firm01);
        Project project01 = new Project(client01, firm01);
        ProjectManager manager = new ProjectManager(employee01, project01, firm01);

        assertFalse

        //No input
        assertEquals(manager.delayProject()==null);

        //pre
        double hourse=17;
        //chechk that time is updated
        manager.delayProject(hourse);
        assertEquals(project01.getEstimatedTimeUse(hourse),hourse);

        //pre
        double hours = 6.5;
        manager.delayProject(hours);

        //returnere 1 dage til tag udgangs punkt i end date som er 23
        assertTrue(project01.endDate.date == 24);
        //pre
        double hourse=17;

        //returnere 3 dage til tag udgangs punkt i end date som er 23

        assertTrue(project01.endDate.date==26);



        //pre
        double hourse=240;
        manager.delayProject(hours);
        //month stiger til 2
        assertTrue(project01.endDate.month == 2);

        //pre
        double hours= 2880;
        manager.delayProject(hours);
        //year change to 2019
        assertTrue(project01.endDate.year == 2019);

    }


    @Test
    public void getEmpForProTest(){
         //pre
         TimeManager firm01 = new TimeManager();
         String employeename = "Helga";
         Employee employee01 = new Employee(employeename, firm01);
         Date endDate = new Date(23,1,2018);
         double estimatedTimeUse = 100;
         String projectName = "novoProject";
         String clientName = "NovoNordisk";
         Client client01 = new Client(clientName, endDate, estimatedTimeUse, projectName, firm01);
         Project project01 = new Project(client01, firm01);
         ProjectManager manager = new ProjectManager(employee01, project01);
         List<Activity> newActivities = new ArrayList<Activity>();
         String employeename = "Helga2";
         Employee employee02 = new Employee(employeename, firm01);
         String employeename = "Helga3";
         Employee employee03 = new Employee(employeename, firm01);

        //return no employee
         assertTrue(manager.getEmpForProj()==null);

         //pre
         List<Employee> employees = new ArrayList<>();
         for (int i = 0; i < 3; i++) {
             employees.add(new Employee("helga" + i, firm01));
             firm01.addFreeEmployee();
         }
         List<Activity> newActivities = new ArrayList<Activity>();
         for (int i = 1; i <= 10; i++){
             newActivities.add(new Activity("activity"+i, 10));
         }*/

       /*  //False test
         assertFalse(manager.getEmpForProj() == false);

         //pre
        List<Employee> Employees2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Employees2.add(new Employee("helga" + i, firm01));
            firm01.addFreeEmployee(employees2);
        }
         List<Activity> NewActivities2 = new ArrayList<Activity>();
         for (int i = 0; i <= 2; i++){
             NewActivities2.add(new Activity("activity"+i, 10));
         }

         //true
        assertTrue(manager.getEmpForProj() == true);

        //pre
        List<Activity> NewActivities3 = new ArrayList<Activity>();

        List<Employee> Employees3 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Employees3.add(new Employee("helga" + i, firm01));
            firm01.addFreeEmployee(employees3);
        }

        // zero time
        assertEquals(getNewActivities().size,0);
        assertEquals(project.getWorkingEmployees().size,0);
        assertTrue(getEmpForProj() == true);

        //pre
        List<Activity> NewActivities4 = new ArrayList<Activity>();
        for (int i = 0; i <= 1; i++){
            NewActivities4.add(new Activity("activity"+i, 10));
        }
        List<Employee> Employees4 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Employees4.add(new Employee("helga" + i, firm01));
            firm01.addFreeEmployee(employees4);
        }

        // one time
        assertEquals(getNewActivities().size,1);
        assertEquals(project.getWorkingEmployees().size,1);
        assertTrue(getEmpForProj() == true);


        //pre
        List<Activity> NewActivities5 = new ArrayList<Activity>();
        for (int i = 0; i <= 1; i++){
            NewActivities5.add(new Activity("activity"+i, 10));
        }
        List<Employee> Employees5 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Employees5.add(new Employee("helga" + i, firm01));
            firm01.addFreeEmployee(employees5);
        }


         //two  employee
        assertEquals(getNewActivities().size,2);
        assertEquals(project.getWorkingEmployees().size,2);
        assertTrue(getEmpForProj() == true);
     }

     @Test

    public void DelegacteActivitiesTest(){
        //pre
         TimeManager firm01 = new TimeManager();
         String employeename = "Helga";
         Employee employee01 = new Employee(employeename, firm01);
         Date endDate = new Date(23,1,2018);
         double estimatedTimeUse = 100;
         String projectName = "novoProject";
         String clientName = "NovoNordisk";

         Client client01 = new Client(clientName, endDate, estimatedTimeUse, projectName, firm01);
         Project project01 = new Project(client01, firm01);
         ProjectManager manager = new ProjectManager(employee01, project01);


*/

       /*  //when there is no employees the EO is none caus for loop is not running
         assertEquals(manager.delegateActivities(), null);

         //pre
         String employeename = "Helga02";
         Employee employee02 = new Employee(employeename, firm01);

         //check that there is create activities and that delegate activities is returning null.
         assertEquals(getActivities().size,((estimatedTimeUse-(estimatedTimeUse %10))/10);
         assertFalse(getEmpForProj() == false);
         assertEquals(manager.delegateActivities(),null);

         //pre
         estimatedTimeUse = 10;
         List<Employee> Employees1 = new ArrayList<Employee>)();
         for (int i = 1; i<13;i++){
             Employees1.add(new Employee("employee"+i, firm01));
         }


         //There is one Employee and activities EO 1
         assertTrue(getEmpForProj() == true);
         assertEquals(manager.delegateActivities(),1);

         //pre
         List<Employee> Employees = new ArrayList<Employee>)();
         for (int i = 1; i<3;i++){
             Employees.add(new Employee("employee"+i, firm01));
         }
         estimatedTimeUse=30;

         //two or more Employee and activites EO assiged activities
         assertEquals(manager.delegateActivities(),3);

         //pre mangler en pre
                 List<Employee> Employees = new ArrayList<Employee>)();
         for (int i = 1; i<13;i++){
             Employees.add(new Employee("employee"+i, firm01));
             Employee.setActivities(ongoingactivities2);
         }


         //check that a person is removed if the have 10 or more activities.
         asserEquals(project.getWorkingEmployees().size,getEmployees.size-1);
     }*/
}
