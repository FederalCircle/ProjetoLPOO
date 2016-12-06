package br.acme.gui;


import java.util.Date;

import br.acme.exception.UsersExceptions;
import br.acme.users.Solicitante;
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
	
	/////////////// Defaults ///////////////
	public MainWindow(){
		checkIcon.setFitHeight(20);
		checkIcon.setFitWidth(20);
		signIcon.setFitHeight(20);
		signIcon.setFitWidth(20);
		cancelIcon.setFitHeight(20);
		cancelIcon.setFitWidth(20);
	}
	
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
		//new LoginWindow().display();
		/**/
		try {
			new SolicitantePanel().display(new Solicitante("407.087.551-43", "paula@travel.com", "paula123", "Paula", "Feminino", new Date(), "99112233"));
		} catch (UsersExceptions e) {
			e.printStackTrace();
		}
		/**/
	}
}
