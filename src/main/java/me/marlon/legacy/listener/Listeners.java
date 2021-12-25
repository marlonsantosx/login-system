package me.marlon.legacy.listener;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Listeners implements Initializable {

    @FXML
    private Button minimized, exit;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        minimized.setOnMouseClicked(event -> {
            final Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            stage.setIconified(true);
        });
        exit.setOnMouseClicked(event -> {
            final Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            stage.close();
        });
    }

}
