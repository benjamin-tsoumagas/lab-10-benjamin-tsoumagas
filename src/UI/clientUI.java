package UI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class clientUI extends Application {

    @FXML
    public Button send;
    @FXML
    public Button exit;
    @FXML
    public TextField username;
    @FXML
    public TextField message;
    public static String msg;

    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/client.fxml"));
        primaryStage.setTitle("SimpleBBS Client v1.0");
        primaryStage.setScene(new Scene(root, 300, 300));
        primaryStage.show();
    }

    //returns string of the form 'Username: message text'
    public String handleSendButton(ActionEvent event) {
        msg = (username.getText()+": "+message.getText());
        message.clear();
        //System.out.println(msg);
        return msg;
    }

    public void handleExitButton(ActionEvent event) {
        System.exit(0);
    }

    public static String getMsg(){
        return msg;
    }

}
