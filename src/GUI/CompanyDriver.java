package GUI; /**
 * Created by katrinethoft on 04/05/17.
 */

import ApplicationLayer.Employee;
import ApplicationLayer.TimeManager;
import javafx.application.Application;
import javafx.stage.Stage;

//Driver class for the GUI, runs the stages
public class CompanyDriver extends Application {

    public Employee currentEmpl;
    public static TimeManager SoftwareHuset;
    private MenuStage menuStage;
    private ClientStage clientStage;
    private EmployeeStage employeeStage;
    private NewProjectStage01 newProjectStage01;
    private NewProjectStage02 newProjectStage02;
    private LoginStage loginStage;
    private AddEmplStage addEmplStage;
    private EmplOptStage emplOptStage;
    private TimeRegStage timeRegStage;
    private EditTimeStage editTimeRegStage;
    private HourStage hourStage;
    private ActivityStage activityStage;
    private ProjectManagerStage projectManagerStage;


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

    /*public void setLoggedId(Employee currentEmpl) {
        this.currentEmpl = currentEmpl;
    }*/

//All the different stages in GUI:

    public void startMenuStage(){
        menuStage = new MenuStage(this);
        menuStage.show();
    }

    public  void startClientStage() {
        clientStage = new ClientStage(this);
        clientStage.show();
    }

    public void startEmployeeStage(){
        employeeStage = new EmployeeStage(this);
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

    public void startLoginStage(){
        loginStage = new LoginStage(this);
        loginStage.show();
    }

    public void startAddEmplStage(){
        addEmplStage = new AddEmplStage(this);
        addEmplStage.show();
    }

    public void startEmpOptStage() {
        emplOptStage = new EmplOptStage(this);
        emplOptStage.show();
    }

    public void startTimeRegStage(){
        timeRegStage = new TimeRegStage(this);
        timeRegStage.show();
    }

    public  void startEditTimeStage(){
        editTimeRegStage = new EditTimeStage(this);
        editTimeRegStage.show();
    }

    public  void startHourStage(){
        hourStage = new HourStage(this);
        hourStage.show();

    }

    public void startActivityStage(){
        activityStage = new ActivityStage(this);
        activityStage.show();
    }


    public void startProjectManagerStage(){
        projectManagerStage = new ProjectManagerStage(this);
        projectManagerStage.show();
    }
}
