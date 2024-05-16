package Leaderboard;

import java.util.*;
import javafx.scene.Scene;
import java.io.*;
import java.util.concurrent.atomic.AtomicReference;

import javafx.scene.layout.VBox;
import javafx.scene.control.*;

public class Leaderboard {
    private File file = new File("C:\\Users\\My Laptop\\IdeaProjects\\Architect-Assignment-2\\Server\\src\\main\\resources\\LeaderboardSaveData.txt");
    private Scanner reader = new Scanner(file);
    private FileWriter writer = new FileWriter(file, true);
    private TreeSet<LeaderboardEntry> set = new TreeSet<LeaderboardEntry>();
    private VBox vboxAskName = new VBox();
    private VBox vboxDisplayLeaderBoard = new VBox();
    private TextField enterName = new TextField();
    private Scene sceneLeaderboard;
    private String time;

    // Main driver method
    public Leaderboard (String time, Scene scene) throws IOException {
        this.time = time;
        sceneLeaderboard = scene;
        getEntriesFromFile();
        Label askName = new Label("Congratulations! You finished in " + time + " seconds. What is your name?");
        Button buttonSubmit = new Button("Submit");
        vboxAskName.getChildren().setAll(askName, enterName, buttonSubmit);
        scene.setRoot(vboxAskName);

        buttonSubmit.setOnMouseClicked( evt -> {
            try {
                displayLeaderBoard();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }

    public void getEntriesFromFile() {
        String time;
        String name;
        while ( reader.hasNextLine() ) {
            time = reader.nextLine();
            name = reader.nextLine();
            set.add(new LeaderboardEntry(time, name) );
        }
        reader.close();
    }

    public void displayLeaderBoard() throws IOException {
        String name = enterName.getText();
        writer.write(time + "\n");
        writer.write(name + "\n");
        writer.close();
        set.add(new LeaderboardEntry(time, name) );
        for (LeaderboardEntry c : set) {
            Label entry = new Label(c.time + " " + c.name);
            entry.setStyle("-fx-font-size: 50; -fx-font-family: 'Comic Sans MS'");
            vboxDisplayLeaderBoard.getChildren().add(entry);
        }
        sceneLeaderboard.setRoot(vboxDisplayLeaderBoard);
    }
}