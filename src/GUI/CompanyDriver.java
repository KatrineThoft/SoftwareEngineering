package GUI; /**
 * Created by katrinethoft on 04/05/17.
 */

import ApplicationLayer.*;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.List;

//Driver class for the GUI, runs the stages
public class CompanyDriver extends Application {
	//Setting the size of scenes
    public final  int HEIGHT = 475;
    public final int WIDTH = 500;

    //Creating the necessary fields
    public static TimeManager SoftwareHuset;
    private Employee currentEmpl;
    public ProjectManager currentProjectManager;
    public Project currentProject;
    public Client currentClient;
    public List<Activity> currentActivities;
    public Date regTimeDate;

    //A field for all stages is created
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
    private AbsenceState absenceState;
    private ProjectManagerStage projectManagerStage;
    private DelegateSuccesStage delegateSuccesStage;
    private DelegateFailStage delegateFailStage;
    private MakeProjectRepStage makeRepStage;
    private EndProjectStage endProjectStage;
    private DelayProjectStage delayProjectStage;
    private DelayProjectEndStage delayProjectEndStage;

    public static void main(String[] args) {
        SoftwareHuset = new TimeManager();
        Application.launch(args);
    }

    public void start(Stage first) {

        //Creating the menu page
        first = new MenuStage(this);

        //Showing the stage
        first.show();
    }
    
    //Getter and setter for field currentEmployee
    public Employee getCurrentEmpl(){
        return currentEmpl;
       }

       public void setCurrentEmpl(Employee emp){
           this.currentEmpl = emp;

       }

    //All the different stages in GUI is called by using the following methods
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

    public void startAbsence(){
        absenceState = new AbsenceState(this);
        absenceState.show();
    }

    public void startProjectManagerStage(){
        projectManagerStage = new ProjectManagerStage(this);
        projectManagerStage.show();
    }


    public void startDelegateSucces(){
        delegateSuccesStage = new DelegateSuccesStage(this);
        delegateSuccesStage.show();
    }

    public void startDelegateFailStage(){
        delegateFailStage = new DelegateFailStage(this);
        delegateFailStage.show();
    }

   public void startMakeProjectRepStage(){
	   makeRepStage = new MakeProjectRepStage(this);
	   makeRepStage.show();
   }

    public void startDelayStage(){
        delayProjectStage = new DelayProjectStage(this);
        delayProjectStage.show();
    }

    public void startNewDelayEndStage(){
        delayProjectEndStage = new DelayProjectEndStage(this);
        delayProjectEndStage.show();
    }

    public void startEndProjectStage(){
        endProjectStage = new EndProjectStage(this);
        endProjectStage.show();
    }

}



