package ApplicationLayer; /**
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

import java.util.*;
import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane;

import javafx.scene.text.Text;


public class GUIdraft extends Application {
    //Creating the fields
    Button backButton, backButton01, dateButton, exitButton, conButton, conButton01, conButton02;
    Button cliButton, empButton, loginButton,  timeRegButton, editTimeRegButton, hourButton, actButton, nextButton, pmButton, cliEndButton,  newProjectButton,timeEstimateButton,  endDateButton,addEmplButton ;
    GridPane menuPane, clientPane01, employeePane01, addEmployeePane, employeeLoginPane, employeePane02, activityPane, regHoursPane01, regHoursPane02, pane7, pane9, pane10;
    Scene menuScene, clientScene01, employeeScene01, addEmployeeScene, employeeLoginScene, employeeScene02, activityScene, regHoursScene01, regHoursScene02, scene7, scene8, scene9, scene10;
    Stage thestage;
    String empName, newEmpName, userName, stringDate;
    private DatePicker datePicker;
    private DatePicker endDatePicker;
    public static TimeManager SoftwareHuset = new TimeManager();
    public Employee currentEmpl;


    public static void main(String[] args) {
        launch(args);
        Locale.setDefault(Locale.UK);
    }

    @Override
    public void start(Stage primaryStage) {

        //Setting the stage
        thestage = primaryStage;
       /* final Label lblMessage = new Label();







        // START MENU
        VBox menu = new VBox();

        // Creating buttons for box
        cliButton = new Button("ApplicationLayer.Client");
        empButton = new Button("ApplicationLayer.Employee");
        exitButton = new Button("Exit");

        // Assigning actions to buttons
        cliButton.setOnAction(e -> ButtonClicked(e));
        empButton.setOnAction(e -> ButtonClicked(e));
        exitButton.setOnAction(actionEvent -> Platform.exit());

        // Adding buttons to box
        menu.getChildren().addAll(cliButton, empButton, exitButton);
        menu.setAlignment(Pos.CENTER);

        // Setting scene
        menuPane = new GridPane();
        menuPane.setVgap(20);
        menuPane.setStyle("-fx-background-color: blue;-fx-padding: 10px;");
        menuPane.add(menu, 4,3);
        menuScene = new Scene(menuPane,400,375);








        // CLIENT 01
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

        // Setting the scene
        clientPane01 = new GridPane();
        clientPane01.setVgap(20);
        clientPane01.setStyle("-fx-background-color: red;-fx-padding: 10px;");
        clientPane01.add(cliBox, 8,2);
        clientScene01 = new Scene(clientPane01,400,375);







       // CLIENT 02
        //Creating a new project

        // Part 1: Creating 1st box with text fields:
        HBox cliBox2 = new HBox();

        int numTextFields = 3 ;
        String[] text = new String[6];
        text[0] = "Your company name:";
        text[1] = "ApplicationLayer.Project Name:";
        text[2] = "For specific project manager please write the employees name here:";
        final String[] info = new String[6];

        TextField[] textFields = new TextField[numTextFields];
        VBox projectForm = new VBox(5);
        for (int i = 0; i < numTextFields; i++) {
            TextField tf = new TextField();
            Label label1 = new Label(text[i]);
            projectForm .getChildren().addAll(label1, tf);
            textFields[i] = tf;
            info[i] =  tf.getText();

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
        TextField endDateText = new TextField();
        Label datelabel1 = new Label("Please choose an end date:");
        GridPane.setHalignment(datelabel1, HPos.LEFT);

        endDateButton = new Button("Next.");
        //Handler metode til endDatePicker
        endDateButton.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                if(endDateText.getText() != null) {
                    stringDate  = endDateText.getText();
                    thestage.setScene(scene9);
                    thestage.setTitle("Please fill out the form.");
                } else {
                    lblMessage.setText("Please choose a date.");
                    lblMessage.setTextFill(Color.RED);
                }

            }
        });

        System.out.println("2 " + stringDate);

        /*String[] splitDate = stringDate.split("-");
        int day = Integer.parseInt(splitDate[0]);
        int month = Integer.parseInt(splitDate[1]);
        int year = Integer.parseInt(splitDate[2]);
        ApplicationLayer.Date endDate = new ApplicationLayer.Date(day, month, year);
*/
        //Part 3:
        //EstimatedTimeUse
        timeEstimateButton = new Button("Click to confirm.");
        TextField estimateText = new TextField();
        Label label3 = new Label("Number of hours estimated for project.");
