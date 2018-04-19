/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamgenerator;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Quintess
 */
public class TeamGenerator extends Application {

    @Override
    public void start(Stage primaryStage) {
        Text text = new Text("Please enter how many people should be in the team.");
        TextField tf = new TextField();

        tf.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                tf.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        Text result = new Text();

        Button enter = new Button();
        enter.setText("Enter");
        enter.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                int input = Integer.parseInt(tf.getText());
                if (input % 2 == 0 && input <= 12 && input >= 2) {
                    String teamString = getTeam(input);
                    result.setText(teamString);
                    tf.clear();
                    text.setText("Another?");
                }
                else {
                    text.setText("Try again with a valid number of people bruh");
                    tf.clear();
                }
            }
        });

        StackPane root = new StackPane();
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(20, 10, 10, 10));
        vBox.getChildren().add(text);
        vBox.getChildren().add(tf);
        vBox.getChildren().add(enter);
        vBox.getChildren().add(result);
        
        root.getChildren().add(vBox);

        Scene scene = new Scene(root, 600, 600);

        primaryStage.setTitle("Team generator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public String getTeam(int i) {
        Team t = new Team();
        Person[] cs = t.generateRandomTeam(i);
        String teamString = "";
        for (Person c : cs) {
            teamString = teamString + c + "\n";
        }
        return teamString;
    }

}
