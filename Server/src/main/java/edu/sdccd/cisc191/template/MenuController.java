package edu.sdccd.cisc191.template;

import VBox.Setup.BoughtPeopleDisplaySetup;
import VBox.Setup.ClickingKidSetup;
import VBox.Setup.ShopAndButtonSetup;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MenuController {

    private ClickingKidSetup left = new ClickingKidSetup();
    private BoughtPeopleDisplaySetup middle = new BoughtPeopleDisplaySetup();
    private ShopAndButtonSetup right = new ShopAndButtonSetup(left.getIntTotalCracks(), left.getLabelTotalCracks(), left.getIntCracksPerSec(), left.getLabelCracksPerSec(), left.getClickKid(), left.getImageJumping(), left.getImageStanding(), left.getTimer() );
    private HBox root = new HBox(left.getVBox(), middle.getVBox(), right.getVBox() );
    private Scene scene = new Scene(root, 1200, 800 );

    public MenuController() {
        right.setScene(scene);
    }

    public Scene getScene() {
        return scene;
    }
}
