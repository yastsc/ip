package star.main;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * A GUI for Star using FXML.
 */
public class Main extends Application {

    private Star star = new Star("data/star.txt");

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            MainWindow controller = fxmlLoader.getController();
            controller.setStar(star);  // inject the Duke instance
            controller.showStarStartMessage();
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



//    @Override
//    public void start(Stage stage1) {
//        Stage stage2 = new Stage();
//        Label helloWorld = new Label("Hello World!"); // Creating a new Label control
//        Label whee = new Label("WHEE!"); // Creating a new Label control
//        Scene scene = new Scene(helloWorld); // Setting the scene to be our Label
//        Scene scene2 = new Scene(whee);
//        helloWorld.setFont(new Font("Arial", 50));
//        stage1.setScene(scene); // Setting the stage to show our scene
//        stage1.show(); // Render the stage.
//        stage2.setScene(scene2); // Setting the stage to show our scene
//        stage2.show(); // Render the stage.
//    }


