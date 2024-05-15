package VBox.Setup;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class ClickingKidSetup {
    private Integer intTotalCracks = new Integer(1);
    private Label labelTotalCracks = new Label(intTotalCracks.toString() + " backs cracked" );
    private Integer intCracksPerSec = new Integer(0);
    private Label labelCracksPerSec = new Label ("per second: " + intCracksPerSec.toString() );
    private Image imageStanding = new Image("standingkid.png");
    private Image imageJumping = new Image("jumpingkid.png");
    private ImageView clickKid = new ImageView(imageStanding);
    private VBox vBox = new VBox(labelTotalCracks, labelCracksPerSec, clickKid);

    public ClickingKidSetup() {
        labelTotalCracks.setStyle("-fx-alignment: CENTER; -fx-pref-height: 100;");
        labelCracksPerSec.setStyle("-fx-alignment: CENTER; -fx-pref-height: 50;");


        vBox.setStyle("-fx-pref-height: 800; -fx-pref-width: 400; -fx-alignment: CENTER;");
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

    public ImageView getClickKid() {
        return clickKid;
    }

    public Image getImageJumping() {
        return imageJumping;
    }

    public Image getImageStanding() {
        return imageStanding;
    }
}
