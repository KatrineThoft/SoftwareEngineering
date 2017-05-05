package GUI;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
/**
 * Created by katrinethoft on 05/05/17.
 */
public class ProjectManagerStage extends Stage{
    final int HEIGHT = 475;
    final int WIDTH = 500;
    private CompanyDriver companyDriver;

    public ProjectManagerStage(CompanyDriver companyDriver){
        this.companyDriver = companyDriver;

        Scene scene = new Scene(pManagerPane(), WIDTH, HEIGHT);

        //Set the stage.
        this.setTitle("What would you like to do?");

        this.setScene(scene);
        this.setResizable(false);
        this.centerOnScreen();
        this.sizeToScene();

    }

    private GridPane pManagerPane() {
        GridPane pManagerPane = new GridPane();


       Button createActButton = new Button("Create activities");
       createActButton.setOnAction(e-> createAct());

       Button setEstTimeButton = new Button("Set time use for an activity");
       setEstTimeButton.setOnAction(e-> setEstTime());

       Button createEmplButton = new Button("Assign employees to project");
       createEmplButton.setOnAction(e->createAct());

       Button delegateActButton = new Button("Delegate activities");
       delegateActButton.setOnAction(e->delegateAct());

       Button getDelegatedActButton = new Button("See delegated activities");
       getDelegatedActButton.setOnAction(e-> getDelegatedAct());

       Button findSubButton = new Button("Find substitute for abscent employee");
       findSubButton.setOnAction(e->findSub());

       Button delayProjectButton = new Button("Delay project");
       delayProjectButton.setOnAction(e->delay());

       Button endProjectButton = new Button("End project");
       endProjectButton.setOnAction(e->endProject());

        Button backButton = new Button("Go back");
        backButton.setOnAction(e -> back());

        backButton.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.ESCAPE){
                Platform.exit();
            }
        });

        return pManagerPane;
    }


    private void back(){
        companyDriver.startMenuStage();
        this.close();
    }

}
