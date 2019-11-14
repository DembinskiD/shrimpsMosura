package sample;

import javafx.fxml.FXML;
import javafx.scene.layout.HBox;

public class Controller {
    public HBox centerBox = new HBox();
    Aquarium aquarium;

    public Controller(Aquarium aquarium) {
        this.aquarium = aquarium;
    }

    @FXML
    public void initialize() {
        //todo here need to add rectangle node with sensors
    }

}
