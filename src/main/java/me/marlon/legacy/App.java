package me.marlon.legacy;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.SneakyThrows;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class App extends Application implements Initializable {

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
        stage.show();

        System.out.println("[AVISO] Projeto iniciado com sucesso. [" + (System.currentTimeMillis() - start) + " ms]");
    }

    @SneakyThrows
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
