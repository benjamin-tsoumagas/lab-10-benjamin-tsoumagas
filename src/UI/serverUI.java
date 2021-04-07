package UI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class serverUI extends Application {

    @FXML
    public TextArea serverMessages;
    @FXML
    public Button serverExit;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/server.fxml"));
        primaryStage.setTitle("SimpleBBS Server v1.0");
        primaryStage.setScene(new Scene(root, 300, 300));
        primaryStage.show();
    }

    public void handleServerExit(ActionEvent event) {
        System.exit(0);
    }


}

