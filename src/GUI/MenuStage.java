package GUI;

import GUI.CompanyDriver;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by katrinethoft on 04/05/17.
 */

//First stage of GUI
    //Shows the menu when running the GUI
public class MenuStage extends Stage{
    private GUI.CompanyDriver companyDriver;


    public MenuStage(CompanyDriver driver) {
    	//Setting the scene.
        this.companyDriver = driver;
        Scene scene = new Scene(menuPane(), companyDriver.WIDTH, companyDriver.HEIGHT);

        this.setTitle("Welcome to SoftwareHuset A/S");
        this.setScene(scene);
        this.setResizable(false);
        this.centerOnScreen();
        this.sizeToScene();
    }


    private GridPane menuPane() {
    	//Creating a pane and the buttons for the menu
        GridPane menuPane = new GridPane();

        Button cliButton = new Button("Client");
        cliButton.setOnAction(e -> client());
        
        Button empButton = new Button("Employee");
        empButton.setOnAction(e -> employee());
        
        //Exits the system
        Button exitButton = new Button("Exit");
        exitButton.setOnAction(actionEvent -> Platform.exit());

        //Makes it possible to use keys to choose an option
        cliButton.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.C) {
                client();
            }
            else if(e.getCode() == KeyCode.E){
                employee();
            }
            else if(e.getCode() == KeyCode.ESCAPE){
                Platform.exit();
            }
        });

        VBox menuBox = new VBox();
        menuBox.getChildren().addAll(cliButton, empButton, exitButton);
        menuBox.setAlignment(Pos.CENTER);

        menuPane.setVgap(20);
        menuPane.add(menuBox, 4, 1);

        return menuPane;
    }

    //Enters ClientStage when button is clicked
    private void client() {
        companyDriver.startClientStage();
        this.close();
    }

    //Enters EmployeeStage when button is clicked
    private void employee() {
        companyDriver.startEmployeeStage();
        this.close();
    }


}
