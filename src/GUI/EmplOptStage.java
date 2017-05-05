package GUI;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;


/**
 * Created by katrinethoft on 05/05/17.
 */

//Stage entered when an employee has logged in.
// Shows the different options for actions an employee can make
public class EmplOptStage extends Stage {
    final int HEIGHT = 475;
    final int WIDTH = 500;
    private CompanyDriver companyDriver;

    public EmplOptStage(CompanyDriver companyDriver) {
        this.companyDriver = companyDriver;
        Scene scene = new Scene(emplOptPane(), WIDTH, HEIGHT);

        this.setScene(scene);
        this.setResizable(false);
        this.centerOnScreen();
        this.sizeToScene();
        this.setTitle("Employee " + companyDriver.currentEmpl.getName() + " logged in");
    }


    private GridPane emplOptPane(){
        GridPane emplOptPane = new GridPane();
        emplOptPane.setStyle("-fx-background-color: orange;-fx-padding: 10px;");

        Button timeRegButton = new Button("Time registering");
        timeRegButton.setOnAction(e->timeReg());

        Button hourButton = new Button("See registered hours");
        hourButton.setOnAction(e-> hours());

        Button editTimeButton = new Button("Edit registered time");
        editTimeButton.setOnAction(e->editTime());

        Button actButton = new Button("See ongoing activities");
        actButton.setOnAction(e-> activity());

        Button pMButton = new Button("Project manager profile");
        pMButton.setOnAction(e-> pManager());

        Button backButton = new Button("Sign out. Back to menu");
        backButton.setOnAction(e-> back());

        VBox empOptBox = new VBox();
        empOptBox.getChildren().addAll(timeRegButton, hourButton, editTimeButton, actButton , pMButton, backButton);

        emplOptPane.add(empOptBox, 2, 1);

        return emplOptPane;
    }



    private void timeReg() {
        companyDriver.startTimeRegStage();
        this.close();

    }

    private void editTime() {
        companyDriver.startEditTimeStage();
        this.close();
    }

    private void hours(){
        companyDriver.startHourStage();
        this.close();
    }

    private void activity(){
        companyDriver.startActivityStage();
        this.close();
    }

    private void pManager(){
        companyDriver.startProjectManagerStage();
        this.close();
    }

    private  void back(){
        companyDriver.startMenuStage();
        this.close();
    }
}
