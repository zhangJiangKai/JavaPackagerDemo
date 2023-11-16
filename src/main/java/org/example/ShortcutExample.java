package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ShortcutExample extends Application {

    private int button1Counter = 0;
    private int button2Counter = 0;

    @Override
    public void start(Stage primaryStage) {
        Button button1 = new Button("Button1");
        Button button2 = new Button("Button2");

        button1.setOnAction(event -> button1.setText("Button1 " + (++button1Counter)));
        button2.setOnAction(event -> button2.setText("Button2 " + (++button2Counter)));

        VBox root = new VBox();
        root.getChildren().addAll(button1, button2);

        Scene scene = new Scene(root, 300, 250);

        KeyCombination kc1 = new KeyCodeCombination(KeyCode.LEFT, KeyCombination.CONTROL_DOWN);
        scene.getAccelerators().put(kc1, () -> button1.fire());

        KeyCombination kc2 = new KeyCodeCombination(KeyCode.RIGHT, KeyCombination.CONTROL_DOWN);
        scene.getAccelerators().put(kc2, () -> button2.fire());

        primaryStage.setTitle("Shortcut Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
