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
	Stage window;
	Scene page;
	BorderPane root;
		HBox headerBox;
			Node logo;
			Pane gap = new Pane();
			HBox controlButtonBox;
				Button logoutButton;
				Button exitButton;
		VBox menuBox;
			ArrayList<TitledPane> optionsMenu;
		VBox contentBox;
			HBox contentNav;
			VBox contentDisplay;
		HBox footerBox;
			Node credits;
	public BasePanel(){
		root = new BorderPane();
			headerBox = new HBox(10);
				logo = new Label("Projeto de LPOO");
				controlButtonBox = new HBox(10);
					logoutButton = new Button("Desconectar", getCheckIcon());
					exitButton = new Button("Sair", getCancelIcon());
			menuBox = new VBox(10);
				optionsMenu = new ArrayList<TitledPane>();
			contentBox = new VBox(10);
				contentNav = new HBox(10);
				contentDisplay = new VBox(10);
			footerBox = new HBox(10);
				credits = new Label("credits");
		
		root.setTop(headerBox);
		root.setLeft(menuBox);
		root.setCenter(contentBox);
		root.setBottom(footerBox);
		//BorderPane.setMargin(headerBox, new Insets(5, 5, 0, 5));
			headerBox.getChildren().addAll(logo,controlButtonBox);
			headerBox.getStyleClass().add("border-box");
				logo.getStyleClass().addAll("lb-large", "bold");
				controlButtonBox.getChildren().addAll(logoutButton, exitButton);
				controlButtonBox.setAlignment(Pos.CENTER_RIGHT);
				controlButtonBox.setMinWidth(610);
					logoutButton.setOnAction(new EventHandler<ActionEvent>(){
							public void handle(ActionEvent event) {
								
							}
						});
					exitButton.setOnAction(new EventHandler<ActionEvent>(){
						public void handle(ActionEvent event) {
							
						}
					});
			menuBox.getChildren().addAll(optionsMenu);
			contentBox.getChildren().addAll(contentNav, contentDisplay);
			footerBox.getChildren().add(credits);
			footerBox.setAlignment(Pos.CENTER);

		page = new Scene(root, 900, 650);
		page.getStylesheets().add(getCssFile());
		window = new Stage();
		window.setScene(page);
		window.setResizable(false);
	}
}
