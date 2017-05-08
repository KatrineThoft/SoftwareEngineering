package GUI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

/**
 * Created by katrine thoft on 05/05/17.
 */
public class AbsenceState  extends Stage {
    private CompanyDriver companyDriver;

    public AbsenceState(CompanyDriver companyDriver){
    	//Setting the scene
        Scene scene = new Scene(absencePane(), companyDriver.WIDTH, companyDriver.HEIGHT);
        this.companyDriver = companyDriver;
        
        this.setScene(scene);
        this.setResizable(false);
        this.centerOnScreen();
        this.sizeToScene();
        
        if(companyDriver.getCurrentEmpl().absence){
            this.setTitle("You are now registered absent");
        } else{
            this.setTitle("No possible substitutes, could not register absent");
        }

    }

    private GridPane absencePane(){
    	//Creating a gridpane and buttons for the scene
        GridPane absencePane = new GridPane();
        
        Button menuButton = new Button("Back to employee menu");
        menuButton.setOnAction(e->menu());
        
        absencePane.add(menuButton, 2,1);
        absencePane.setAlignment(Pos.CENTER);

        return absencePane;
    }
    
    private void menu(){
    	companyDriver.startEmpOptStage();
    	this.close();
    }

}
