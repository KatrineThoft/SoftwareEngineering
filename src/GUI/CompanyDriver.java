package GUI; /**
 * Created by katrinethoft on 04/05/17.
 */

import ApplicationLayer.Employee;
import ApplicationLayer.TimeManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class CompanyDriver extends Application {

    private Employee currentEmpl;
    public static TimeManager SoftwareHuset;
    private MenuStage menuStage;
    private ClientStage clientStage;
    private EmployeeStage employeeStage;
    private NewProjectStage01 newProjectStage01;
    private NewProjectStage02 newProjectStage02;


    public static void main(String[] args) {
        SoftwareHuset = new TimeManager();
        Application.launch(args);
    }

    public void start(Stage first) {

        //Create the login stage
        first = new MenuStage(this);

        //To start just show the loginstage.
        first.show();
    }

    public void setLoggedId(Employee currentEmpl) {
        this.currentEmpl = currentEmpl;
    }



    public void startMenuStage(){
        menuStage = new MenuStage(this);
        menuStage.show();
    }

    public  void startClientStage() {
        clientStage = new ClientStage(this);
        clientStage.show();
    }

    public void startEmployeeStage(){
        employeeStage = new EmployeeStage();
        employeeStage.show();
    }

    public void startNewProjectStage01(){
        newProjectStage01 = new NewProjectStage01(this);
        newProjectStage01.show();

    }

    public void startNewProjectStage02(){
        newProjectStage02 = new NewProjectStage02(this);
        newProjectStage02.show();
    }
}
