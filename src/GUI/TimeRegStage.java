package GUI;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by katrinethoft on 05/05/17.
 */
public class TimeRegStage extends Stage {
    private CompanyDriver companyDriver;

    public TimeRegStage(CompanyDriver companyDriver){
       Scene scene = new Scene(timeRegPane(), companyDriver.WIDTH, companyDriver.HEIGHT);

    }

    private GridPane timeRegPane() {

        return null;
    }
}
