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

import java.time.LocalDate;


import java.time.format.DateTimeFormatter;
import java.util.*;
import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane;

import javafx.scene.text.Text;


public class GUIdraft extends Application {
    //Creating the fields
    Button cliButton, empButton, backButton, backButton2, dateButton, okButton, exitButton, conButton, timeRegButton, editTimeRegButton, hourButton, actButton, nextButton,pmButton, cliEndButton,  newProjectButton,timeEstimateButton,  endDateButton,addEmplButton ;
    GridPane pane1, pane2, pane3, pane4, pane5,  pane7, pane8, pane9, pane10;
    Scene scene1, scene2, scene3, scene4, scene5, scene6, scene7, scene8, scene9, scene10, actScene;
    Stage thestage;
    String empName, newEmpName, userName;
    private DatePicker datePicker;
    private DatePicker endDatePicker;

    TimeManager SoftwareHuset = new TimeManager();
    Employee currentEmpl;

    public static void main(String[] args) {
        launch(args);
        Locale.setDefault(Locale.UK);
    }

    @Override
    public void start(Stage primaryStage) {

        //Setting the stage
        thestage = primaryStage;
        final Label lblMessage = new Label();

        // For testing purposes
        /*Employee bob = new Employee("Bob",SoftwareHuset);
        bob.setOngoingActivities();
        //SoftwareHuset.addEmployee(bob);
        // end*/


        // START MENU BOX
        VBox menu = new VBox();

        // Creating buttons for box
        cliButton = new Button("Client");
        empButton = new Button("Employee");
        exitButton = new Button("Exit");

        // Assigning actions to buttons
        cliButton.setOnAction(e -> ButtonClicked(e));
        empButton.setOnAction(e -> ButtonClicked(e));
        exitButton.setOnAction(actionEvent -> Platform.exit());

        // Adding buttons to box
        menu.getChildren().addAll(cliButton, empButton, exitButton);
        menu.setAlignment(Pos.CENTER);

        // CLIENT BOX
        VBox cliBox = new VBox();

        // Creating buttons for box
        backButton = new Button("Go back");
        newProjectButton = new Button("Create new project");

        // Assigning actions to buttons
        backButton.setOnAction(e -> ButtonClicked(e));
        newProjectButton.setOnAction(e->ButtonClicked(e));

        // Adding buttons to box
        cliBox.getChildren().addAll(newProjectButton , backButton);
        cliBox.setAlignment(Pos.CENTER);

        // CREATE CLIENT BOX
        //Creating a new project

        // Part 1: Creating 1st box with text fields:
        HBox cliBox2 = new HBox();
        int numTextFields = 3 ;
        String[] text = new String[6];
        text[0] = "Your company name:";
        // text[2] = "Number of hours to be used (numbers only):";
        text[1] = "Project Name:";
        text[2] = "For specific project manager please write the employees name here:";
        final String[] info = new String[6];

        TextField[] textFields = new TextField[numTextFields];
        VBox projectForm = new VBox(5);
        for (int i = 0; i < numTextFields; i++) {
            TextField tf = new TextField();
            Label label1 = new Label(text[i]);
            projectForm .getChildren().addAll(label1, tf);
            textFields[i] = tf;
            info[i] =  textFields[i].toString();

        }

        String clientName = info[0];
        String projectName = info[1];
        String employeName = info[2];

        // Adding button to box
        nextButton = new Button("Next");

        //Assigning Handlermethod to button:
        nextButton.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                if(!(info[0].isEmpty()) && !(info[1].isEmpty()))  {
                    thestage.setScene(scene8);
                    thestage.setTitle("Please choose a date.");
                } else {
                    lblMessage.setText("Please fill out the form.");
                    lblMessage.setTextFill(Color.RED);
                }

            }
        });

        // Adding button to box
        projectForm.getChildren().add(nextButton);

        //Part 2:
        //Choosing the end date
        endDatePicker = new DatePicker();
        Label datelabel1 = new Label("Please choose an end date:");
        endDatePicker.setShowWeekNumbers(true);
        GridPane.setHalignment(datelabel1, HPos.LEFT);

        endDateButton = new Button("Next.");
        //Handler metode til endDatePicker
        endDateButton.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                if(endDatePicker.getValue() != null) {
                    thestage.setScene(scene9);
                    thestage.setTitle("Please fill out the form.");
                } else {
                    lblMessage.setText("Please choose a date.");
                    lblMessage.setTextFill(Color.RED);
                }

            }
        });
