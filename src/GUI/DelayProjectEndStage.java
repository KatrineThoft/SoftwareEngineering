package GUI;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

/**
 * Created by katrinethoft on 06/05/17.
 */
//Stage entered when projectmanager have delayed a project
public class DelayProjectEndStage extends Stage {
    private CompanyDriver companyDriver;

    public DelayProjectEndStage(CompanyDriver companyDriver){
    	 //Setting the scene.
        this.companyDriver = companyDriver;
        
        Scene scene = new Scene(delayEndPane(), companyDriver.WIDTH, companyDriver.HEIGHT);

        this.setTitle("The hours have been added");
        this.setScene(scene);
        this.setResizable(false);
        this.centerOnScreen();
        this.sizeToScene();

    }

    private GridPane delayEndPane(){
    	//Creating pane and button
        GridPane delayEndPane = new GridPane();
        Button backButton = new Button("Back to project manager profile");
        backButton.setOnAction(e-> back());
        delayEndPane.add(backButton, 2,1 );

        return delayEndPane;
    }

    //Method that go back to the ProjectManagerStage
    private  void back(){
        companyDriver.startProjectManagerStage();
        this.close();
    }
}


