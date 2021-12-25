package me.marlon.legacy;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import me.marlon.legacy.data.account.User;

import java.io.File;

public class App extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        long start = System.currentTimeMillis();
        System.out.println("[AVISO] Iniciando o projeto.");

        Parent parent = FXMLLoader.load(new File("C:/Users/Marlon/IdeaProjects/legacy/src/main/java/me/marlon/legacy/style/index.fxml").toURL());
        stage.setScene(new Scene(parent));
        stage.setResizable(false);
        stage.getScene().setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);

        User user = new User("Marlon");
        user.setName();

        stage.show();


        System.out.println("[AVISO] Projeto iniciado com sucesso. [" + (System.currentTimeMillis() - start) + " ms]");
        }
    }
