package br.acme.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainWindow extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage mainStage) throws Exception {
		
		// Layout containers
		VBox mainBox = new VBox();
			HBox header = new HBox();
			HBox body = new HBox();
			HBox footer = new HBox();
		
		// Elements
		Label hMsg = new Label("HEADER");
		Label bMsg = new Label("BODY");
		Label fMsg = new Label("FOOTER");
		Image imagemLogo = new Image(getClass().getResource("resources/img/logoFX.jpg").toString());
		ImageView logo = new ImageView(imagemLogo);
		
		// Hierarchy
		header.getChildren().addAll(logo, hMsg);
		body.getChildren().add(bMsg);
		footer.getChildren().add(fMsg);
		mainBox.getChildren().addAll(header, body, footer);
		
		// CSS
		mainBox.setId("wrap-all");
		header.setId("header");
		body.setId("body");
		footer.setId("footer");
		header.getStyleClass().add("contaier");
		body.getStyleClass().add("container");
		footer.getStyleClass().add("container");
		
		Scene mainScene = new Scene(mainBox, 800, 600);
		String css = this.getClass().getResource("resources/mainStyle.css").toExternalForm();
		mainStage.setResizable(false);
		mainScene.getStylesheets().add(css);
		mainStage.setTitle("MainWindow");
		mainStage.setScene(mainScene);
		mainStage.show();
	}
}
