package VBox.Setup;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import Leaderboard.Leaderboard;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class ShopAndButtonSetup {
    private VBox vbox = new VBox();
    private ShopItemObject[] shopItems = new ShopItemObject[5];
    private Button[] buttons = new Button[5];
    private Stage stage;
    private int intTotalCracks;
    private int intCracksPerSec;
    private String finalTime;
    public ShopAndButtonSetup(Integer integerTotalCracks, Label labelTotalCracks, Integer integerCracksPerSec, Label labelCracksPerSec, ImageView clickKid, Image imageJumping, Image imageStanding, FXTimer timer, Stage stage) {
        intTotalCracks = integerTotalCracks;
        intCracksPerSec = integerCracksPerSec;
        shopItems[0] = new ShopItemObject("Another Kid", 5, 1,"100x100.jpg" );
        shopItems[1] = new ShopItemObject("Twins :0", 10, 2,"100x100.jpg" );
        shopItems[2] = new ShopItemObject("TRIPLETS", 50, 3,"100x100.jpg" );
        shopItems[3] = new ShopItemObject("The Family <3", 1, 100000, "100x100.jpg" );
        shopItems[4] = new ShopItemObject("THE CLASSROOM??", 1, 100000,"100x100.jpg" );

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

        clickKid.setOnMousePressed( evt -> clickKid.setImage(imageJumping) );
        clickKid.setOnMouseReleased( evt -> {
            clickKid.setImage(imageStanding);
            ++intTotalCracks;
            labelTotalCracks.setText(intTotalCracks + " backs cracked" );
        } );

        Button timerButton = timer.getTimerButton();
        timerButton.fire();
        Label timerLabel = timer.getTimerLabel();

        Timeline oneSecondsWonder = new Timeline(
                new KeyFrame(Duration.seconds(0.5),
                        new EventHandler<ActionEvent>() {

                            @Override
                            public void handle(ActionEvent event) {
                                intTotalCracks += intCracksPerSec/2;
                                labelTotalCracks.setText(intTotalCracks + " backs cracked");
                                labelCracksPerSec.setText("per second: "+ + intCracksPerSec);
                                if (intTotalCracks >= 1000000) {
                                    finalTime = timerLabel.getText();
                                    timer.timeline.stop();
                                    try {
                                        triggerLeaderboard();
                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }

                                }
                            }
                        } ) );
        oneSecondsWonder.setCycleCount(Timeline.INDEFINITE);
        oneSecondsWonder.play();
    }

    public void triggerLeaderboard() throws IOException {
        Leaderboard leaderboard = new Leaderboard(finalTime);
        stage.setScene( leaderboard.getScene() );
    }

    public VBox getVBox() {
        return vbox;
    }
}
