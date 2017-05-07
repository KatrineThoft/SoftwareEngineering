package GUI;

import ApplicationLayer.Activity;
import ApplicationLayer.Date;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Arrays;

/**
 * Created by katrinethoft on 05/05/17.
 */

//Stage for registering time for today's date.
public class TimeRegStage extends Stage {
    private CompanyDriver companyDriver;
    private DatePicker regDateInput;
    private int day;
    private int month;
    private int year;
    private TextField regHours;
    private String[] actHours;

    public TimeRegStage(CompanyDriver companyDriver){

       Scene scene = new Scene(timeRegPane(), companyDriver.WIDTH, companyDriver.HEIGHT);
        this.companyDriver = companyDriver;
        this.setScene(scene);
        this.setResizable(false);
        this.centerOnScreen();
        this.sizeToScene();
        this.setTitle("Please enter the number of hours worked on each activity");

    }

    private GridPane timeRegPane() {
        GridPane timeRegPane = new GridPane();

        VBox timeRegBox = new VBox();
        Label[] hourLabels = new Label[companyDriver.getCurrentEmpl().getActivities().size()];
        actHours = new String[companyDriver.getCurrentEmpl().getActivities().size()];

        for (int i = 0; i < companyDriver.getCurrentEmpl().getActivities().size(); i++) {
            hourLabels[i].setText("Activity" + i);

            regHours = new TextField();

            actHours[i] = regHours.getText();
            timeRegBox.getChildren().addAll(hourLabels[i],regHours);

        }

        Button confButton = new Button("Confirm and back to employee menu");
        confButton.setOnAction(e->confirm());


        companyDriver.regTimeDate = new Date(day, month, year);



        return  timeRegPane;
    }

    private void confirm(){
        if(Arrays.asList(actHours).contains(null)){
            this.setTitle("Please fill out all text fields. Enter 0 if no hours worked on project.");
        } else{
            //Registrer timer
            companyDriver.startEmpOptStage();
            this.close();
        }

    }
}
