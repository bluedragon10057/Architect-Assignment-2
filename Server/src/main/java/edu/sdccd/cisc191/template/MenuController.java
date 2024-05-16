package edu.sdccd.cisc191.template;

import VBox.Setup.BoughtPeopleDisplaySetup;
import VBox.Setup.ClickingKidSetup;
import VBox.Setup.ShopAndButtonSetup;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuController {

    private ClickingKidSetup left = new ClickingKidSetup();
    private BoughtPeopleDisplaySetup middle = new BoughtPeopleDisplaySetup( left.getTimer() );
    private Stage stage;
    private ShopAndButtonSetup right = new ShopAndButtonSetup(left.getIntTotalCracks(), left.getLabelTotalCracks(), left.getIntCracksPerSec(), left.getLabelCracksPerSec(), left.getClickKid(), left.getImageJumping(), left.getImageStanding(), left.getTimer(), stage );
    private HBox root = new HBox(left.getVBox(), middle.getVBox(), right.getVBox() );
    private Scene scene = new Scene(root, 1200, 800 );

    public MenuController(Stage stage) {
        this.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }
}
