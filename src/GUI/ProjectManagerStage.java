package GUI;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
/**
 * Created by katrinethoft on 05/05/17.
 */
public class ProjectManagerStage extends Stage{
    private CompanyDriver companyDriver;

    public ProjectManagerStage(CompanyDriver companyDriver){
        this.companyDriver = companyDriver;

        Scene scene = new Scene(pManagerPane(), companyDriver.WIDTH, companyDriver.HEIGHT);

        //Set the stage.
        this.setTitle("What would you like to do?");

        this.setScene(scene);
        this.setResizable(false);
        this.centerOnScreen();
        this.sizeToScene();

    }

    private GridPane pManagerPane() {
        GridPane pManagerPane = new GridPane();


       Button createActButton = new Button("Create activities");
       createActButton.setOnAction(e-> createAct());

       Button setEstTimeButton = new Button("Set time use for an activity");
       setEstTimeButton.setOnAction(e-> setEstTime());

       Button createEmplButton = new Button("Assign employees to project");
       createEmplButton.setOnAction(e->createEmpl());

       Button delegateActButton = new Button("Delegate activities");
       delegateActButton.setOnAction(e->delegateAct());

       Button getDelegatedActButton = new Button("See delegated activities");
       getDelegatedActButton.setOnAction(e-> getDelegatedAct());

       Button findSubButton = new Button("Find substitute for abscent employee");
       findSubButton.setOnAction(e->findSub());

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
        pManagerBox.getChildren().addAll(createActButton,setEstTimeButton,  createEmplButton, delegateActButton,
                getDelegatedActButton, findSubButton, delayProjectButton, backButton);

        pManagerBox.setAlignment(Pos.CENTER);

        pManagerPane.add(pManagerBox, 2,1 );
        return pManagerPane;
    }

    private void createAct() {
        companyDriver.startCreateActivityStage();
        this.close();
    }

    private void setEstTime(){
        companyDriver.startSetEstTimeStage();
        this.close();
    }

    private void createEmpl(){
        companyDriver.startCreateEmployeeStage();
        this.close();

    }

    private void delegateAct() {
        companyDriver.startDelegateActivityeStage();
        this.close();
    }

    private void findSub() {
        companyDriver.startFindSubStage();
        this.close();
    }

    private void delay() {
        companyDriver.startDelayStage();
        this.close();
    }

    private void endProject() {
        companyDriver.startEndProjectStage();
        this.close();
    }

    public void getDelegatedAct() {
        companyDriver.startgetDelegatedActStage();
        this.close();
    }

    private void back(){
        companyDriver.startEmployeeStage();
        this.close();
    }


}
