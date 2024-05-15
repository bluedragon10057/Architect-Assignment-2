package edu.sdccd.cisc191.template;

import VBox.Setup.BoughtPeopleDisplaySetup;
import VBox.Setup.ClickingKidSetup;
import VBox.Setup.ShopSetup;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MenuController {

    private ClickingKidSetup left = new ClickingKidSetup();
    private BoughtPeopleDisplaySetup middle = new BoughtPeopleDisplaySetup();
    private ShopSetup right = new ShopSetup(left.getIntTotalCracks(), left.getLabelTotalCracks(), left.getIntCracksPerSec(), left.getLabelCracksPerSec(), left.getClickKid(), left.getImageJumping(), left.getImageStanding() );
    private HBox root = new HBox(left.getVBox(), middle.getVBox(), right.getVBox() );
    private Scene scene = new Scene(root, 1200, 800 );


    public Scene getScene() {
        return scene;
    }
}
