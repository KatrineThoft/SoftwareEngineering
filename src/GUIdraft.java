/**
 * Created by katrinethoft on 24/04/17.
 */
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.*;
import javafx.event.Event;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.sql.Array;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane;
import javafx.util.converter.NumberStringConverter;


import java.awt.*;

public class GUIdraft extends Application {
    //Creating the fields
    Button cliButton, empButton, backButton, backButton2, dateButton, okButton, exitButton, conButton, timeRegButton, editTimeRegButton, hourButton, actButton, pmButton, newProjectButton, addEmployee ;
    GridPane pane1, pane2, pane3, pane4, pane5,  pane7, pane8, pane9;
    Scene scene1, scene2, scene3, scene4, scene5, scene6, scene7, scene8, scene9;
    Stage thestage;
    String empName, userName;
    private DatePicker datePicker;

    public static void main(String[] args) {
        launch(args);
        Locale.setDefault(Locale.UK);

    }

    @Override
    public void start(Stage primaryStage) throws ParseException {
        //Setting the stage
        thestage = primaryStage;
        TimeManager SoftwareHuset = new TimeManager();



        //Creating the menu scene
        VBox menu = new VBox();

        cliButton = new Button("Client");
        empButton = new Button("Employee");

        cliButton.setOnAction(e -> ButtonClicked(e));
        empButton.setOnAction(e -> ButtonClicked(e));


        exitButton = new Button("Exit");
        exitButton.setOnAction(actionEvent -> Platform.exit());

        menu.getChildren().addAll(cliButton, empButton, exitButton);
        menu.setAlignment(Pos.CENTER);

        //Client scenes
        VBox cliBox = new VBox();
        backButton = new Button("Go back");
        backButton.setOnAction(e -> ButtonClicked(e));
        newProjectButton = new Button("Create new project");
        newProjectButton.setOnAction(e->ButtonClicked(e));

        cliBox.getChildren().addAll(newProjectButton , backButton);
        cliBox.setAlignment(Pos.CENTER);

        //Creating a new project
        int numTextFields = 5 ;
        String[] text = new String[6];
       text[0] = "Your company name:";
       text[1] = "End date (numbers only, ddMMyyyy):";
       text[2] = "Number of hours to be used (numbers only):";
       text[3] = "Project Name:";
       text[4] = "Firm to solve the project:";
       text[5] = "For specific project manager please write the employees name here:";
       String[] info = new String[6];

        TextField[] textFields = new TextField[numTextFields];
        VBox projectForm = new VBox(5);
        for (int i = 0; i < numTextFields; i++) {
            TextField tf = new TextField();
            Label label1 = new Label(text[i]);
            projectForm .getChildren().addAll(label1, tf);
            textFields[i] = tf;
            info[i] = tf.getText();
        }

        String clientName = info[0];
        String projectName = info[3];
        String firm = info[4];
        DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
        java.util.Date date = format.parse(info[1]);
        int hours = Integer.parseInt(info[2]);
        





        conButton = new Button("Confirm");
        projectForm.getChildren().add(conButton);



        /*conButton.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                if(){

                }

            }
        });*/


        //Creating the sign in form
        Label lblUserName = new Label("Username");
        final TextField txtUserName = new TextField();
        okButton = new Button("Login");
        final Label lblMessage = new Label();
        addEmployee = new Button("Add a new employee");

        //Handler method for sign in form
        okButton.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                empName =txtUserName.getText().toString();
                if(SoftwareHuset.getEmployees().contains(empName)) {
                    lblMessage.setTextFill(Color.GREEN);
                    thestage.setScene(scene4);
                    thestage.setTitle("What would you like to do?");
                } else {
                    lblMessage.setText("Incorrect user, try again or add new employee.");
                    lblMessage.setTextFill(Color.RED);
                }
                empName="";
            }
        });

        VBox empOpBox = new VBox();
        timeRegButton = new Button("Time registering");
        editTimeRegButton = new Button("Edit registered time");
        actButton = new Button("See your ongoing activities");
        pmButton = new Button("Project manager profile");
        hourButton = new Button("See your registered hours");



        timeRegButton.setOnAction(e -> ButtonClicked(e));
        editTimeRegButton.setOnAction(e -> ButtonClicked(e));
        actButton.setOnAction(e -> ButtonClicked(e));
        pmButton.setOnAction(e -> ButtonClicked(e));
        hourButton.setOnAction(e->ButtonClicked(e));


        empOpBox.getChildren().addAll(timeRegButton, editTimeRegButton, actButton, pmButton, hourButton);


        backButton2 = new Button("Go back");
        backButton2.setOnAction(e -> ButtonClicked(e));
        HBox empBox = new HBox(backButton2);

        empBox.setAlignment(Pos.CENTER);


        dateButton = new Button("Confirm");



        //Creating a datepicker
        datePicker = new DatePicker();
        Label dateLabel = new Label("Please choose a date:");
        datePicker.setShowWeekNumbers(true);
        GridPane.setHalignment(dateLabel, HPos.LEFT);
        //Handler metode til datepicker
        dateButton.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                if(datePicker.getValue()!=null) {
                    thestage.setScene(scene6);
                    thestage.setTitle("Please enter the hours worked on each activity.");
                } else {
                    lblMessage.setText("Please enter a number.");
                    lblMessage.setTextFill(Color.RED);
                }

            }
        });

        //New textfield for the working hours


        //  Adding textfield for each activity (fixed to 10)
        VBox pane6 = new VBox();

     /*   int numTextFields =  ;
        TextField[] textFields = new TextField[numTextFields];
        VBox root = new VBox(5);
        for (int i = 1; i <= numTextFields; i++) {
            TextField tf = new TextField();
            Label label1 = new Label("Activity" + i);
            root.getChildren().add(label1, tf);
            textFields[i-1] = tf ;
        }
*/

    /* //Handler metode til datepicker
        conButton.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                workingHours.setTextFormatter(new TextFormatter<>(new NumberStringConverter()));
                if(workingHours!=null) {
                    thestage.setScene(scene7);
                    thestage.setTitle("Your hours have been registered.");
                } else {
                lblMessage.setText("Please enter a number.");
                lblMessage.setTextFill(Color.RED);
            }

            }
        }); */

        //making the panes
        pane1 = new GridPane();
        pane2 = new GridPane();
        pane3 = new GridPane();
        pane4 = new GridPane();
        pane5 = new GridPane();
        //pane6 = new GridPane();
        pane7 = new GridPane();
        pane8 = new GridPane();
        pane9 = new GridPane();
        pane1.setVgap(20);
        pane2.setVgap(20);
        pane3.setVgap(20);
        pane4.setVgap(20);
        pane5.setVgap(20);
        pane7.setVgap(20);
        pane8.setVgap(20);
        pane9.setVgap(20);


        //set background color of each Pane
        pane1.setStyle("-fx-background-color: blue;-fx-padding: 10px;");
        pane2.setStyle("-fx-background-color: red;-fx-padding: 10px;");
        pane3.setStyle("-fx-background-color: yellow;-fx-padding: 10px;");
        pane4.setStyle("-fx-background-color: green;-fx-padding: 10px;");
        pane5.setStyle("-fx-background-color: purple;-fx-padding: 10px;");
        pane6.setStyle("-fx-background-color: orange;-fx-padding: 10px;");
        pane7.setStyle("-fx-background-color: tan;-fx-padding: 10px;");
        pane8.setStyle("-fx-background-color: turquoise;-fx-padding: 10px;");
       // pane9.setStyle("-fx-background-color: magenta;-fx-padding: 10px;");





        //add everything to panes
        pane1.add(menu, 4, 1);
        pane2.add(cliBox, 4, 1);
        pane3.add(empBox, 4, 1);
        pane3.add(lblUserName, 0, 0);
        pane3.add(txtUserName, 1, 0);
        pane3.add(okButton, 2, 1);
        pane3.add(lblMessage, 1, 2);
        pane4.add(empOpBox, 4,1);
        pane5.add(dateLabel, 0, 0);
        pane5.add(datePicker, 0,1);
        pane5.add(dateButton, 4, 1);
        pane7.add(projectForm, 4,1);
        pane8.add(backButton2, 4,1);

        scene1 = new Scene(pane1, 300, 275);
        scene2 = new Scene(pane2, 300, 275);
        scene3 = new Scene(pane3, 300, 275);
        scene4 = new Scene(pane4, 300, 275);
        scene5 = new Scene(pane5, 300,275);
        scene6 = new Scene(pane6, 300,275);
        scene7 = new Scene(pane7, 300,275);
        scene8 = new Scene(pane8, 300,275);
       // scene9 = new Scene(pane9, 300,275);

        primaryStage.setTitle("Welcome to Softwarehuset A/S!");
        primaryStage.setScene(scene1);
        primaryStage.show();

    }


    private void ButtonClicked(ActionEvent e) {
        if (e.getSource() == cliButton) {
            thestage.setScene(scene2);
            thestage.setTitle("What would you like to do?");
        } else if(e.getSource() == newProjectButton) {
            thestage.setScene(scene7);
            thestage.setTitle("Please fill out the form to create new project.");
        } else if (e.getSource() == empButton) {
            thestage.setScene(scene3);
            thestage.setTitle("Please enter you name:");
        } else if (e.getSource() == timeRegButton) {
            thestage.setScene(scene5);
            thestage.setTitle("Please choose a date");
        } else if (e.getSource() == dateButton){
            thestage.setScene(scene6);
            thestage.setTitle("Please enter working hours.");
        }  else {
            thestage.setScene(scene1);
            thestage.setTitle("Welcome to Softwarehuset A/S!");
        }


    }
}