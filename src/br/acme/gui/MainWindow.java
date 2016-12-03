package br.acme.gui;


import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.image.*;

public class MainWindow extends Application {
	/////////////// Constants ///////////////
	private final String rscPath = new String("/br/acme/gui/resources/");
	private final ImageView checkIcon = new ImageView(new Image(rscPath+"icons/check.png"));
	private final ImageView signIcon = new ImageView(new Image(rscPath+"icons/plus-sign-in-a-black-circle.png"));
	private final ImageView cancelIcon = new ImageView(new Image(rscPath+"icons/remove-button.png"));
	private final String cssFile = this.getClass().getResource("resources/mainStyle.css").toExternalForm();
	
	/////////////// Getters ///////////////
	public ImageView getCheckIcon() {
		return checkIcon;
	}
	public ImageView getSignIcon() {
		return signIcon;
	}
	public ImageView getCancelIcon() {
		return cancelIcon;
	}
	public String getCssFile() {
		return cssFile;
	}
	
	/////////////// GUI init ///////////////
	public static void main(String[] args) {
		launch(args);
	}
	public void start(Stage window){
		new LoginWindow().display();
	}
}
