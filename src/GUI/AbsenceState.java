package GUI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

/**
 * Created by katrinethoft on 05/05/17.
 */
public class AbsenceState  extends Stage {
    private CompanyDriver companyDriver;

    public AbsenceState(CompanyDriver companyDriver){

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
        GridPane absencePane = new GridPane();
        Button menuButton = new Button("Back to employee menu");
        absencePane.add(menuButton, 2,1);
        absencePane.setAlignment(Pos.CENTER);


        return absencePane;
    }

}
