package GUI;

import ApplicationLayer.Activity;
import ApplicationLayer.Employee;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by katrinethoft on 05/05/17.
 */

//Stage for registering time for today's date.
public class TimeRegStage extends Stage {
    private CompanyDriver companyDriver;
    private TextField[] regHours;
    private double totalHours;

    public TimeRegStage(CompanyDriver companyDriver){
    	//Setting the scene
    	Scene scene = new Scene(timeRegPane(companyDriver.getCurrentEmpl()), companyDriver.WIDTH, companyDriver.HEIGHT);
        this.companyDriver = companyDriver;
        
        this.setScene(scene);
        this.setResizable(false);
        this.centerOnScreen();
        this.sizeToScene();
        this.setTitle("Please enter the number of hours worked on each activity (max 8 hours)");

    }

    private GridPane timeRegPane(Employee currentEmployee) {
    	//Creating pane, textfield and button for scene
        GridPane timeRegPane = new GridPane();

        VBox timeRegBox = new VBox();
        double hours = 0; 

        //Registering time for each activity using textfields
        System.out.println(currentEmployee.getActivities().size());
        regHours = new TextField[currentEmployee.getActivities().size()];
        
        timeRegBox.getChildren().addAll(regHours);
       
        
       /* for(int i =0; i < currentEmployee.getActivities().size(); i++ ){
            if(!(regHours[i].getText().isEmpty())) {
                hours = Double.parseDouble(regHours[i].getText());
            }
            currentEmployee.regHoursOnAct(hours,currentEmployee.getActivities().get(i));
            this.totalHours += hours;
        }
        
        timeRegBox.getChildren().addAll(regHours);*/
    
        

        Button confButton = new Button("Confirm and back to employee menu");
        confButton.setOnAction(e->confirm());

        timeRegBox.getChildren().add(confButton);

        timeRegPane.add(timeRegBox,2,1);
        timeRegPane.setAlignment(Pos.CENTER);

        return  timeRegPane;
    }

    //Enters EmpOptStage if hours entered in total is less than or equal the permitted 8 hours
    private void confirm(){
        if(totalHours > 8.0){
            this.setTitle("You cannot work more than 8.00 hours pr. day.");

        }else{
            companyDriver.startEmpOptStage();
            this.close();
        }
    }


}
