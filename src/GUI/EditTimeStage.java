package GUI;

import ApplicationLayer.Date;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.omg.CORBA.portable.ValueBase;

import javafx.scene.control.TextField;

/**
 * Created by katrinethoft on 05/05/17.
 */
//Stage for editing registered time
public class EditTimeStage extends Stage {
    private CompanyDriver companyDriver;
    private TextField newHoursText;
    private Label labelHour;

    public EditTimeStage(CompanyDriver companyDriver){

        Scene scene = new Scene(editTimePane(), companyDriver.WIDTH, companyDriver.HEIGHT);
        this.companyDriver = companyDriver;
        this.setScene(scene);
        this.setResizable(false);
        this.centerOnScreen();
        this.sizeToScene();
        this.setTitle("Please edit your registered time");
    }

    private GridPane editTimePane() {
        GridPane editTimePane = new GridPane();

        if(companyDriver.getCurrentEmpl().registeredHours.get(companyDriver.regTimeDate) == null){
            labelHour = new Label("You have worked 0.0 hours on " + companyDriver.regTimeDate);
        } else {
            labelHour = new Label("You have worked" +
                    companyDriver.getCurrentEmpl().registeredHours.get(companyDriver.regTimeDate)
                    + "on " + companyDriver.regTimeDate);
        }
        newHoursText = new TextField("Number of hours");

        Button confButton = new Button("Confirm and back to employee menu");
        confButton.setOnAction(e-> confirm());

        VBox editTimeBox = new VBox();
        editTimeBox.getChildren().addAll(labelHour, newHoursText, confButton);

        editTimePane.add(editTimeBox,2,1);

        return editTimePane;
    }

    private void confirm(){
        if(!(newHoursText.getText().isEmpty())){
           Double newHours = Double.parseDouble(newHoursText.getText());
            companyDriver.getCurrentEmpl().updateRegisteredHours(companyDriver.regTimeDate, newHours);

            companyDriver.startEmpOptStage();
            this.close();
        } else{
            this.setTitle("Error. Please enter a number");
        }
    }
}
