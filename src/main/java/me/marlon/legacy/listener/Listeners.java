package me.marlon.legacy.listener;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import me.marlon.legacy.App;

import java.net.URL;
import java.util.ResourceBundle;

public class Listeners implements Initializable {

    @FXML
    private AnchorPane sidebar;

    @FXML
    private HBox sidebar_top;

    @FXML
    private ImageView eye;

    @FXML
    private Button minimized, exit, login;

    @FXML
    private Label title, warning, pwdForgot;

    @FXML
    private TextField email, pwdText;

    @FXML
    private PasswordField pwd;

    public static Stage stage;
    public double x = 0, y = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        title.setText(App.title + " " + App.version);
        sidebar_top.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        sidebar_top.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
        });

        minimized.setOnMouseClicked(event -> {
            final Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            stage.setIconified(true);
        });
        exit.setOnMouseClicked(event -> {
            final Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            stage.close();
        });

        pwdText.setVisible(false);
        eye.setOnMouseClicked(event -> {
            if(pwd.isVisible()) {
                eye.setImage(new Image("file:///" + App.path + "/style/image/icon/showEye.png"));
                pwd.setVisible(false);
                pwdText.setVisible(true);
                pwdText.setText(pwd.getText());
            } else {
                eye.setImage(new Image("file:///" + App.path + "/style/image/icon/hideEye.png"));
                pwd.setVisible(true);
                pwdText.setVisible(false);
                pwd.setText(pwdText.getText());
            }
        });

        login.setOnMouseClicked(event -> {
            if(email.getText().isEmpty() && pwdText.getText().isEmpty() || pwd.getText().isEmpty()) {
                warning.setText("* Insira o nome de e-mail e senha.");
                return;
            }
            if(email.getText().isEmpty() && !pwdText.getText().isEmpty() || !pwd.getText().isEmpty()) {
                warning.setText("* Insira o nome de e-mail.");
                return;
            }
            if(!email.getText().isEmpty() && pwdText.isVisible() && pwdText.getText().isEmpty() || pwd.isVisible() && pwd.getText().isEmpty()) {
                warning.setText("* Insira sua senha.");
                return;
            }
        });

    }

}
