package GUI;

import ApplicationLayer.Date;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by katrinethoft on 05/05/17.
 */
public class TimeRegStage extends Stage {
    private CompanyDriver companyDriver;
    private DatePicker regDateInput;
    private int day;
    private int month;
    private int year;
    public Date regDate;
    private TextField regHours;

    public TimeRegStage(CompanyDriver companyDriver){
       Scene scene = new Scene(timeRegPane(), companyDriver.WIDTH, companyDriver.HEIGHT);

    }

    private GridPane timeRegPane() {
        GridPane timeRegPane = new GridPane();
        regDateInput = new DatePicker();
        regHours = new TextField();

        String[] endDateSplit = regDateInput.getValue().toString().split("-");
        day = Integer.parseInt(endDateSplit[0]);
        month = Integer.parseInt(endDateSplit[1]);
        year = Integer.parseInt(endDateSplit[2]);
        regDate = new Date(day, month, year);




        return  timeRegPane;
    }
}
