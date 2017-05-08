
/**
 * Created by Daniel Hildebrand on 03-05-2017.
 */
import ApplicationLayer.Date;

import ApplicationLayer.*;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;
public class WhiteBoxTest {

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
        ProjectManager manager = new ProjectManager(employee01, project01,firm01);



        //No input
        //assertEquals(manager.delayProject(),null);

        //pre
        double hourse=0;
        //chechk that time is updated
        manager.delayProject(hourse);
        assertEquals(project01.getEstimatedTimeUse(),100+hourse,0.0);

        //pre
        double hours = 6.5;
        project01 = new Project(client01, firm01);
        manager = new ProjectManager(employee01, project01,firm01);
        manager.delayProject(hours);

        //returnere 1 dage til tag udgangs punkt i end date som er 23
        assertEquals(project01.endDate.date, 24,0.0);

        //pre
        hourse=17;
        endDate = new Date(23,1,2018);
        client01 = new Client(clientName, endDate, estimatedTimeUse, projectName, firm01);
        project01 = new Project(client01, firm01);
        manager = new ProjectManager(employee01, project01,firm01);
        manager.delayProject(hourse);

        //returnere 3 dage til tag udgangs punkt i end date som er 23

        assertEquals(project01.endDate.date,26,0.0);



        //pre
        hourse=240;
        endDate = new Date(23,1,2018);
        client01 = new Client(clientName, endDate, estimatedTimeUse, projectName, firm01);
        project01 = new Project(client01, firm01);
        manager = new ProjectManager(employee01, project01,firm01);
        manager.delayProject(hourse);
        //month stiger til 2
        assertEquals(project01.endDate.month,2,0.0);

        //pre
        hours= 2880.0;
        endDate = new Date(23,1,2018);
        client01 = new Client(clientName, endDate, estimatedTimeUse, projectName, firm01);
        project01 = new Project(client01, firm01);
        manager = new ProjectManager(employee01, project01,firm01);
        manager.delayProject(hours);
        //year change to 2019
        assertEquals(project01.endDate.year,2019,0.0);

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
         ProjectManager manager = new ProjectManager(employee01, project01,firm01);
         List<Activity> newActivities = new ArrayList<Activity>();
         String employeename1 = "Helga2";
         Employee employee02 = new Employee(employeename, firm01);
         String employeename2 = "Helga3";
         Employee employee03 = new Employee(employeename, firm01);



         //pre
         List<Employee> employees = new ArrayList<>();
         for (int i = 0; i < 3; i++) {
             employees.add(new Employee("helga" + i, firm01));
         }
         newActivities = new ArrayList<Activity>();
         for (int i = 1; i <= 10; i++){
             newActivities.add(new Activity("activity"+i, project01));
         }

         //False test
         assertFalse(manager.getEmplForProj() == false);

         //pre
        List<Employee> Employees2 = new ArrayList<>() ;
        for (int i = 0; i < 10; i++) {
            Employees2.add(new Employee("helga" + i, firm01));
        }
         List<Activity> NewActivities2 = new ArrayList<Activity>();
         for (int i = 0; i <= 2; i++){
             NewActivities2.add(new Activity("activity"+i, project01));
         }

         //true
        assertTrue(manager.getEmplForProj() == true);

        //pre
        List<Activity> NewActivities3 = new ArrayList<Activity>();

        List<Employee> Employees3 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Employees3.add(new Employee("helga" + i, firm01));
        }

        // zero time
        assertEquals(project01.getActivities().size(),0);
        assertEquals(project01.getWorkingEmployees().size(),0);
        assertTrue(manager.getEmplForProj() == true);

        //pre
        estimatedTimeUse=10;
        client01 = new Client(clientName, endDate, estimatedTimeUse, projectName, firm01);
        project01 = new Project(client01, firm01);
        manager = new ProjectManager(employee01, project01,firm01);
        manager.delegateActivities();


        // one time
        assertEquals(project01.getActivities().size(),1);
        assertEquals(project01.getWorkingEmployees().size(),1);
        assertTrue(manager.getEmplForProj() == true);


        //pre

        estimatedTimeUse=20;
        client01 = new Client(clientName, endDate, estimatedTimeUse, projectName, firm01);
        project01 = new Project(client01, firm01);
        manager = new ProjectManager(employee01, project01,firm01);
        manager.delegateActivities();


         //two  employee


        assertEquals(project01.getActivities().size(),2);
        assertEquals(project01.getWorkingEmployees().size(),2);
        assertTrue(manager.getEmplForProj() == true);
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
         ProjectManager manager = new ProjectManager(employee01, project01,firm01);




         //when there is no employees the EO is none caus for loop is not running
         //assertEquals(manager.delegateActivities(), null);
     /*
         //pre
         String employeename1 = "Helga02";
         Employee employee02 = new Employee(employeename1, firm01);
         manager.delegateActivities();

        //check that there is create activities and that delegate activities is returning null.
        assertEquals(project01.getActivities().size(),((estimatedTimeUse-(estimatedTimeUse %10))/10),0.0);
        //assertFalse(manager.getEmplForProj() == false);
        //assertEquals(manager.delegateActivities(),null);

         //pre
         estimatedTimeUse = 10;
         client01 = new Client(clientName, endDate, estimatedTimeUse, projectName, firm01);
         project01 = new Project(client01, firm01);
         manager = new ProjectManager(employee01, project01,firm01);
         manager.delegateActivities();



         //There is one Employee and activities EO 1

         //manager.delegateActivities();
         assertEquals(project01.getWorkingEmployees().size(),1);
         assertEquals(project01.getDelegatedActivities().size(),1);
         assertTrue(manager.getEmplForProj() == true);
  */
         //pre
         List<Employee> Employees = new ArrayList<Employee>();
         for (int i = 1; i<13;i++){
             Employees.add(new Employee("employee"+i, firm01));
             //Employee.setActivities(ongoingactivities2);
         }

         estimatedTimeUse = 30;
         client01 = new Client(clientName, endDate, estimatedTimeUse, projectName, firm01);
         project01 = new Project(client01, firm01);
         manager = new ProjectManager(employee01, project01,firm01);
         manager.delegateActivities();

         //two or more Employee and activites EO assiged activities
         assertEquals(project01.getWorkingEmployees().size(),3);
         assertEquals(project01.getDelegatedActivities().size(),3);
     /*
         //pre mangler en pre
         List<Employee> Employees1 = new ArrayList<Employee>();
         for (int i = 1; i<13;i++){
             Employees1.add(new Employee("employee"+i, firm01));
             //Employee.setActivities(ongoingactivities);
         }
         List<Activity> activities= new ArrayList<Activity>();
         for(int i=0;i<=10;i++){
        	 activities.add(new Activity("activity"+i, project01));
         }
         project01.getWorkingEmployees().get(1).getActivities().addAll(activities);

         estimatedTimeUse = 130;
         client01 = new Client(clientName, endDate, estimatedTimeUse, projectName, firm01);
         project01 = new Project(client01, firm01);
         manager = new ProjectManager(employee01, project01,firm01);
         manager.delegateActivities();

         //check that a person is removed if the have 10 or more activities.
         //assertEquals(project01.getWorkingEmployees().size(),9);
         assertEquals(project01.getWorkingEmployees().size(),12);
     */}
}

