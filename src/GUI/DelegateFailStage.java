package GUI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

/**
 * Created by katrinethoft on 06/05/17.
 */

//Stage entered when project manager cannot delegate activities (when there is not enough available employees for the activities)
public class DelegateFailStage extends Stage {
    private CompanyDriver companyDriver;

    public DelegateFailStage(CompanyDriver companyDriver){
        //Setting the scene.
        this.companyDriver = companyDriver;

        Scene scene = new Scene(delegateFailPane(), companyDriver.WIDTH, companyDriver.HEIGHT);
        
        this.setTitle("Error. Could not find enough available employees.");
        this.setScene(scene);
        this.setResizable(false);
        this.centerOnScreen();
        this.sizeToScene();
    }

    private GridPane delegateFailPane() {
    	//Creating pane and button
        GridPane delegateFailPane = new GridPane();
        Button backButton = new Button("Back to project manager menu");
        backButton.setOnAction(e->back());

       delegateFailPane.setAlignment(Pos.CENTER);
        delegateFailPane.add(backButton, 2,1);
        return delegateFailPane;
    }
    
    //Enters ProjectManagerStage
    private void back(){
        companyDriver.startProjectManagerStage();
        this.close();
    }
}
