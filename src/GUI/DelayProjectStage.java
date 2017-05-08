package GUI;


import javafx.scene.Scene;
import javafx.scene.control.TextField;
//import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

/**
 * Created by katrinethoft on 06/05/17.
 */
//Stage entered when projectmanager wishes to delay the project (add more hours)
public class DelayProjectStage extends Stage {
    private CompanyDriver companyDriver;
    private TextField hoursText;

    public DelayProjectStage(CompanyDriver companyDriver){
    	//Setting the scene
        this.companyDriver = companyDriver;

        Scene scene = new Scene(delayPane(), companyDriver.WIDTH, companyDriver.HEIGHT);

        this.setTitle("How many hours would you like to add?");
        this.setScene(scene);
        this.setResizable(false);
        this.centerOnScreen();
        this.sizeToScene();


    }

    private GridPane delayPane() {
    	//Creating pane, textfield and button
        GridPane delayPane = new GridPane();

        hoursText = new TextField("Number of hours ");

        Button conButton = new Button("Confirm");
        conButton.setOnAction(e-> confirm());

        VBox delayBox = new VBox();
        delayBox.getChildren().addAll(hoursText, conButton);

        delayPane.add(delayBox,2,1 );

    return delayPane;
    }

    //Enters the DelayProjectStage if textfield is non-empty
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
