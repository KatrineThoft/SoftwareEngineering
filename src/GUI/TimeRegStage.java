package GUI;

import ApplicationLayer.Activity;
import ApplicationLayer.Date;
import javafx.geometry.Pos;
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
    private double totalHours;

    public TimeRegStage(CompanyDriver companyDriver){

       Scene scene = new Scene(timeRegPane(), companyDriver.WIDTH, companyDriver.HEIGHT);
        this.companyDriver = companyDriver;
        this.setScene(scene);
        this.setResizable(false);
        this.centerOnScreen();
        this.sizeToScene();
        this.setTitle("Please enter the number of hours worked on each activity (max 8 hours)");

    }

    private GridPane timeRegPane() {
        GridPane timeRegPane = new GridPane();

        VBox timeRegBox = new VBox();
        Label hourLabels = new Label();
        double hours = 0;

        //Registering time for each activity using textfields
        for(Activity a: companyDriver.getCurrentEmpl().getActivities() ){
            hourLabels.setText(a.getActivityName());

            regHours = new TextField();

            if(!(regHours.getText().isEmpty())) {
                hours = Double.parseDouble(regHours.getText());
            }
            companyDriver.getCurrentEmpl().regHoursOnAct(hours,a);
            totalHours += hours;
            timeRegBox.getChildren().addAll(hourLabels,regHours);
        }


        Button confButton = new Button("Confirm and back to employee menu");
        confButton.setOnAction(e->confirm());

        timeRegBox.getChildren().add(confButton);

        timeRegPane.add(timeRegBox,2,1);
        timeRegPane.setAlignment(Pos.CENTER);

        return  timeRegPane;
    }

    private void confirm(){
            companyDriver.startEmpOptStage();
            this.close();
        }


}
