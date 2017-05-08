package GUI;


import ApplicationLayer.Employee;
import GUI.CompanyDriver;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
//import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;


/**
 * Created by katrinethoft on 05/05/17.
 */

//Stage entered when a new employee needs to be added to the company.
public class AddEmplStage extends Stage {
    private CompanyDriver companyDriver;
    private TextField newEmplName;
    public Employee newEmployee;

    public AddEmplStage(CompanyDriver companyDriver){ 
    	   //Setting the scene.
        Scene scene = new Scene(addEmplPane(), companyDriver.WIDTH, companyDriver.HEIGHT);

        this.companyDriver = companyDriver;
     
        this.setTitle("Please enter the name of new employee.");

        this.setScene(scene);
        this.setResizable(false);
        this.centerOnScreen();
        this.sizeToScene();
    }

    private GridPane addEmplPane() {
    	//Creating a pane and the text field for the scene
        GridPane addEmplPane = new GridPane();

        newEmplName = new TextField("New employee");

        Button conButton = new Button("Confirm");
        conButton.setOnAction(e -> confirm());

        VBox addEmplBox = new VBox();
        addEmplBox.getChildren().addAll(newEmplName, conButton);
        addEmplBox.setAlignment(Pos.CENTER);

        addEmplPane.add(addEmplBox, 2, 1);
        return addEmplPane;
    }
    
    //Method for entering a new stage, stage only changed if textfield is non-empty
    private void confirm(){
        String emplName = newEmplName.getText();
        if(!(emplName.isEmpty())) {
            newEmployee = new Employee(emplName, CompanyDriver.SoftwareHuset);
        
            companyDriver.startEmployeeStage();
            this.close();

        } else{
            this.setTitle("Error. Please enter the name of new employee.");
        }
    }
}
