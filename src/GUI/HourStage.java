package GUI;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by katrinethoft on 05/05/17.
 */
public class HourStage extends Stage {
    private  CompanyDriver companyDriver;

    public HourStage(CompanyDriver companyDriver){
      Scene scene = new Scene(hourPane(), companyDriver.WIDTH, companyDriver.HEIGHT);
    }

    private GridPane hourPane() {

        return null;
    }
}
