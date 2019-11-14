package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Aquarium temp = new Aquarium();
        Controller controller = new Controller(temp);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/mosuraMain.fxml"));
        loader.setController(controller);
        BorderPane root = loader.load();
        primaryStage.setTitle("Shrimps Mosura");
        primaryStage.getIcons().add(new Image("http://mosura.pl/public/images/kreweta.gif"));
        Scene mainScene = new Scene(root, 640, 480);
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
