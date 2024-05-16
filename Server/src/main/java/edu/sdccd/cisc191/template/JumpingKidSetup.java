package edu.sdccd.cisc191.template;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class JumpingKidSetup {
    private Integer intTotalCracks = new Integer(0);
    private Label labelTotalCracks = new Label(intTotalCracks.toString() + "\nbacks cracked" );
    private Integer intCracksPerSec = new Integer(0);
    private Label labelCracksPerSec = new Label ("per second: " + intCracksPerSec.toString() );
    private Image imageStanding = new Image();
    private Image imageJumping = new Image();
    private ImageView clickKid = new ImageView(imageStanding);
    private VBox vBox = new VBox(labelTotalCracks, labelCracksPerSec, clickKid);

    public JumpingKidSetup() {
        clickKid.setOnMousePressed( evt -> clickKid.setImage(imageJumping) );
        clickKid.setOnMouseReleased( evt -> {
            clickKid.setImage(imageStanding);
            intTotalCracks++;
            labelTotalCracks.setText(intTotalCracks.toString() + "\nbacks cracked" );
        } );
    }

    public Integer getIntTotalCracks() {
        return intTotalCracks;
    }
    public Label getLabelTotalCracks() {
        return labelTotalCracks;
    }
    public Integer getIntCracksPerSec() {
        return intCracksPerSec;
    }
    public Label getLabelCracksPerSec() {
        return labelCracksPerSec;
    }
    public VBox getVBox() {
        return vBox;
    }
}
