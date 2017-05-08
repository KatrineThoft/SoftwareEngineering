package GUI;

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
    CompanyDriver companyDriver;

    public EmployeeStage(CompanyDriver companyDriver){
    	//Setting the scene
        this.companyDriver = companyDriver;
        Scene scene = new Scene(employeePane(), companyDriver.WIDTH, companyDriver.HEIGHT);
  
        this.setTitle("What would you like to do?");
        this.setScene(scene);
        this.setResizable(false);
        this.centerOnScreen();
        this.sizeToScene();

    }

    private GridPane employeePane() {
    	//Creating pane and buttons for scene
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

        employeePane.add(empBox, 2, 1);

        return employeePane;
    }

    //Methods enter a stage for login, adding a new employee or going back to the menu depending on which button is clicked
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
