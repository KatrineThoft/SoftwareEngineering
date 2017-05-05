package GUI;

import GUI.CompanyDriver;
import javafx.application.Platform;
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

        final int HEIGHT = 475;
        final int WIDTH = 500;

        this.companyDriver = driver;

        Scene scene = new Scene(menuPane(), WIDTH, HEIGHT);

        //Set the stage.
        this.setTitle("Welcome to SoftwareHuset A/S");

        this.setScene(scene);
        this.setResizable(false);
        this.centerOnScreen();
        this.sizeToScene();
    }


    private GridPane menuPane() {
        GridPane menuPane = new GridPane();

        Button cliButton = new Button("Client");
        Button empButton = new Button("Employee");
        Button exitButton = new Button("Exit");
        cliButton.setOnAction(e -> client());
        empButton.setOnAction(e -> employee());
        exitButton.setOnAction(actionEvent -> Platform.exit());

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
        menuPane.setStyle("-fx-background-color: blue;-fx-padding: 10px;");
        menuPane.setVgap(20);
        menuPane.add(menuBox, 4, 1);

        return menuPane;
    }

    private void client() {
        companyDriver.startClientStage();
        this.close();
    }

    private void employee() {
        companyDriver.startEmployeeStage();
        this.close();
    }


}
