package GUI;

import ApplicationLayer.Employee;
import ApplicationLayer.ProjectManager;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

/**
 * Created by katrinethoft on 05/05/17.
 */
public class DelegateSuccesStage extends Stage {
    private  CompanyDriver companyDriver;

    public DelegateSuccesStage(CompanyDriver companyDriver) {
        this.companyDriver = companyDriver;


        Scene scene = new Scene(delegateActPane(), companyDriver.WIDTH, companyDriver.HEIGHT);

        //Set the stage.
        this.setTitle("All activities in projects has been delegated.");
        this.setScene(scene);
        this.setResizable(false);
        this.centerOnScreen();
        this.sizeToScene();

    }

    private GridPane delegateActPane() {
       GridPane delegateActPane = new GridPane();




        Button backButton = new Button("Back to project manager menu");
        backButton.setOnAction(e-> back());

        delegateActPane.add(backButton, 2,1);
        delegateActPane.setAlignment(Pos.CENTER);

        return delegateActPane;
    }

    private void back() {
        companyDriver.startProjectManagerStage();
        this.close();
    }
}
