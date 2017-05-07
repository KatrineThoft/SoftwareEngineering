package GUI;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

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
        this.setTitle("Would ");
    }

    private GridPane absencePane(){
        GridPane absencePane = new GridPane();



        return absencePane;
    }

}