/*        String stringDate  = endDatePicker.getValue().toString();
        int day = Integer.parseInt(stringDate.substring(0,2));
        int month = Integer.parseInt(stringDate.substring(2,4));
        int year =  Integer.parseInt(stringDate.substring(4,6));

        Date endDate = new Date(day, month, year);
*/
        //Part 3:
        //EstimatedTimeUse
        timeEstimateButton = new Button("Click to confirm.");
        TextField estimateText = new TextField();
        Label label3 = new Label("Number of hours estimated for project.");
//        double estimate = Double.parseDouble(estimateText.getText());
        timeEstimateButton.setOnAction(e->ButtonClicked(e));
/*
        timeEstimateButton.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                if(estimate > 0) {
                    thestage.setScene(scene10);
                    thestage.setTitle("Thank you. Your project has been created.");
                } else {
                    lblMessage.setText("Please enter a number.");
                    lblMessage.setTextFill(Color.RED);
                }

            }
        });
*/
        cliBox2.getChildren().addAll(label3,estimateText ,timeEstimateButton);
        cliBox2.setAlignment(Pos.CENTER);



/*        //Creating a new client
        if(employeName != null){
            Employee employee = SoftwareHuset.getEmployee(employeName);
            Client client1 = new Client(clientName, endDate, estimate, projectName, employee , SoftwareHuset);
            //SoftwareHuset.addClient(client1);
        }
        else {
            Client client1 = new Client(clientName, endDate, estimate, projectName, SoftwareHuset);
            SoftwareHuset.addClient(client1);


        }
*/


        //Last scene for client
        cliEndButton = new Button("Back to menu.");
        cliEndButton.setOnAction(e->ButtonClicked(e));


        /*conButton.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                if(){

                }

            }
        });*/

        // EMPLOYEE BOX
        VBox emplBox = new VBox();

        // Creating buttons and textfield for box
        final TextField txtUserName = new TextField();
        okButton = new Button("Login");
        final TextField txtNewEmpl = new TextField();
        final Label lblMessage2 = new Label();
        addEmplButton = new Button("Add a new employee");

        // Assigning actions for buttons
        //Handler method for signing in (okButton)
        okButton.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                empName = txtUserName.getText().toString();
                if (SoftwareHuset.getEmployeeNames().contains(empName)) {
                    currentEmpl = SoftwareHuset.getEmployee(empName);
                    thestage.setScene(scene4);
                    thestage.setTitle("Employee " + currentEmpl.getName() + " logged in");
                } else {
                    lblMessage.setText("Incorrect user, try again or add new employee.");
                    lblMessage.setTextFill(Color.RED);
                }
                empName = "";
            }
        });

        // Handler method for adding employee (addEmplButton)
        addEmplButton.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                newEmpName = txtNewEmpl.getText().toString();
                if(!(SoftwareHuset.getEmployees().contains(newEmpName)) && !(newEmpName.isEmpty())) {
                    Employee emp = new Employee(newEmpName, SoftwareHuset);
                    emp.setOngoingActivities(); // for testing
                    SoftwareHuset.addEmployee(emp);
                    lblMessage2.setText("Employee " + newEmpName + " added to SoftwareHuset.");
                    lblMessage2.setTextFill(Color.GREEN);
                } else {
                    lblMessage2.setText("Employee" + newEmpName + " already in system, try again or login.");
                    lblMessage2.setTextFill(Color.RED);
                }
                newEmpName="";
            }
        });

        // Adding buttons and text fields to box
        emplBox.getChildren().addAll(txtUserName, okButton, txtNewEmpl, addEmplButton);


        // EMPLOYEE OPTIONS BOX
        VBox empOpBox = new VBox();

        // Creating buttons for box
        timeRegButton = new Button("Time registering");
        editTimeRegButton = new Button("Edit registered time");
        actButton = new Button("See your ongoing activities");
        pmButton = new Button("Project manager profile");
        hourButton = new Button("See your registered hours");
        backButton2 = new Button("Go back");

        // Assigning actions for buttons
        timeRegButton.setOnAction(e -> ButtonClicked(e));
        editTimeRegButton.setOnAction(e -> ButtonClicked(e));
        actButton.setOnAction(e -> ButtonClicked(e));
        pmButton.setOnAction(e -> ButtonClicked(e));
        hourButton.setOnAction(e->ButtonClicked(e));
        backButton2.setOnAction(e -> ButtonClicked(e));

        // Adding buttons to box
        empOpBox.getChildren().addAll(timeRegButton, editTimeRegButton, actButton, pmButton, hourButton, backButton2);

        // VIEW ACTIVITIES BOX
        VBox ViewActsBox = new VBox();

        // Creating buttons an text for box
        String txt = "no acts";
        if (currentEmpl != null) {
            txt = currentEmpl.getName();
            if (currentEmpl.getActivities() != null) {
                txt = "";
                for (Activity a : currentEmpl.getActivities()) {
                    txt += a.getActivityName() + ", remaining time: " + a.getRemainingTime() + "\n";
                }
            }
        }
        Text t = new Text();
        t.setText(txt);
        backButton2 = new Button("Go back");

        // Assigning actions for buttons
        backButton2.setOnAction(e -> ButtonClicked(e));

        // Adding buttons to box
        ViewActsBox.getChildren().add(backButton2);

        // REGISTER HOURS BOX
        VBox regHBox = new VBox();

        // creating buttons
        TextField dateTxt = new TextField();
        Label datelbl = new Label("Choose a date");
        dateButton = new Button("Confirm");

        // Assigning actions for buttons
        String dateStr = dateTxt.toString();
        //Date date = new Date(Integer.parseInt(dateStr.substring(0,1)), Integer.parseInt(dateStr.substring(2,3)), Integer.parseInt(dateStr.substring(4,7)));
        //Handler metode til datebutton
        dateButton.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                if(!(dateStr.equals(""))) {
                    thestage.setScene(scene6);
                    thestage.setTitle("Please enter the hours worked on each activity.");
                } else {
                    lblMessage.setText("Please choose a date.");
                    lblMessage.setTextFill(Color.BLUE);
                }

            }
        });

        // Adding buttons to box
        regHBox.getChildren().addAll(datelbl, dateTxt);
        regHBox.getChildren().add(dateButton);

        // REGISTERING HOURS ON EACH ACTIVITY BOX
        VBox regHActBox = new VBox();

        // Creating textfields and buttons
        Text date = new Text();
        date.setText(dateStr + "\n");
        regHActBox.getChildren().add(date);
        int n = 3;//currentEmpl.getActivities().size() ;
        TextField[] textFields2 = new TextField[n];
        for (int i = 1; i <= numTextFields; i++) {
            TextField tf = new TextField();
            Label lbl = new Label("Activity" + i);
            //Label lbl = new Label(currentEmpl.getActivities().get(i-1).getActivityName());
            regHActBox.getChildren().addAll(lbl, tf);
            textFields2[i-1] = tf ;
        }
        conButton = new Button("Confirm");

        // Assigning actions for buttons
        conButton.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                for (int i = 0; i < textFields2.length; i++) {
                    if (!(textFields2[i].getText().toString().equals("")) && currentEmpl != null) {
                        currentEmpl.updateRegisteredHours(Integer.parseInt(textFields2[i].getText().toString()));
                    }
                }
                thestage.setScene(scene1);
                thestage.setTitle("regH: " + currentEmpl.registeredHours);
            }
        });

        // Add buttons to box
        regHActBox.getChildren().add(conButton);



        /*TextField workingHours = new TextField();
        //Handler metode til datepicker
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

        // Menu scene
        pane1 = new GridPane();
        pane1.setStyle("-fx-background-color: blue;-fx-padding: 10px;");
        pane1.add(menu, 4,3);
        scene1 = new Scene(pane1,400,375);

        // Client scene
        pane2 = new GridPane();
        pane2.setStyle("-fx-background-color: red;-fx-padding: 10px;");
        pane2.add(cliBox, 8,2);
        scene2 = new Scene(pane2,400,375);

        // Employee scene (login or add)
        pane3 = new GridPane();
        pane3.setStyle("-fx-background-color: yellow;-fx-padding: 10px;");
        pane3.add(emplBox, 8,2);
        pane3.add(lblMessage, 5, 3);
        pane3.add(lblMessage2, 5,4);
        scene3 = new Scene(pane3, 400,375);

        // Employee Options scene
        pane4 = new GridPane();
        pane4.setStyle("-fx-background-color: green;-fx-padding: 10px;");
        pane4.add(empOpBox, 8,2);
        scene4 = new Scene(pane4, 400,375);

        // View activities scene
        GridPane actP = new GridPane();
        actP.setStyle("-fx-background-color: pink;-fx-padding: 10px;");
        actP.add(ViewActsBox, 8,2);
        actP.add(t,4,5);
        actScene = new Scene(actP, 400,375);

        // Reg Hours scene
        pane5 = new GridPane();
        pane5.setStyle("-fx-background-color: purple;-fx-padding: 10px;");
        pane5.add(regHBox,8,2);
        scene5 = new Scene(pane5, 400,375);

        // pane 6
        GridPane pane6 = new GridPane();
        pane6.setStyle("-fx-background-color: orange;-fx-padding: 10px;");
        pane6.add(regHActBox,8,2);
        scene6 = new Scene(pane6, 400,375);

        // pane 7
        pane7 = new GridPane();
        pane7.setStyle("-fx-background-color: tan;-fx-padding: 10px;");
        pane7.add(projectForm, 8,2);
        scene7 = new Scene(pane7, 400,375);

        // pane 8
        pane8 = new GridPane();
        pane8.setStyle("-fx-background-color: turquoise;-fx-padding: 10px;");
        pane8.add(endDatePicker, 0,0);
        pane8.add(endDateButton, 8,2);
        scene8 = new Scene(pane8, 400,375);

        // pane 9
        pane9 = new GridPane();
        pane9.setStyle("-fx-background-color: mud;-fx-padding: 10px;");
        pane9.add(cliBox2, 8,2);
        scene9 = new Scene(pane9, 400, 375);

        //pane 10
        pane10 = new GridPane();
        pane10.setStyle("-fx-background-color: grey;-fx-padding: 10px;");
        pane10.add(cliEndButton, 8,2);
        scene10 = new Scene(pane10, 400, 375 );


        pane1.setVgap(20);
        pane2.setVgap(20);
        pane3.setVgap(20);
        pane4.setVgap(20);
        pane5.setVgap(20);
        pane7.setVgap(20);
        pane8.setVgap(20);
        pane9.setVgap(20);
//        pane10.setVgap(20);

        // Setting start
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
            thestage.setTitle("Login or create employee");
        } else if (e.getSource() == timeRegButton) {
            thestage.setScene(scene5);
            thestage.setTitle("Please choose a date");
        } else if (e.getSource() == actButton) {
            thestage.setScene(actScene);
            thestage.setTitle("Current activities");
        } else if (e.getSource() == dateButton) {
            thestage.setScene(scene6);
            thestage.setTitle("Please enter working hours.");
        } else if(e.getSource() == nextButton) {
            thestage.setScene(scene8);
            thestage.setTitle("Please fill out the form.");
        } else {
            thestage.setScene(scene1);
            thestage.setTitle("Welcome to Softwarehuset A/S!");
        }
    }
}