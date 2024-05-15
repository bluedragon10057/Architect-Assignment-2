package edu.sdccd.cisc191.template;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MenuController {

    private JumpingKidSetup left = new JumpingKidSetup();
    private BoughtPeopleDisplaySetup middle = new BoughtPeopleDisplaySetup();
    private ShopSetup right = new ShopSetup();
    private HBox root = new HBox(left.getVBox(), middle.getVBox(), right.getVBox() );
    private Scene scene = new Scene(root, 1200, 800 );


    public Scene getScene() {
        return scene;
    }
}
