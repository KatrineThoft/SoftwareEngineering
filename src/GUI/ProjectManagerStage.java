package GUI;


import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
/**
 * Created by katrinethoft on 05/05/17.
 */
//Stage entered when an employee, who is a project manager, clicks the button "Project Manager Profile" in EmpOptStage
public class ProjectManagerStage extends Stage{
    private CompanyDriver companyDriver;


    public ProjectManagerStage(CompanyDriver companyDriver){
    	//Setting the scene
        this.companyDriver = companyDriver;

        Scene scene = new Scene(pManagerPane(), companyDriver.WIDTH, companyDriver.HEIGHT);
        
        this.setTitle("What would you like to do?");
        this.setScene(scene);
        this.setResizable(false);
        this.centerOnScreen();
        this.sizeToScene();

    }

    private GridPane pManagerPane() {
    	//Creating a pane and buttons for all options
        GridPane pManagerPane = new GridPane();

        Label hourLabel = new Label("You have : " + companyDriver.currentProject.getRemainingTime() + " hours left on the project.");

       Button delegateActButton = new Button("Delegate activities");
       delegateActButton.setOnAction(e->delegateAct());

       Button makeRepButton = new Button("Make project report");
       makeRepButton.setOnAction(e->makeRep());

       Button delayProjectButton = new Button("Delay project");
       delayProjectButton.setOnAction(e->delay());

       Button endProjectButton = new Button("End project");
       endProjectButton.setOnAction(e->endProject());

        Button backButton = new Button("Back to employee profile");
        backButton.setOnAction(e -> back());

        backButton.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.ESCAPE){
                Platform.exit();
            }
        });

        VBox pManagerBox = new VBox();
        pManagerBox.getChildren().addAll(hourLabel,delegateActButton, delayProjectButton, makeRepButton,endProjectButton ,backButton);

        pManagerBox.setAlignment(Pos.CENTER);

        pManagerPane.add(pManagerBox, 2,1 );
        return pManagerPane;
    }

    //Tries to delegate the different activities in the project
    //If succes DelegateSuccesStage is entered, otherwise DelegateFailStage is entered
    private void delegateAct() {
        if (!(companyDriver.currentProjectManager.getEmplForProj())) {
            companyDriver.startDelegateFailStage();
            this.close();

        } else if (companyDriver.currentProjectManager.getEmplForProj()) {
            companyDriver.currentProjectManager.delegateActivities();
            companyDriver.startDelegateSucces();
            this.close();
        }
         }
    
    //Enters MakeProjectRepStage
    private void makeRep(){
    	companyDriver.startMakeProjectRepStage();
    	this.close();
    }


    //Enters DelayStage
    private void delay() {
        companyDriver.startDelayStage();
        this.close();
    }

    //Enters EndProjectStage
    private void endProject() {
        companyDriver.startEndProjectStage();
        this.close();
    }
   
    //Enters EmpOptStage
    private void back(){
        companyDriver.startEmpOptStage();
        this.close();
    }


}
