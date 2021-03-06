package me.marlon.legacy;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import me.marlon.legacy.data.account.User;
import me.marlon.legacy.listener.Listeners;

import java.io.File;
import java.text.DecimalFormat;

public class App extends Application {

    public static final String path = "C:/Users/Marlon/IdeaProjects/legacy/src/main/java/me/marlon/legacy",
    title = "Login System",
    version = "1.0v";

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        long start = System.currentTimeMillis();
        System.out.println("[WARNING] Starting the project.");

        Parent parent = FXMLLoader.load(new File(path + "/style/index.fxml").toURL());
        stage.setScene(new Scene(parent));
        stage.setResizable(false);
        stage.getScene().setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.getIcons().add(new Image("file:///" + path + "/style/image/logo.png"));
        stage.setTitle(title);

        Listeners.stage = stage;
        stage.show();

        double seconds = ((System.currentTimeMillis() - start) / 1000d);

        System.out.println("[WARNING] Project started successfully. (" + new DecimalFormat("#,#").format(seconds) + " " + (seconds > 1 ? "seconds" : "second") + ")");
    }
}
