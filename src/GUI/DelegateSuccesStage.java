package GUI;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

/**
 * Created by katrinethoft on 05/05/17.
 */
//Stage entered when project manager succeeded in delegating all activities in project
public class DelegateSuccesStage extends Stage {
    private  CompanyDriver companyDriver;

    public DelegateSuccesStage(CompanyDriver companyDriver) {
    	//Set the scene
        this.companyDriver = companyDriver;

        Scene scene = new Scene(delegateActPane(), companyDriver.WIDTH, companyDriver.HEIGHT);
        
        this.setTitle("All activities in projects has been delegated.");
        this.setScene(scene);
        this.setResizable(false);
        this.centerOnScreen();
        this.sizeToScene();

    }

    private GridPane delegateActPane() {
    	//Creating pane and buttons
       GridPane delegateActPane = new GridPane();

        Button backButton = new Button("Back to project manager menu");
        backButton.setOnAction(e-> back());

        delegateActPane.add(backButton, 2,1);
        delegateActPane.setAlignment(Pos.CENTER);

        return delegateActPane;
    }

    //Enters ProjectManagerStage
    private void back() {
        companyDriver.startProjectManagerStage();
        this.close();
    }
}
