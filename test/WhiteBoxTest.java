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
    public void CreateEmployee(){

         for(int i = 0; i < this.project.getActivities().size(); ++i) {
             if(this.project.firm.getFreeEmployees().get(i) == null) {
                 System.out.println("not enough available employees");
                 break;
             }

             this.project.getWorkingEmployees().add(this.project.firm.getFreeEmployees().get(i));
         }
     }
}
