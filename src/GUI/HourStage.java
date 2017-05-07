package GUI;

import ApplicationLayer.Date;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;


/**
 * Created by katrinethoft on 05/05/17.
 */

//Stage for choosing a date to register time
public class HourStage extends Stage {
    private  CompanyDriver companyDriver;
    private DatePicker timeRegDate;
    private int day;
    private int month;
    private int year;


    public HourStage(CompanyDriver companyDriver){
        this.companyDriver = companyDriver;

      Scene scene = new Scene(hourPane(), companyDriver.WIDTH, companyDriver.HEIGHT);
        this.setScene(scene);
        this.setResizable(false);
        this.centerOnScreen();
        this.sizeToScene();
        this.setTitle("Please choose a date to see and register hours.");
    }

    private GridPane hourPane() {
        GridPane hourPane = new GridPane();
        timeRegDate = new DatePicker();
        Button timeRegButton = new Button("Confirm");
        timeRegButton.setOnAction(e->timeReg());
        VBox hourBox = new VBox();

        hourBox.getChildren().addAll(timeRegDate ,timeRegButton);
        hourPane.setAlignment(Pos.CENTER);
        hourPane.add(hourBox, 2,1);
        return hourPane;
    }

    private void timeReg() {

        //If chosen date is today, register hours on date
        if(timeRegDate.getValue().isEqual(LocalDate.now())) {
            String[] regDateSplit = timeRegDate.getValue().toString().split("-");
            day = Integer.parseInt(regDateSplit[0]);
            month = Integer.parseInt(regDateSplit[1]);
            year = Integer.parseInt(regDateSplit[2]);

            companyDriver.regTimeDate = new Date(day, month, year);
            companyDriver.startTimeRegStage();
            this.close();

            //If the chosen date is in the past, edit time on the date
        } else if (timeRegDate.getValue().isBefore(LocalDate.now())){
            String[] regDateSplit = timeRegDate.getValue().toString().split("-");
            day = Integer.parseInt(regDateSplit[0]);
            month = Integer.parseInt(regDateSplit[1]);
            year = Integer.parseInt(regDateSplit[2]);

            companyDriver.regTimeDate = new Date(day, month, year);

            companyDriver.startEditTimeStage();
            this.close();
        }
        //If date is invalid or in the future, give error message
        else {
            this.setTitle("Error. You can't register time on this date");
        }
    }
}
