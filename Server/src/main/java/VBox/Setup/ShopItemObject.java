package VBox.Setup;

import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ShopItemObject {
    private String name;
    private int price;
    private int count = 0;
    private int increment;
    private Image image;
    private ImageView viewImage = new ImageView(image);

    private Button button = new Button();

    public ShopItemObject(String name, int price, int increment, String image) {
        this.name = name;
        this.price = price;
        this.increment = increment;
        this.image = new Image(image);
        button.setGraphic(viewImage);
        button.setContentDisplay(ContentDisplay.LEFT);
        button.setText(name + "\n$" + price);
        button.setStyle("-fx-pref-height: 160; -fx-pref-width: 400; -fx-padding: 0; -fx-label-padding: 0");
    }

    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public int getCount() {
        return count;
    }
    public int getIncrement() {
        return increment;
    }
    public ImageView getViewImage() {
        return viewImage;
    }
    public Button getButton() {
        return button;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
