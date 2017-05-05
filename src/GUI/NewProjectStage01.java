package GUI;

import ApplicationLayer.Client;
import ApplicationLayer.Date;
import ApplicationLayer.Employee;
import GUI.CompanyDriver;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    private CompanyDriver companyDriver;
    private TextField comNameInput;
    private TextField proNameInput;
    private TextField empNameInput;
    private TextField endDateInput;
    private TextField estimateInput;
    private Label lblMessage;
    public Employee emp;
    private int day;
    private int month;
    private int year;
    public Date endDate;
    public Client client;
    public double estimate;

    public NewProjectStage01(CompanyDriver companyDriver){
        this.companyDriver = companyDriver;

        Scene scene = new Scene(NPS01Pane(), companyDriver.WIDTH, companyDriver.HEIGHT);

        this.setScene(scene);
        this.setResizable(false);
        this.centerOnScreen();
        this.sizeToScene();
        this.setTitle("Please fill out the form.");

    }


    private GridPane NPS01Pane() {

        GridPane NPS01Pane = new GridPane();

        comNameInput = new TextField();
        proNameInput= new TextField();
        empNameInput = new TextField();
        endDateInput = new TextField();
        estimateInput = new TextField();

        Label comNamelabel = new Label("Company Name:");
        Label proNameLabel = new Label("ApplicationLayer.Project Name:");
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


        NPS01Pane.setStyle("-fx-background-color: yellow;-fx-padding: 10px;");
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

    private void back(){
        companyDriver.startMenuStage();
        this.close();
    }


    private void confirm(){
        if(!(comNameInput.getText().isEmpty()) && !(proNameInput.getText().isEmpty())  && !(endDateInput.getText().isEmpty()) && !(estimateInput.getText().isEmpty()))  {

            String conName = comNameInput.getText();
            String proName = proNameInput.getText();

            String[] endDateSplit = endDateInput.getText().split("-");
            day = Integer.parseInt(endDateSplit[0]);
            month = Integer.parseInt(endDateSplit[1]);
            year = Integer.parseInt(endDateSplit[2]);
            endDate = new Date(day, month, year);

            estimate = Double.parseDouble(estimateInput.getText());

            if(!(empNameInput.getText().isEmpty())) {
              this.emp = CompanyDriver.SoftwareHuset.getEmployee(empNameInput.getText());
                this.client = new Client(conName, endDate, estimate, proName, emp,CompanyDriver.SoftwareHuset);

                companyDriver.startNewProjectStage02();
                this.close();
            }
            else{
                this.client = new Client(conName, endDate, estimate, proName, CompanyDriver.SoftwareHuset);

                companyDriver.startNewProjectStage02();
                this.close();
            }

        } else {
            this.setTitle("Error. Please fill out the form.");

        }

    }

}