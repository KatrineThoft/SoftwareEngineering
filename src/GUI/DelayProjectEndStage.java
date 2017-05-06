package GUI;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

/**
 * Created by katrinethoft on 06/05/17.
 */
public class DelayProjectEndStage extends Stage {
    private CompanyDriver companyDriver;

    public DelayProjectEndStage(CompanyDriver companyDriver){


        this.companyDriver = companyDriver;


        Scene scene = new Scene(delayEndPane(), companyDriver.WIDTH, companyDriver.HEIGHT);

        //Set the stage.
        this.setTitle("The hours have been added");
        this.setScene(scene);
        this.setResizable(false);
        this.centerOnScreen();
        this.sizeToScene();

    }

    private GridPane delayEndPane(){
        GridPane delayEndPane = new GridPane();
        Button backButton = new Button("Back to project manager profile");
        backButton.setOnAction(e-> back());
        delayEndPane.add(backButton, 2,1 );

        return delayEndPane;
    }

    private  void back(){
        companyDriver.startProjectManagerStage();
        this.close();
    }
}


