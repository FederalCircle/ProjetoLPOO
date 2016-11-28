package br.acme.gui;

import com.sun.javafx.scene.layout.region.Margins;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainWindow extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage mainStage) throws Exception {
		VBox mainBox = new VBox();
		VBox header = new VBox();
		VBox body = new VBox();
		VBox footer = new VBox();
		
		Label hMsg = new Label("HEADER");
		Label bMsg = new Label("BODY");
		Label fMsg = new Label("FOOTER");
		
		header.getChildren().add(hMsg);
		body.getChildren().add(bMsg);
		footer.getChildren().add(fMsg);
		mainBox.getChildren().addAll(header, body, footer);
		
		mainStage.setTitle("MainWindow");
		mainStage.setScene(new Scene(mainBox, 500, 500));
		mainStage.show();
	}
}
