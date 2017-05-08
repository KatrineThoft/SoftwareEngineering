package GUI;

import ApplicationLayer.Employee;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Created by katrinethoft on 05/05/17.
 */
//Stage for editing registered time
public class EditTimeStage extends Stage {
    private CompanyDriver companyDriver;
    private TextField newHoursText;
 
    

    public EditTimeStage(CompanyDriver companyDriver){
    	//Setting the scene
        Scene scene = new Scene(editTimePane(), companyDriver.WIDTH, companyDriver.HEIGHT);
        
        this.companyDriver = companyDriver;
       
        this.setScene(scene);
        this.setResizable(false);
        this.centerOnScreen();
        this.sizeToScene();
        this.setTitle("Please edit your registered time");
    }

    private GridPane editTimePane() {
    	//Creating pane, textfield and button
        GridPane editTimePane = new GridPane();

   
        newHoursText = new TextField("Number of hours");

        Button confButton = new Button("Confirm and back to employee menu");
        confButton.setOnAction(e-> confirm());

        VBox editTimeBox = new VBox();
        editTimeBox.getChildren().addAll( newHoursText, confButton);

        editTimePane.add(editTimeBox,2,1);
        editTimePane.setAlignment(Pos.CENTER); 

        return editTimePane;
    }

    
    //Enters EmpOptStage if textfield is non-empty
    private void confirm(){
        if(!(newHoursText.getText().isEmpty())){
           Double newHours = Double.parseDouble(newHoursText.getText());
            companyDriver.getCurrentEmpl().updateRegisteredHours(companyDriver.regTimeDate, newHours);
           System.out.println("Hours: " + companyDriver.getCurrentEmpl().registeredHours.get(companyDriver.regTimeDate));

            companyDriver.startEmpOptStage();
            this.close();
        } else{
            this.setTitle("Error. Please enter a number");
        }
    }
}
