package GUI;

import ApplicationLayer.Employee;
import javafx.geometry.Pos;
import javafx.scene.Parent;
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
        Scene scene = new Scene(loginPane(), companyDriver.WIDTH, companyDriver.HEIGHT);
        this.companyDriver = companyDriver;

        //Set the stage.
        this.setTitle("Please enter your name.");

        this.setScene(scene);
        this.setResizable(false);
        this.centerOnScreen();
        this.sizeToScene();

    }

    private GridPane loginPane() {
        GridPane loginPane = new GridPane();

        emplNameText = new TextField("Name");
        Button conButton = new Button("Confirm");
        conButton.setOnAction(e -> confirm());

        Button backButton = new Button("Back to menu");
        backButton.setOnAction(e -> back());


        VBox loginBox = new VBox();
        loginBox.getChildren().addAll(emplNameText, conButton, backButton);
        loginBox.setAlignment(Pos.CENTER);


        loginPane.setStyle("-fx-background-color: turquoise;-fx-padding: 10px;");
        loginPane.add(loginBox, 2, 1);

        return loginPane;
    }

    private void confirm() {
        String emplName = emplNameText.getText();
        if(!(emplName.isEmpty()) &&  companyDriver.SoftwareHuset.getEmployeeNames().contains(emplName)){
          companyDriver.currentEmpl= companyDriver.SoftwareHuset.getEmployee(emplName);

          companyDriver.startEmpOptStage();
          this.close();
        } else{
            this.setTitle("No name entered. Please try again.");
        }

    }

    private void back(){
        companyDriver.startMenuStage();
        this.close();
    }
}
