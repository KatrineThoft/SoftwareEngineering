package GUI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * Created by katrinethoft on 05/05/17.
 */

//Stage entered when an employee wants to sign in
public class LoginStage extends Stage {		
    private CompanyDriver companyDriver;
    private TextField emplNameText;

    public LoginStage(CompanyDriver companyDriver){
    	//Setting the scene
        Scene scene = new Scene(loginPane(), companyDriver.WIDTH, companyDriver.HEIGHT);
        this.companyDriver = companyDriver;

        this.setTitle("Please enter your name.");

        this.setScene(scene);
        this.setResizable(false);
        this.centerOnScreen();
        this.sizeToScene();
    }

    private GridPane loginPane() {
    	//Creating a pane, textfield and button
        GridPane loginPane = new GridPane();

        emplNameText = new TextField("Name");
        Button conButton = new Button("Confirm");
        conButton.setOnAction(e -> confirm());

        Button backButton = new Button("Back to menu");
        backButton.setOnAction(e -> back());


        VBox loginBox = new VBox();
        loginBox.getChildren().addAll(emplNameText, conButton, backButton);
        loginBox.setAlignment(Pos.CENTER);


        loginPane.add(loginBox, 2, 1);

        return loginPane;
    }
    
    //Enters the EmpOptStage if textfield is non-empty and employee is working at the company
    private void confirm() {
        String emplName = emplNameText.getText();
        if(!(emplName.isEmpty()) &&  CompanyDriver.SoftwareHuset.getEmployeeNames().contains(emplName)){

            companyDriver.setCurrentEmpl(CompanyDriver.SoftwareHuset.getEmployee(emplName));
            companyDriver.startEmpOptStage();
            this.close();

        } else{
            this.setTitle("Employee not found. Please try again.");
        }

    }

    //Enters MenuStage
    private void back(){
        companyDriver.startMenuStage();
        this.close();
    }
}
