package GUI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

/**
 * Created by katrinethoft on 06/05/17.
 */
public class DelegateFailStage extends Stage {
    private CompanyDriver companyDriver;

    public DelegateFailStage(CompanyDriver companyDriver){
        this.companyDriver = companyDriver;


        Scene scene = new Scene(delegateFailPane(), companyDriver.WIDTH, companyDriver.HEIGHT);

        //Set the stage.
        this.setTitle("Error. Could not find enough available employees.");

        this.setScene(scene);
        this.setResizable(false);
        this.centerOnScreen();
        this.sizeToScene();


    }

    private GridPane delegateFailPane() {
        GridPane delegateFailPane = new GridPane();
        Button backButton = new Button("Back to project manager menu");
        backButton.setOnAction(e->back());

       delegateFailPane.setAlignment(Pos.CENTER);
        delegateFailPane.add(backButton, 2,1);
        return delegateFailPane;
    }

    private void back(){
        companyDriver.startProjectManagerStage();
        this.close();
    }
}
