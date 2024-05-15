package VBox.Setup;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.util.concurrent.atomic.AtomicInteger;

public class ShopSetup {
    private VBox vbox = new VBox();
    private ShopItemObject[] shopItems = new ShopItemObject[5];
    private Button[] buttons = new Button[5];
    private int intTotalCracks;
    private int intCracksPerSec;
    public ShopSetup(Integer integerTotalCracks, Label labelTotalCracks, Integer integerCracksPerSec, Label labelCracksPerSec, ImageView clickKid, Image imageJumping, Image imageStanding) {
        intTotalCracks = integerTotalCracks;
        intCracksPerSec = integerCracksPerSec;
        shopItems[0] = new ShopItemObject("Another Kid", 5, 1,"160-x-160-pixels.jpg" );
        shopItems[1] = new ShopItemObject("Twins :0", 10, 2,"160-x-160-pixels.jpg" );
        shopItems[2] = new ShopItemObject("TRIPLETS", 50, 3,"160-x-160-pixels.jpg" );
        shopItems[3] = new ShopItemObject("The Family <3", 100, 5, "160-x-160-pixels.jpg" );
        shopItems[4] = new ShopItemObject("THE CLASSROOM??", 500, 10,"160-x-160-pixels.jpg" );
        clickKid.setOnMousePressed( evt -> clickKid.setImage(imageJumping) );
        clickKid.setOnMouseReleased( evt -> {
            clickKid.setImage(imageStanding);
            ++intTotalCracks;
            labelTotalCracks.setText(intTotalCracks + " backs cracked" );
        } );

        for (int i = 0; i < 4; i++) {
            buttons[i] = shopItems[i].getButton();
            int finalI = i;
            AtomicInteger count = new AtomicInteger(shopItems[i].getCount());
            buttons[i].setOnMouseClicked(evt -> {
                intCracksPerSec += shopItems[finalI].getIncrement();
                count.getAndIncrement();
                shopItems[finalI].setCount(count.get());
                intTotalCracks -= shopItems[finalI].getPrice();
                labelTotalCracks.setText(intTotalCracks + " backs cracked");
                labelCracksPerSec.setText("per second: " + intCracksPerSec);
            } );
            vbox.getChildren().add( buttons[i] );
        }

        Timeline oneSecondsWonder = new Timeline(
                new KeyFrame(Duration.seconds(1),
                        new EventHandler<ActionEvent>() {

                            @Override
                            public void handle(ActionEvent event) {
                                intTotalCracks += intCracksPerSec;
                                labelTotalCracks.setText(intTotalCracks + " backs cracked");
                                labelCracksPerSec.setText("per second: "+ + intCracksPerSec);
                            }
                        } ) );
        oneSecondsWonder.setCycleCount(Timeline.INDEFINITE);
        oneSecondsWonder.play();
    }

    public VBox getVBox() {
        return vbox;
    }
}
