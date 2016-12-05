package br.acme.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
			private Label lblMenu;
		private VBox contentBox;
			private HBox contentNav;
				private Label lblNavTitle;
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
	public Label getLblMenu() {
		return lblMenu;
	}
	public void setLblMenu(Label lblMenu) {
		this.lblMenu = lblMenu;
	}
	public Label getLblNavTitle() {
		return lblNavTitle;
	}
	public void setLblNavTitle(Label lblNavTitle) {
		this.lblNavTitle = lblNavTitle;
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
			menuBox = new VBox();
				lblMenu = new Label("Menu");
			contentBox = new VBox();
				contentNav = new HBox(10);
				lblNavTitle = new Label();
				contentDisplay = new VBox(10);
			footerBox = new HBox(10);
				credits = new Label("Grupo: Alyson Maia e Douglas Bezerra");
		
		root.setTop(headerBox);
		root.setLeft(menuBox);
		root.setCenter(contentBox);
		root.setBottom(footerBox);
			headerBox.getChildren().addAll(logo,controlButtonBox);
			headerBox.getStyleClass().add("border-box");
				logo.getStyleClass().addAll("lb-large", "bold");
				controlButtonBox.getChildren().addAll(logoutButton, exitButton);
				controlButtonBox.setAlignment(Pos.CENTER_RIGHT);
				controlButtonBox.setMinWidth(400);
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
			menuBox.getChildren().addAll(lblMenu);
			menuBox.getStyleClass().add("border-box-nopadding");
			menuBox.setMinWidth(200);
			menuBox.setAlignment(Pos.TOP_CENTER);
				lblMenu.getStyleClass().add("bold");
			contentBox.getChildren().addAll(contentNav, contentDisplay);
			contentBox.getStyleClass().add("border-box");
				contentNav.getStyleClass().addAll("border-box-no-space", "bold");
				contentNav.setAlignment(Pos.CENTER);
				contentNav.getChildren().add(lblNavTitle);
				contentDisplay.getStyleClass().add("border-box-no-space");
				contentDisplay.prefHeightProperty().bind(contentBox.heightProperty());
			footerBox.getChildren().add(credits);
			footerBox.getStyleClass().add("border-box");
			footerBox.setAlignment(Pos.CENTER);

		page = new Scene(root, 700, 500);
		page.getStylesheets().add(getCssFile());
		window = new Stage();
		window.setScene(page);
		window.setTitle(title);
		window.setResizable(false);
	}
	
}
