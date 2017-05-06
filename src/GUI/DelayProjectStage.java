package GUI;

import ApplicationLayer.Employee;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

/**
 * Created by katrinethoft on 06/05/17.
 */
public class DelayProjectStage extends Stage {
    private CompanyDriver companyDriver;
    private TextField hoursText;

    public DelayProjectStage(CompanyDriver companyDriver){
        this.companyDriver = companyDriver;


        Scene scene = new Scene(delayPane(), companyDriver.WIDTH, companyDriver.HEIGHT);

        //Set the stage.
        this.setTitle("How many hours would you like to add?");
        this.setScene(scene);
        this.setResizable(false);
        this.centerOnScreen();
        this.sizeToScene();


    }

    private GridPane delayPane() {
        GridPane delayPane = new GridPane();

        hoursText = new TextField("Number of hours ");


        Button conButton = new Button("Confirm");
        conButton.setOnAction(e-> confirm());

        VBox delayBox = new VBox();

        delayBox.getChildren().addAll(hoursText, conButton);


        delayPane.add(delayBox,2,1 );

    return delayPane;
    }


    private void confirm(){
        if(!(hoursText.getText().isEmpty())){
            String hourString = hoursText.getText() ;
            double hours = Double.parseDouble(hourString);
            companyDriver.currentProjectManager.delayProject(hours);

            companyDriver.startNewDelayEndStage();
            this.close();
        }
        else {
            this.setTitle("Error, no number entered");
        }
    }
}
