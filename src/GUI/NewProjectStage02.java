package GUI;

import GUI.CompanyDriver;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by katrinethoft on 04/05/17.
 */
public class NewProjectStage02 extends Stage {
    private CompanyDriver companyDriver;

    //Stage entered when client has created a new project
    public NewProjectStage02 (CompanyDriver companyDriver){
    	//Setting the scene
        this.companyDriver = companyDriver;
        Scene scene = new Scene(NPS02Pane(), companyDriver.WIDTH, companyDriver.HEIGHT);

        this.setTitle("Thank you! Your project has been created.");
        this.setScene(scene);
        this.setResizable(false);
        this.centerOnScreen();
        this.sizeToScene();
    }

    public GridPane NPS02Pane(){
    	//Creating pane and button
        GridPane NPS02Pane =new GridPane();

        Button backButton = new Button("Go back");
        backButton.setOnAction(e -> back());
        Button exitButton = new Button("Exit");
        exitButton.setOnAction(actionEvent -> Platform.exit());

        NPS02Pane.setVgap(20);
        NPS02Pane.setAlignment(Pos.CENTER);
        NPS02Pane.add(backButton, 4,1 );
        NPS02Pane.add(exitButton,4 ,2);

        return NPS02Pane;
    }

    //Entering the MenuStage
    private void back(){
        companyDriver.startMenuStage();
        this.close();
    }
}
