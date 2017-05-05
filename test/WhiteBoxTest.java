/**
 * Created by Daniel Hildebrand on 03-05-2017.
 */
import org.junit.jupiter.api.Test;
public class WhiteBoxTest {
    @Test
    public void FindSubstitut(){
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

        //true
        Employee employee02 = manager.project.getWorkingEmployees().get(0);
        Activity activity02 = manager.project.getActivities().get(0);
        employee02.updateAbsence(true);
        assertTrue(manager.findSubstitute(activity02,employee02));

        //false
        Employee employee02 = manager.project.getWorkingEmployees().get(0);
        Activity activity02 = manager.project.getActivities().get(0);
        employee02.updateAbsence(true);
        assertFalse(manager.findSubstitute(activity02,employee02));
     }

     @Test
    public void CreateEmployeeTest(){
         TimeManager firm01 = new TimeManager();
         String employeename = "Helga";
         Employee employee01 = new Employee(employeename, firm01);
         Date endDate = new Date(23,1,2018);
         double estimatedTimeUse = 100;
         String projectName = "novoProject";
         String clientName = "NovoNordisk";

         Client client01 = new Client(clientName, endDate, estimatedTimeUse, projectName, firm01);

         // Creating a project
         Project project01 = new Project(client01, firm01);

         ProjectManager manager = new ProjectManager(employee01, project01);


         List<Activity> newActivities = new ArrayList<Activity>();

         String employeename = "Helga2";
         Employee employee02 = new Employee(employeename, firm01);

         String employeename = "Helga3";
         Employee employee03 = new Employee(employeename, firm01);

        //return no employee
         manager.creatEmployee()
         assertEquals(manager.creatEmployee()==null);

         List<Employee> employees = new ArrayList<>();
         for (int i = 0; i < 3; i++) {
             employees.add(new Employee("helga" + i, firm01));
         }

         //return one employee
         List<Activity> newActivities = new ArrayList<Activity>();
         for (int i = 1; i <= 1; i++){
             newActivities.add(new Activity("activity"+i, 10));
         }

         manager.creatEmployee()
         assertEquals(manager.creatEmployee()==1);

         //return two employee
         List<Activity> newActivities = new ArrayList<Activity>();
         for (int i = 1; i <= 2; i++){
             newActivities.add(new Activity("activity"+i, 10));
         }

         manager.creatEmployee()
         assertEquals(manager.creatEmployee() == 2);

         //tjekker if statmentene virker måske 

         for(int i = 0; i<2; ++i) {
             assertTrue(project01.firm.getFreeEmployees().get(i));
         }
         for(int i = 0; i<2; ++i) {
             assertFalse(project01.firm.getFreeEmployees().get(i));
         }

     }
}
