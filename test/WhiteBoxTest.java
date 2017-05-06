/**
 * Created by Daniel Hildebrand on 03-05-2017.
 */
import org.junit.jupiter.api.Test;
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
        ProjectManager manager = new ProjectManager(employee01, project01);

        //No input
        assertEquals(manager.delayProject()==null);

        //pre
        double hourse=17;
        //chechk that time is updated
        manager.delayProject(hourse);
        assertEquals(project01.getEstimatedTimeUse(hourse)==hourse);

        //pre
        double hours = 6.5;
        manager.delayProject(hours);

        //returnere 1 dage til tag udgangs punkt i end date som er 23
        assertEquals(project01.endDate.date == 24);
        //pre
        double hourse=17;

        //returnere 3 dage til tag udgangs punkt i end date som er 23

        assertEquals(project01.endDate.date==26);



        //pre
        double hourse=240;
        manager.delayProject(hours);
        //month stiger til 2
        assertEquals(project01.endDate.month == 2);

        //pre
        double hours= 2880;
        manager.delayProject(hours);
        //year change to 2019
        assertEquals(project01.endDate.year == 2019);




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
         assertEquals(manager.getEmpForPro()==null);

         //pre
         List<Employee> employees = new ArrayList<>();
         for (int i = 0; i < 3; i++) {
             employees.add(new Employee("helga" + i, firm01));
         }
         List<Activity> newActivities = new ArrayList<Activity>();
         for (int i = 1; i <= 1; i++){
             newActivities.add(new Activity("activity"+i, 10));
         }
         //one employee
         assertEquals(manager.getEmpForPro()==1);

         //pre
         List<Activity> newActivities = new ArrayList<Activity>();
         for (int i = 1; i <= 2; i++){
             newActivities.add(new Activity("activity"+i, 10));
         }

         //two  employee
         assertEquals(manager.getEmpForPro() == 2);

         //tjekker if statmentene virker måske 

         for(int i = 0; i<2; ++i) {
             assertTrue(project01.firm.getFreeEmployees().get(i));
         }
         for(int i = 0; i<2; ++i) {
             assertFalse(project01.firm.getFreeEmployees().get(i));
         }

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
/*
         //when there is no employees the EO is none caus for loop is not running
         assertEquals(manager.delegateActivities() == null);
*/
         //pre
         String employeename = "Helga02";
         Employee employee02 = new Employee(employeename, firm01);

         //there is one employee but no activities EO is none.
         assertEquals(manager.delegateActivities(activities, employee02) == null);

         //pre making activities.
         List<Activity> ongoingactivities = new ArrayList<Activity>();
         for (int i = 1; i <= 1; i++){
             ongoingactivities.add(new Activity("activity"+i));
         }

         //There is one Employee and activities EO 1
         assertEquals(manager.delegateActivities(ongoingactivities,employee02) == 1);

         //pre
         List<Employee> Employees = new ArrayList<Employee>)();
         for (int i = 1; i<3;i++){
             Employees.add(new Employee("employee"+i, firm01));
         }
         List<Activity> ongoingactivities = new ArrayList<Activity>();
         for (int i = 1; i <= 3; i++){
             ongoingactivities.add(new Activity("activity"+i));
         }

         //two or more Employee and activites EO assiged activities
         assertEquals(manager.delegateActivities(ongoingactivities,Employees)==3);

         //pre
                 List<Employee> Employees = new ArrayList<Employee>)();
         for (int i = 1; i<3;i++){
             Employees.add(new Employee("employee"+i, firm01));
             Employee.setActivities(ongoingactivities2);
         }

         //two or more employees and activities but stil fail EO non caus of the if statment.
         asserEquals(manager.delegateActivities(ongoingactivities,Employees)==null);
     }
}
