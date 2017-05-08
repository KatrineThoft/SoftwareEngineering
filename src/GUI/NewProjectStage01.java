package GUI;

import java.util.Locale;

import ApplicationLayer.*;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * Created by katrinethoft on 04/05/17.
 */

//Stage entered when a client wants to create a new project
public class NewProjectStage01 extends Stage {
	//Creating fields
    private CompanyDriver companyDriver;
    private TextField comNameInput;
    private TextField proNameInput;
    private TextField empNameInput;
    private DatePicker endDateInput;
    private TextField estimateInput;
    public Employee empl;
    private int day;
    private int month;
    private int year;
    public Date endDate;
    public double estimate;

    public NewProjectStage01(CompanyDriver companyDriver){
    	//Setting the scene
        this.companyDriver = companyDriver;

        Scene scene = new Scene(NPS01Pane(), companyDriver.WIDTH, companyDriver.HEIGHT);

        this.setScene(scene);
        this.setResizable(false);
        this.centerOnScreen();
        this.sizeToScene();
        this.setTitle("Please fill out the form.");

    }


    private GridPane NPS01Pane() {
    	//Creating a pane, textfields, DatePicker and a button
        GridPane NPS01Pane = new GridPane();

        //Textfields for the different information needed to create a project
        comNameInput = new TextField();
        proNameInput= new TextField();
        empNameInput = new TextField();
        estimateInput = new TextField(); 
        
        Locale.setDefault(Locale.UK);
        endDateInput = new DatePicker();
        endDateInput.setShowWeekNumbers(true);


        //Creating a label for each textfield
        Label comNamelabel = new Label("Company Name:");
        Label proNameLabel = new Label("Project Name:");
        Label empNameLabel = new Label("Name of project manager (optional):");
        Label endDateLabel= new Label("End date (dd-MM-yyyy):");
        Label estimateLabel = new Label("Estimated hours to be used on project:");

        Button conButton = new Button("Confirm");
        conButton.setOnAction(e -> confirm());
        Button backButton = new Button("Back to menu");
        backButton.setOnAction(e -> back());

        VBox NPS01Box = new VBox();
        NPS01Box.getChildren().addAll( comNamelabel,comNameInput, proNameLabel,proNameInput,endDateLabel,
                endDateInput,estimateLabel,estimateInput, empNameLabel,empNameInput);

        NPS01Box.setAlignment(Pos.CENTER);

        NPS01Pane.setVgap(20);
        NPS01Pane.add(NPS01Box, 0, 1);
        NPS01Pane.add(conButton, 2, 2);
        NPS01Pane.add(backButton, 2, 3);


        conButton.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ESCAPE) {
                Platform.exit();
            }
        });

        return NPS01Pane;
    }

    //Enters MenuStage when backButton is clicked
    private void back(){
        companyDriver.startMenuStage();
        this.close();
    }

    //Creates a new project and enters the NewProjectStage to confirm
    private void confirm(){
        if(!(comNameInput.getText().isEmpty()) && !(proNameInput.getText().isEmpty())  && !(endDateInput.getValue() == null) && !(estimateInput.getText().isEmpty()))  {

            String conName = comNameInput.getText();
            String proName = proNameInput.getText();

            
            //Parsing the DatePicker input to our own date class
            String[] endDateSplit = endDateInput.getValue().toString().split("-");
            day = Integer.parseInt(endDateSplit[0]);
            month = Integer.parseInt(endDateSplit[1]);
            year = Integer.parseInt(endDateSplit[2]);
            endDate = new Date(day, month, year);

            estimate = Double.parseDouble(estimateInput.getText());
            String  empName = empNameInput.getText();

            //Creates a new client with or without a specific project manager
            if(!(empName.isEmpty()) &&
                    CompanyDriver.SoftwareHuset.getEmployeeNames().contains(empName))  {

                this.empl = CompanyDriver.SoftwareHuset.getEmployee(empNameInput.getText());
                companyDriver.currentClient = new Client(conName, endDate, estimate, proName, empl, CompanyDriver.SoftwareHuset);
                companyDriver.currentProject = new Project(companyDriver.currentClient, CompanyDriver.SoftwareHuset);
                companyDriver.currentProjectManager = companyDriver.currentClient.projectManager;
                companyDriver.currentProject.projectManager.createActivities();

                companyDriver.startNewProjectStage02();
                this.close();

            }  else{
                companyDriver.currentClient = new Client(conName, endDate, estimate, proName, CompanyDriver.SoftwareHuset);
                companyDriver.currentProject = new Project(companyDriver.currentClient, CompanyDriver.SoftwareHuset);
                companyDriver.currentProjectManager = companyDriver.currentProject.projectManager;
            }
                companyDriver.startNewProjectStage02();
                this.close();

        } else {
            this.setTitle("Error. Please fill out the form.");

        }

    }

}
