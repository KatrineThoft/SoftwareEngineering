package GUI;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by katrinethoft on 05/05/17.
 */
public class ActivityStage extends Stage{

    private CompanyDriver companyDriver;

    public ActivityStage(CompanyDriver companyDriver) {
        Scene scene = new Scene(activityPane(), companyDriver.WIDTH, companyDriver.HEIGHT);

    }

    private GridPane activityPane() {
    }
}
