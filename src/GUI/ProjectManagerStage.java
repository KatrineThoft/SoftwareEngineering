package GUI;

import ApplicationLayer.Employee;
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

        Label hourLabel = new Label("You have : " + companyDriver.currentProject.getRemainingTime() + " hours left on the project.");

       Button delegateActButton = new Button("Delegate activities");
       delegateActButton.setOnAction(e->delegateAct());


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
        pManagerBox.getChildren().addAll(hourLabel,delegateActButton, delayProjectButton, endProjectButton ,backButton);

        pManagerBox.setAlignment(Pos.CENTER);

        pManagerPane.add(pManagerBox, 2,1 );
        return pManagerPane;
    }


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



    private void delay() {
        companyDriver.startDelayStage();
        this.close();
    }

    private void endProject() {
        companyDriver.startEndProjectStage();
        this.close();
    }

    private void back(){
        companyDriver.startEmpOptStage();
        this.close();
    }


}
