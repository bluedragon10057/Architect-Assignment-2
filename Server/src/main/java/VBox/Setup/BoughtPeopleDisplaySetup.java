package VBox.Setup;
import javafx.scene.layout.VBox;

import java.io.BufferedOutputStream;

public class BoughtPeopleDisplaySetup {
    private VBox vbox = new VBox();

    public BoughtPeopleDisplaySetup() {
        vbox.setPrefWidth(400);
        vbox.setPrefHeight(800);
    }

    public VBox getVBox() {
        return vbox;
    }
}
