package Lab9;
import Lab9.view.MainWindow;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App - Ponto de entrada da aplicação
 */
public class AppLab9 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Criar a view principal
        MainWindow mainWindow = new MainWindow();

        // Criar a cena
        Scene scene = new Scene(mainWindow, 700, 650);

        // Configurar o stage
        primaryStage.setTitle("Gestão de Pedidos de Apoio Técnico");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
