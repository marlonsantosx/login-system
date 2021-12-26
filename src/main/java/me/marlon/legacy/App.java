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

public class App extends Application {

    public static final String localHistory = "C:/Users/Marlon/IdeaProjects/legacy/src/main/java/me/marlon",
    title = "Login System",
    version = "1.0v";

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        long start = System.currentTimeMillis();
        System.out.println("[AVISO] Iniciando o projeto.");

        Parent parent = FXMLLoader.load(new File(localHistory + "/legacy/style/index.fxml").toURL());
        stage.setScene(new Scene(parent));
        stage.setResizable(false);
        stage.getScene().setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.getIcons().add(new Image("file:///" + localHistory + "/legacy/style/image/logo.png"));
        stage.setTitle(title);

        User user = new User("Marlon");
        user.setName();

        Listeners.stage = stage;
        stage.show();
        System.out.println("[AVISO] Projeto iniciado com sucesso. [" + (System.currentTimeMillis() - start) + " ms]");
    }
}
