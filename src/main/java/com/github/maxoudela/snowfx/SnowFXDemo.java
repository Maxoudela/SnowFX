/**
 * DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE Version 2, December 2004
 *
 * Copyright (C) 2004 Sam Hocevar <sam@hocevar.net>
 *
 * Everyone is permitted to copy and distribute verbatim or modified copies of
 * this license document, and changing it is allowed as long as the name is
 * changed.
 *
 * DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE TERMS AND CONDITIONS FOR COPYING,
 * DISTRIBUTION AND MODIFICATION
 *
 * 0. You just DO WHAT THE FUCK YOU WANT TO.
 */
package com.github.maxoudela.snowfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Samir Hadzic
 */
public class SnowFXDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox box = new VBox(10);
        box.setStyle("-fx-background-color : cornflowerblue;");

        for (int i = 0; i < 10; ++i) {

            Label label = new Label("This is a test label");
            TextField textField = new TextField();
            HBox hbox = new HBox(label, textField);
            box.getChildren().add(hbox);
        }
        SnowFX snowFX = new SnowFX(box);

        Button button = new Button("Make it snow!");
        button.setOnAction((ActionEvent event) -> {
            snowFX.showSnow(!snowFX.isSnowing());
        });

        box.getChildren().add(button);

        Scene scene = new Scene(snowFX);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
