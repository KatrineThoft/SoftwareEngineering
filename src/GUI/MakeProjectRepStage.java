package GUI;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MakeProjectRepStage extends Stage {
	private CompanyDriver companyDriver;
	
	public MakeProjectRepStage(CompanyDriver companyDriver){
		this.companyDriver = companyDriver;
		
		Scene scene = new Scene(makeRepPane(), companyDriver.WIDTH, companyDriver.HEIGHT);

        this.setTitle("All activities in projects has been delegated.");
        this.setScene(scene);
        this.setResizable(false);
        this.centerOnScreen();
        this.sizeToScene();

	}
	
	
	private GridPane makeRepPane(){
		//Creating pane and label for the text
		GridPane makeRepPane = new GridPane();
		String text = companyDriver.currentProjectManager.makeProjectReport();
		Label repLabel = new Label(text);
		
		Button backButton = new Button("Back to project manager profile");
		backButton.setOnAction(e->back());
		
		VBox makeRepBox = new VBox();
		makeRepBox.getChildren().addAll(repLabel, backButton);
		
		makeRepPane.add(makeRepBox, 2, 1);
		return makeRepPane;
	}
	
	 private void back(){
	    	companyDriver.startProjectManagerStage();
	    	this.close();
	    }


}
