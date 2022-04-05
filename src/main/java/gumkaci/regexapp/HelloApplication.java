package gumkaci.regexapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelloApplication extends Application {
    Stage hlavneOkno;
    public void start(Stage okno){
        hlavneOkno = okno;
        hlavneOkno.setTitle("Appka");

        VBox centerBox = new VBox();
        Label textLabel = new Label("Zadajte text");
        TextArea textArea = new TextArea();

        Label regexLabel = new Label("Zadaj regex");
        TextField regexTextField = new TextField();

        Button checkButton = new Button("CHECK");
        checkButton.setOnAction(e -> {
            Pattern pattern = Pattern.compile(regexTextField.getText());
            Matcher matcher = pattern.matcher(textArea.getText());

            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Result");
            a.setHeaderText(null);
            a.setContentText(matcher.find() ? "OK" : "NG");
            a.showAndWait();
        });

        centerBox.getChildren().addAll(textLabel, textArea, regexLabel, regexTextField, checkButton);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(centerBox);
        borderPane.setStyle("-fx-font-family: 'Arial';" + "-fx-font-size: 20;");

        hlavneOkno.setScene(new Scene(borderPane, 500, 600));
        hlavneOkno.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}