//        double estimate = Double.parseDouble(estimateText.getText());
      // timeEstimateButton.setOnAction(e->ButtonClicked(e));

    /*    timeEstimateButton.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                double estimate = Double.parseDouble(estimateText.getText());
                if(estimate > 0) {
                    thestage.setScene(scene10);
                    thestage.setTitle("Thank you. Your project has been created.");
                } else {
                    lblMessage.setText("Please enter a number.");
                    lblMessage.setTextFill(Color.RED);
                }

            }
        });

        cliBox2.getChildren().addAll(label3,estimateText ,timeEstimateButton);
        cliBox2.setAlignment(Pos.CENTER);



        //Creating a new client
       /* if(employeName != null){
            ApplicationLayer.Employee employee = ApplicationLayer.CompanyMain.SoftwareHuset.getEmployee(employeName);
            ApplicationLayer.Client client1 = new ApplicationLayer.Client(clientName, endDate, estimate, projectName, employee , ApplicationLayer.CompanyMain.SoftwareHuset);
            //SoftwareHuset.addClient(client1);
        }
        else {
            ApplicationLayer.Client client1 = new ApplicationLayer.Client(clientName, endDate, estimate, projectName, ApplicationLayer.CompanyMain.SoftwareHuset);
            ApplicationLayer.CompanyMain.SoftwareHuset.addClient(client1);


        }*/


        //Last scene for client
        cliEndButton = new Button("Back to menu.");
      //  cliEndButton.setOnAction(e->ButtonClicked(e));






        // EMPLOYEE 01 - employeeScene01
        VBox emplBox = new VBox();

        // Creating buttons for box
        loginButton = new Button("Login");
        addEmplButton = new Button("Add a new employee");

        // Assigning actions for buttons
        loginButton.setOnAction(e -> {
            thestage.setScene(employeeLoginScene);
            thestage.setTitle("Enter username");
        });
        addEmplButton.setOnAction(e -> {
            thestage.setScene(addEmployeeScene);
            thestage.setTitle("Enter name of employee");
        });

        // Adding buttons and text fields to box
        emplBox.getChildren().addAll(loginButton, addEmplButton);
        emplBox.setAlignment(Pos.CENTER);

        // Setting the scene
        employeePane01 = new GridPane();
        employeePane01.setVgap(20);
        employeePane01.setStyle("-fx-background-color: tan;-fx-padding: 10px;");
        employeePane01.add(emplBox, 8,2);
        employeeScene01 = new Scene(employeePane01, 400,375);








        // ADD EMPLOYEE - addEmployeeScene
        VBox addEmplBox = new VBox();

        // Creating buttons and textfields for box
        final TextField txtNewEmpl = new TextField();
        txtNewEmpl.setPromptText("enter name");
        txtNewEmpl.setPrefColumnCount(10);
        conButton01 = new Button("Confirm");
        backButton01 = new Button("Back");

        // Assigning actions for buttons

  /*      if ((txtNewEmpl.getText() != null && !txtNewEmpl.getText().isEmpty())) {
            newEmpName = txtNewEmpl.getText();
            if (!(CompanyMain.SoftwareHuset.getEmployees().contains(newEmpName))) {
                Employee emp = new Employee(newEmpName, CompanyMain.SoftwareHuset);
                emp.setOngoingActivities(); // for testing
                CompanyMain.SoftwareHuset.addEmployee(emp);
            }
        }

        // Handler method for adding employee
        conButton01.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                newEmpName = txtNewEmpl.getText();
                if(!(CompanyMain.SoftwareHuset.getEmployees().contains(newEmpName)) && !(newEmpName.isEmpty())) {
                    Employee emp = new Employee(newEmpName, CompanyMain.SoftwareHuset);
                    emp.setOngoingActivities(); // for testing
                    CompanyMain.SoftwareHuset.addEmployee(emp);
                    //lblMessage.setText("Employee" + newEmpName + " succesfully added");
                    //lblMessage.setTextFill(Color.GREEN);
                    thestage.setScene(employeeScene01);
                    thestage.setTitle(empName + " was succesfully added");
                } else {
                    lblMessage.setText("ApplicationLayer.Employee" + newEmpName + " already in system, try again or login.");
                    lblMessage.setTextFill(Color.RED);
                }
            }
        });

        backButton01.setOnAction(e -> {
            thestage.setScene(employeeScene01);
            thestage.setTitle("Login or create employee");
        });

        // Adding buttons and text fields to box
        addEmplBox.getChildren().addAll(txtNewEmpl, conButton01, backButton01);

        // Setting the scene
        addEmployeePane = new GridPane();
        addEmployeePane.setVgap(20);
        addEmployeePane.setStyle("-fx-background-color: yellow;-fx-padding: 10px;");
        addEmployeePane.add(addEmplBox, 8,2);
        addEmployeePane.add(lblMessage, 8,6);
        addEmployeeScene = new Scene(addEmployeePane, 400,375);









        // EMPLOYEE LOGIN
        VBox emplLoginBox = new VBox();

        // Creating buttons and textfields for box
        TextField txtUserName = new TextField();
        conButton02 = new Button("Login");

        // Assigning actions for buttons
        Text empl = new Text("nothing");
        if (!GUIdraft.SoftwareHuset.getEmployees().isEmpty())
            empl.setText(GUIdraft.SoftwareHuset.getEmployees().get(0).getName());

        //Handler method for signing in (okButton)
        conButton02.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                empName = txtUserName.getText();
                if (CompanyMain.SoftwareHuset.getEmployeeNames().contains(empName)) {
                    CompanyMain.currentEmpl = CompanyMain.SoftwareHuset.getEmployee(empName);
                    thestage.setScene(employeeScene02);
                    thestage.setTitle("Employee " + CompanyMain.currentEmpl.getName() + " logged in");
                } else {
                    lblMessage.setText("Incorrect user, try again or add new employee.");
                    lblMessage.setTextFill(Color.RED);
                }
                empName = "";
            }
        });

        // Adding buttons and text fields to box
        emplLoginBox.getChildren().addAll(empl, txtUserName, conButton02);

        // Setting the scene
        employeeLoginPane = new GridPane();
        employeeLoginPane.setVgap(20);
        employeeLoginPane.setStyle("-fx-background-color: yellow;-fx-padding: 10px;");
        employeeLoginPane.add(emplLoginBox, 8,2);
        employeeLoginPane.add(lblMessage, 8, 3);
        employeeLoginScene = new Scene(employeeLoginPane, 400,375);









        // EMPLOYEE OPTIONS
        VBox emplOpBox = new VBox();

        // Textfield for box
        Text employee = new Text("empty: " + CompanyMain.SoftwareHuset.getEmployees().isEmpty());
        if (CompanyMain.currentEmpl != null)
            employee = new Text("logged in: " + CompanyMain.currentEmpl.getName());

        // Creating buttons for box
        timeRegButton = new Button("Time registering");
        editTimeRegButton = new Button("Edit registered time");
        actButton = new Button("See your ongoing activities");
        pmButton = new Button("ApplicationLayer.Project manager profile");
        hourButton = new Button("See your registered hours");
        backButton = new Button("Go back");

        // Assigning actions for buttons
        timeRegButton.setOnAction(e -> ButtonClicked(e));
        editTimeRegButton.setOnAction(e -> ButtonClicked(e));
        actButton.setOnAction(e -> ButtonClicked(e));
        pmButton.setOnAction(e -> ButtonClicked(e));
        hourButton.setOnAction(e->ButtonClicked(e));
        backButton.setOnAction(e -> ButtonClicked(e));

        // Adding buttons to box
        emplOpBox.getChildren().addAll(employee, timeRegButton, editTimeRegButton, actButton, pmButton, hourButton, backButton);

        // Setting the scene
        employeePane02 = new GridPane();
        employeePane02.setVgap(20);
        employeePane02.setStyle("-fx-background-color: green;-fx-padding: 10px;");
        employeePane02.add(emplOpBox, 8,2);
        employeeScene02 = new Scene(employeePane02, 400,375);











        // VIEW ACTIVITIES
        VBox ViewActsBox = new VBox();

        // Creating text for box
        String txt = "no acts";
        if (CompanyMain.currentEmpl != null) {
            txt = CompanyMain.currentEmpl.getName();
            if (CompanyMain.currentEmpl.getActivities() != null) {
                txt = "";
                for (Activity a : CompanyMain.currentEmpl.getActivities()) {
                    txt += a.getActivityName() + ", remaining time: " + a.getRemainingTime() + "\n";
                }
            }
        }
        Text t = new Text();
        t.setText(txt);

        // Creating button for box
        backButton = new Button("Go back");

        // Assigning actions for buttons
        backButton.setOnAction(e -> ButtonClicked(e));

        // Adding buttons to box
        ViewActsBox.getChildren().add(backButton);

        // Setting the scene
        activityPane = new GridPane();
        activityPane.setVgap(20);
        activityPane.setStyle("-fx-background-color: pink;-fx-padding: 10px;");
        activityPane.add(ViewActsBox, 8,2);
        activityPane.add(t,4,5);
        activityScene = new Scene(activityPane, 400,375);








        // REGISTER HOURS 01
        VBox regHBox = new VBox();

        // creating buttons
        TextField dateTxt = new TextField();
        Label datelbl = new Label("Choose a date");
        dateButton = new Button("Confirm");

        // Assigning actions for buttons
        String dateStr = dateTxt.toString();
        //ApplicationLayer.Date date = new ApplicationLayer.Date(Integer.parseInt(dateStr.substring(0,1)), Integer.parseInt(dateStr.substring(2,3)), Integer.parseInt(dateStr.substring(4,7)));
        //Handler metode til datebutton
        dateButton.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                if(!(dateStr.equals(""))) {
                    thestage.setScene(regHoursScene02);
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

        // Setting the scene
        regHoursPane01 = new GridPane();
        regHoursPane01.setStyle("-fx-background-color: purple;-fx-padding: 10px;");
        regHoursPane01.add(regHBox,8,2);
        regHoursScene01 = new Scene(regHoursPane01, 400,375);










        // REGISTER HOURS 02
        VBox regHActBox = new VBox();

        // Creating textfields and buttons
        Text date = new Text();
        date.setText(dateStr + "\n");
        regHActBox.getChildren().add(date);
        int n = 3;//currentEmpl.getActivities().size() ;
        TextField[] textFields2 = new TextField[n];
        for (int i = 1; i <= n; i++) {
            TextField tf = new TextField();
            Label lbl = new Label("ApplicationLayer.Activity" + i);
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
                    if (!(textFields2[i].getText().toString().equals("")) && CompanyMain.currentEmpl != null) {
                        CompanyMain.currentEmpl.updateRegisteredHours(Integer.parseInt(textFields2[i].getText().toString()));
                    }
                }
                thestage.setScene(menuScene);
                thestage.setTitle("regH: " + CompanyMain.currentEmpl.registeredHours);
            }
        });

        // Add buttons to box
        regHActBox.getChildren().add(conButton);

        // Setting the scene
        regHoursPane02 = new GridPane();
        regHoursPane02.setVgap(20);
        regHoursPane02.setStyle("-fx-background-color: orange;-fx-padding: 10px;");
        regHoursPane02.add(regHActBox,8,2);
        regHoursScene02 = new Scene(regHoursPane02, 400,375);

/*









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

      //  Panes:
       // pane 7


/*
      // pane 7
        pane7 = new GridPane();
        pane7.setVgap(20);
        pane7.setStyle("-fx-background-color: tan;-fx-padding: 10px;");
        pane7.add(projectForm, 8,2);
        scene7 = new Scene(pane7, 400,375);

        // pane 8
       /* pane8 = new GridPane();
        pane8.setVgap(20);
        pane8.setStyle("-fx-background-color: turquoise;-fx-padding: 10px;");
        //pane8.add(endDateText, 0,0);
//        pane8.add(endDateButton, 8,2);
        scene8 = new Scene(pane8, 400,375);*/

        // pane 9
      /*  pane9 = new GridPane();
        pane9.setVgap(20);
        pane9.setStyle("-fx-background-color: mud;-fx-padding: 10px;");
        pane9.add(cliBox2, 8,2);
        scene9 = new Scene(pane9, 400, 375);

        //pane 10
        pane10 = new GridPane();
        pane10.setVgap(20);
        pane10.setStyle("-fx-background-color: grey;-fx-padding: 10px;");
        pane10.add(cliEndButton, 8,2);
        scene10 = new Scene(pane10, 400, 375 );


        // Setting start
        primaryStage.setTitle("Welcome to Softwarehuset A/S!");
        primaryStage.setScene(menuScene);
        primaryStage.show();
    }


    private void ButtonClicked(ActionEvent e) {
        if (e.getSource() == cliButton) {
            thestage.setScene(clientScene01);
            thestage.setTitle("What would you like to do?");
        } else if (e.getSource() == empButton) {
            thestage.setScene(employeeScene01);
            thestage.setTitle("Login or create employee");
        } else if (e.getSource() == addEmplButton) {
            thestage.setScene(addEmployeeScene);
            thestage.setTitle("Enter name of employee");
        } else if (e.getSource() == backButton01) {
            thestage.setScene(employeeScene01);
            thestage.setTitle("Login or create employee");
        } else if(e.getSource() == newProjectButton) {
            thestage.setScene(scene7);
            thestage.setTitle("Please fill out the form to create new project.");
        } else if (e.getSource() == timeRegButton) {
            thestage.setScene(regHoursScene01);
            thestage.setTitle("Please choose a date");
        } else if (e.getSource() == actButton) {
            thestage.setScene(activityScene);
            thestage.setTitle("Current activities");
        } else if (e.getSource() == dateButton) {
            thestage.setScene(regHoursScene02);
            thestage.setTitle("Please enter working hours.");
        } else if(e.getSource() == nextButton) {
            thestage.setScene(scene8);
            thestage.setTitle("Please fill out the form.");
        } else {
            thestage.setScene(menuScene);
            thestage.setTitle("Welcome to Softwarehuset A/S!");
        }*/

    }

}