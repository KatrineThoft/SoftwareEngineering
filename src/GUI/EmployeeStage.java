package GUI;

import ApplicationLayer.Employee;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by katrinethoft on 04/05/17.
 */

//Stage entered when "employee" is clicked in MenuStage
public class EmployeeStage extends Stage {
    final int HEIGHT = 475;
    final int WIDTH = 500;
    CompanyDriver companyDriver;

    public EmployeeStage(CompanyDriver companyDriver){
        Scene scene = new Scene(employeePane(), WIDTH, HEIGHT);
        this.companyDriver = companyDriver;

        //Set the stage.
        this.setTitle("What would you like to do?");

        this.setScene(scene);
        this.setResizable(false);
        this.centerOnScreen();
        this.sizeToScene();

    }

    private GridPane employeePane() {
        GridPane employeePane = new GridPane();

        Button loginButton = new Button("Login");
        Button addEmplButton = new Button("Add a new employee");
        Button backButton = new Button("Back to menu");

        loginButton.setOnAction(e->login());
        addEmplButton.setOnAction(e->addEmpl());
        backButton.setOnAction(e -> back());

        VBox empBox = new VBox();
        empBox.getChildren().addAll( loginButton,addEmplButton , backButton);

        employeePane.setVgap(20);
        employeePane.setStyle("-fx-background-color: green;-fx-padding: 10px;");
        employeePane.add(empBox, 2, 1);

        return employeePane;
    }

    private void login() {
        companyDriver.startLoginStage();
        this.close();
    }

    private void addEmpl(){
        companyDriver.startAddEmplStage();
        this.close();
    }

    private void back(){
        companyDriver.startMenuStage();
        this.close();
    }
}
