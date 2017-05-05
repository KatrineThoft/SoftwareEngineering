package GUI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

/**
 * Created by katrinethoft on 05/05/17.
 */
public class CreateActivityStage extends Stage {
    private  CompanyDriver companyDriver;

    public CreateActivityStage(CompanyDriver companyDriver) {
        this.companyDriver = companyDriver;


        Scene scene = new Scene(createActPane(), companyDriver.WIDTH, companyDriver.HEIGHT);

        //Set the stage.
        this.setTitle("What would you like to do?");
        this.setScene(scene);
        this.setResizable(false);
        this.centerOnScreen();
        this.sizeToScene();

    }

    private GridPane createActPane() {
       GridPane createActPane = new GridPane();

        VBox createActBox = new VBox();

        // Mangler create activity funktion?

        Button confButton = new Button();
        createActBox.setAlignment(Pos.CENTER);

        return createActPane;
    }
}
