package fr.andrew.additioneurjavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();


        VBox vBox = new VBox();


        Label label = new Label();
        vBox.getChildren().add(label);

        TextArea textArea = new TextArea();
        vBox.getChildren().add(textArea);
        textArea.setPrefRowCount(10);
        textArea.setWrapText(true);
        textArea.setEditable(false);

        HBox hBox1 = new HBox();
        vBox.getChildren().add(hBox1);

        VBox vBox1 = new VBox();
        hBox1.getChildren().add(vBox1);
        VBox vBox2 = new VBox();
        hBox1.getChildren().add(vBox2);
        VBox vBox3 = new VBox();
        hBox1.getChildren().add(vBox3);
        VBox vBox4 = new VBox();
        hBox1.getChildren().add(vBox4);
        VBox vBox5 = new VBox();
        hBox1.getChildren().add(vBox5);

        HBox hBox2 = new HBox();
        vBox.getChildren().add(hBox2);

        Button button0 = new Button("0");
        Button button1 = new Button("1");
        Button button2 = new Button("2");
        Button button3 = new Button("3");
        Button button4 = new Button("4");
        Button button5 = new Button("5");
        Button button6 = new Button("6");
        Button button7 = new Button("7");
        Button button8 = new Button("8");
        Button button9 = new Button("9");
        button0.setOnAction(actionEvent -> textArea.appendText("0+"));
        button1.setOnAction(actionEvent -> textArea.appendText("1+"));
        button2.setOnAction(actionEvent -> textArea.appendText("2+"));
        button3.setOnAction(actionEvent -> textArea.appendText("3+"));
        button4.setOnAction(actionEvent -> textArea.appendText("4+"));
        button5.setOnAction(actionEvent -> textArea.appendText("5+"));
        button6.setOnAction(actionEvent -> textArea.appendText("6+"));
        button7.setOnAction(actionEvent -> textArea.appendText("7+"));
        button8.setOnAction(actionEvent -> textArea.appendText("8+"));
        button9.setOnAction(actionEvent -> textArea.appendText("9+"));


        Button buttonCalculer = new Button("Calculer");
        buttonCalculer.setOnAction(actionEvent -> {
            String text = textArea.getText();
            if (text == null) {
                label.setText("Please enter some numbers");
                return;
            }
//            text.replace('=', '+');
            String[] elements = text.split("\\+");
            int somme  = 0;

            for (String part : elements) {
                String trimmed = part.trim();
                if (!trimmed.isEmpty()) {
                    try {
                        somme += Integer.parseInt(trimmed);
                    } catch (NumberFormatException e) {
                        continue;
                    }
                }
            }
            textArea.appendText("="+somme + "+");

        });
        Button buttonValider = new Button("Valider");


        buttonValider.setOnAction(actionEvent -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Supprimer Calculations ?");
            alert.setHeaderText("You are trying to delete all your calculations!");
            alert.setContentText("Do you want to delete all your calculations?");

                if (alert.showAndWait().get() == ButtonType.OK) {
                    textArea.setText("");
                }
            
        });

        vBox1.getChildren().addAll(button0, button1);
        vBox2.getChildren().addAll(button2, button3);
        vBox3.getChildren().addAll(button4, button5);
        vBox4.getChildren().addAll(button6, button7);
        vBox5.getChildren().addAll(button8, button9);

        hBox2.getChildren().addAll(buttonValider, buttonCalculer);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(vBox);
        BorderPane.setMargin(vBox, new Insets(10));

        VBox.setMargin(label, new Insets(5));
        VBox.setMargin(textArea, new Insets(5));
        VBox.setMargin(hBox1, new Insets(5));
        VBox.setMargin(hBox2, new Insets(5));

        HBox.setMargin(vBox1, new Insets(5));
        HBox.setMargin(vBox2, new Insets(5));
        HBox.setMargin(vBox3, new Insets(5));
        HBox.setMargin(vBox4, new Insets(5));
        HBox.setMargin(vBox5, new Insets(5));

        hBox1.setAlignment(Pos.CENTER);
        hBox2.setAlignment(Pos.CENTER);

        hBox1.setSpacing(3);
        hBox2.setSpacing(24);

        vBox1.setSpacing(5);
        vBox2.setSpacing(5);
        vBox3.setSpacing(5);
        vBox4.setSpacing(5);
        vBox5.setSpacing(5);


        Scene scene = new Scene(borderPane);
        stage.setTitle("Additioneur");
        stage.setScene(scene);
        stage.show();



    }

    public static void main(String[] args) {
        launch();
    }
}