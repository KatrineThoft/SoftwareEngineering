package GUI;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by katrinethoft on 05/05/17.
 */
public class EditTimeStage extends Stage {
    private CompanyDriver companyDriver;

    public EditTimeStage(CompanyDriver companyDriver){

        Scene scene = new Scene(editTimerPane(), companyDriver.WIDTH, companyDriver.HEIGHT);

    }
}