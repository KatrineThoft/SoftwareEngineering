package GUI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

/**
 * Created by katrinethoft on 06/05/17.
 */
//Stage where project manager ends the project
public class EndProjectStage extends Stage {
    private CompanyDriver companyDriver;

    public EndProjectStage(CompanyDriver companyDriver) {
    	//Setting the scene.
        this.companyDriver = companyDriver;

        Scene scene = new Scene(endProjectPane(), companyDriver.WIDTH, companyDriver.HEIGHT);
        
        this.setTitle("Your project is now complete");
        this.setScene(scene);
        this.setResizable(false);
        this.centerOnScreen();
        this.sizeToScene();

    }
    private GridPane endProjectPane(){
    	//Creating a pane and button 
        GridPane endProjectPane = new GridPane();
        Button backButton = new Button("Back to employee menu");
        backButton.setOnAction(e->back());

        endProjectPane.add(backButton,2,1);
        endProjectPane.setAlignment(Pos.CENTER);

        return endProjectPane;
    }
    
    //Ends project and enters EmployeeStage when button is clicked
    private  void back(){
        companyDriver.currentProjectManager.endProject();
        companyDriver.startEmployeeStage();
        this.close();
    }
}
