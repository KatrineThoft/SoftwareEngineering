package GUI;

import ApplicationLayer.Activity;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;

/**
 * Created by katrinethoft on 05/05/17.
 */
public class ActivityStage extends Stage{

    private CompanyDriver companyDriver;

    public ActivityStage(CompanyDriver companyDriver) {
        Scene scene = new Scene(activityPane(), companyDriver.WIDTH, companyDriver.HEIGHT);
        this.companyDriver = companyDriver;

        this.setScene(scene);
        this.setResizable(false);
        this.centerOnScreen();
        this.sizeToScene();
        this.setTitle("All your activities is shown below");

    }

    private GridPane activityPane() {
        GridPane activityPane = new GridPane();
        VBox viewActsBox = new VBox();

        // Creating text for box
        String txt = "no acts";
        if (companyDriver.getCurrentEmpl() != null) {
            txt = companyDriver.getCurrentEmpl().getName();
            if (companyDriver.getCurrentEmpl().getActivities() != null) {
                txt = "";
                for (Activity a : companyDriver.getCurrentEmpl().getActivities()) {
                    txt += a.getActivityName() + ", remaining time: " + a.getRemainingTime() + "\n";
                }
            }
        }
        Text t = new Text();
        t.setText(txt);

        Button backButton = new Button("Back to employee menu");
        backButton.setOnAction(e->back());
        viewActsBox.getChildren().add(backButton);

        activityPane.add(viewActsBox,2,1);
        return activityPane;
    }
    private void back(){
        companyDriver.startEmpOptStage();
        this.close();
    }

}
