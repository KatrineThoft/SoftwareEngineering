package GUI;

import ApplicationLayer.Employee;
import javafx.geometry.Pos;
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
    private CompanyDriver companyDriver;

    public EmplOptStage(CompanyDriver companyDriver) {
        this.companyDriver = companyDriver;
        Scene scene = new Scene(emplOptPane(), companyDriver.WIDTH, companyDriver.HEIGHT);

        this.setScene(scene);
        this.setResizable(false);
        this.centerOnScreen();
        this.sizeToScene();
        this.setTitle("Employee " + companyDriver.getCurrentEmpl().getName() + " logged in");
    }


    private GridPane emplOptPane(){
        GridPane emplOptPane = new GridPane();

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

        Button absenceButton = new Button("Register absence");
        absenceButton.setOnAction(e->absence());

        Button backButton = new Button("Sign out. Back to menu");
        backButton.setOnAction(e-> back());

        VBox empOptBox = new VBox();
        empOptBox.getChildren().addAll(timeRegButton, hourButton, editTimeButton,
                actButton , pMButton, absenceButton,backButton);

        empOptBox.setAlignment(Pos.CENTER);


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
        if(companyDriver.SoftwareHuset.getProjectManagerAsEmployee(companyDriver.getCurrentEmpl()) != null) {
            companyDriver.currentProjectManager = companyDriver.SoftwareHuset.getEmployeeAsProjectManager(companyDriver.getCurrentEmpl());
            companyDriver.startProjectManagerStage();

            this.close();
        } else{
            this.setTitle("Error. You are not a project manager.");
        }
    }

    private void absence(){
        companyDriver.startAbsence();
        this.close();
    }

    private  void back(){
        companyDriver.startMenuStage();
        this.close();
    }
}
