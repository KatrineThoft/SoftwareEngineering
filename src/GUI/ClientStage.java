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

//Stage entered when clicking "client" in MenuStage
public class ClientStage extends Stage {

    final int HEIGHT = 475;
    final int WIDTH = 500;
    private CompanyDriver companyDriver;

    public ClientStage(CompanyDriver companyDriver) {

        this.companyDriver = companyDriver;

        Scene scene = new Scene(clientPane(), WIDTH, HEIGHT);

        //Set the stage.
        this.setTitle("What would you like to do?");

        this.setScene(scene);
        this.setResizable(false);
        this.centerOnScreen();
        this.sizeToScene();

    }
    private GridPane clientPane() {
        GridPane clientPane = new GridPane();

        Button newProjectButton = new Button("Create new project");
        Button backButton = new Button("Go back");

        newProjectButton .setOnAction(e -> newProject());
        backButton.setOnAction(e -> back());

        newProjectButton.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.P) {
                newProject();
            }
            else if(e.getCode() == KeyCode.ESCAPE){
                Platform.exit();
            }
        });

        VBox cliBox = new VBox();
        cliBox.getChildren().addAll(newProjectButton, backButton);
        clientPane.setStyle("-fx-background-color: red;-fx-padding: 10px;");
        clientPane.setVgap(20);
        clientPane.add(cliBox, 4, 1);

        return clientPane;

    }

    private void newProject() {
        companyDriver.startNewProjectStage01();
        this.close();
    }

    private void back(){
        companyDriver.startMenuStage();
        this.close();
    }
}
