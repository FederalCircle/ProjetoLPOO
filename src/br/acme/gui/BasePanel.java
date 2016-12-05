package br.acme.gui;

import java.util.ArrayList;


import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class BasePanel extends MainWindow {
	private Stage window;
	private Scene page;
	private BorderPane root;
		private HBox headerBox;
		private Node logo;
		private HBox controlButtonBox;
			private Button logoutButton;
			private Button exitButton;
		private VBox menuBox;
			private ArrayList<Button> optionsMenu;
		private VBox contentBox;
			private HBox contentNav;
			private VBox contentDisplay;
		private HBox footerBox;
			private Node credits;
			
	public Stage getWindow() {
				return window;
			}
	public void setWindow(Stage window) {
		this.window = window;
	}
	public Scene getPage() {
		return page;
	}
	public void setPage(Scene page) {
		this.page = page;
	}
	public Node getLogo() {
		return logo;
	}
	public void setLogo(Node logo) {
		this.logo = logo;
	}
	public Button getLogoutButton() {
		return logoutButton;
	}
	public void setLogoutButton(Button logoutButton) {
		this.logoutButton = logoutButton;
	}
	public Button getExitButton() {
		return exitButton;
	}
	public void setExitButton(Button exitButton) {
		this.exitButton = exitButton;
	}
	public ArrayList<Button> getOptionsMenu() {
		return optionsMenu;
	}
	public void setOptionsMenu(ArrayList<Button> optionsMenu) {
		this.optionsMenu = optionsMenu;
	}
	public HBox getContentNav() {
		return contentNav;
	}
	public void setContentNav(HBox contentNav) {
		this.contentNav = contentNav;
	}
	public VBox getContentDisplay() {
		return contentDisplay;
	}
	public void setContentDisplay(VBox contentDisplay) {
		this.contentDisplay = contentDisplay;
	}
	public Node getCredits() {
		return credits;
	}
	public void setCredits(Node credits) {
		this.credits = credits;
	}
	public BorderPane getRoot() {
		return root;
	}
	public HBox getHeaderBox() {
		return headerBox;
	}
	public HBox getControlButtonBox() {
		return controlButtonBox;
	}
	public VBox getMenuBox() {
		return menuBox;
	}
	public VBox getContentBox() {
		return contentBox;
	}
	public HBox getFooterBox() {
		return footerBox;
	}

	public BasePanel(String title){
		root = new BorderPane();
			headerBox = new HBox(10);
				logo = new Label("Projeto de LPOO");
				controlButtonBox = new HBox(10);
					logoutButton = new Button("Desconectar", getCheckIcon());
					exitButton = new Button("Fechar", getCancelIcon());
			menuBox = new VBox(10);
				optionsMenu = new ArrayList<Button>();
			contentBox = new VBox();
				contentNav = new HBox(10);
				contentDisplay = new VBox(10);
			footerBox = new HBox(10);
				credits = new Label("credits");
		
		root.setTop(headerBox);
		root.setLeft(menuBox);
		root.setCenter(contentBox);
		root.setBottom(footerBox);
			headerBox.getChildren().addAll(logo,controlButtonBox);
			headerBox.getStyleClass().add("border-box");
				logo.getStyleClass().addAll("lb-large", "bold");
				controlButtonBox.getChildren().addAll(logoutButton, exitButton);
				controlButtonBox.setAlignment(Pos.CENTER_RIGHT);
				controlButtonBox.setMinWidth(610);
					logoutButton.setOnAction(new EventHandler<ActionEvent>(){
							public void handle(ActionEvent event) {
								new LoginWindow().display();
								window.close();
							}
						});
					exitButton.setOnAction(new EventHandler<ActionEvent>(){
						public void handle(ActionEvent event) {
							window.close();
						}
					});
			menuBox.getChildren().addAll(optionsMenu);
			menuBox.getStyleClass().add("border-box");
			menuBox.setMinWidth(200);
			contentBox.getChildren().addAll(contentNav, contentDisplay);
			contentBox.getStyleClass().add("border-box");
				contentNav.getStyleClass().add("border-box-no-space");
				contentDisplay.getStyleClass().add("border-box-no-space");
				contentDisplay.prefHeightProperty().bind(contentBox.heightProperty());
			footerBox.getChildren().add(credits);
			footerBox.getStyleClass().add("border-box");
			footerBox.setAlignment(Pos.CENTER);

		page = new Scene(root, 900, 650);
		page.getStylesheets().add(getCssFile());
		window = new Stage();
		window.setScene(page);
		window.setTitle(title);
		window.setResizable(false);
	}
	
}
