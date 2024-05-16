package Leaderboard;

import java.util.*;
import javafx.scene.Scene;
import java.io.*;
import javafx.scene.layout.VBox;
import javafx.scene.control.*;

public class Leaderboard {
    private File file = new File("LeaderboardSaveData.txt");
    private Scanner reader = new Scanner(file);
    private PrintWriter writer = new PrintWriter(file);
    private TreeSet<LeaderboardEntry> set = new TreeSet<LeaderboardEntry>();
    private VBox vbox = new VBox();

    private Scene scene = new Scene(vbox);

    // Main driver method
    public Leaderboard (String time) throws IOException {
        getEntriesFromFile();

        Label labelName = new Label();
        String stringName = null;
        Label askName = new Label("What is your name?");
        TextField enterName = new TextField();
        Button button = new Button("Submit");

        vbox.getChildren().setAll(askName, enterName, button);
        button.setOnAction( evt -> labelName.setText( enterName.getText() ) );
        stringName = labelName.getText();

        writer.println(time);
        writer.println(stringName);
        set.add(new LeaderboardEntry( time, stringName) );

    }

    public Scene getScene() {
        return scene;
    }

    public void getEntriesFromFile() {
        String time;
        String name;
        while ( reader.hasNextLine() ) {
            time = reader.nextLine();
            name = reader.nextLine();
            set.add(new LeaderboardEntry(time, name) );
        }
    }
}