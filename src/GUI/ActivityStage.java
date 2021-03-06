package GUI;

import ApplicationLayer.Activity;
import ApplicationLayer.Employee;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;

/**
 * Created by katrinethoft on 05/05/17.
 */
//Stage for seeing employees onogoing activities
public class ActivityStage extends Stage{

    private CompanyDriver companyDriver;

    public ActivityStage(CompanyDriver companyDriver) { 
    	//Setting the scene
        Scene scene = new Scene(activityPane(companyDriver.getCurrentEmpl()), companyDriver.WIDTH, companyDriver.HEIGHT);
        this.companyDriver = companyDriver;

        this.setScene(scene);
        this.setResizable(false);
        this.centerOnScreen();
        this.sizeToScene();
        this.setTitle("All your activities is shown below");

    }

    private GridPane activityPane(Employee empl) {
    	//Creating a pane, buttons and text for the scene
        GridPane activityPane = new GridPane();
        VBox viewActsBox = new VBox();

        // Creating text for box
        String txt = "no acts";
        if (empl != null) {
            txt = empl.getName();
            if (empl.getActivities() != null) {
                txt = "";
                for (Activity a : empl.getActivities()) {
                    txt += a.getActivityName() + ", remaining time: " + a.getRemainingTime() + "\n";
                }
            }
        }
        Text t = new Text();
        t.setText(txt);

        Button backButton = new Button("Back to employee menu");
        backButton.setOnAction(e->back());
        viewActsBox.getChildren().addAll(t, backButton);

        activityPane.add(viewActsBox,2,1);
        return activityPane;
    }
    
    //Method for entering a new stage
    private void back(){
        companyDriver.startEmpOptStage();
        this.close();
    }
}
