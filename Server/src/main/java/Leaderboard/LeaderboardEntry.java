package Leaderboard;
import java.util.*;

    // Custom class Car implements Comparable interface
 public class LeaderboardEntry implements Comparable<LeaderboardEntry> {

        // attributes
        double time;
        String name;

        // Car constructor
        public LeaderboardEntry(String time, String name)
        {
            this.time = Double.parseDouble(time);
            this.name = name;
        }

        // Override the compareTo() method
        public int compareTo(LeaderboardEntry e)
        {
            if (time > e.time) {
                return 1;
            }
            else if (time < e.time) {
                return -1;
            }
            else {
                return 0;
            }
        }
    }

