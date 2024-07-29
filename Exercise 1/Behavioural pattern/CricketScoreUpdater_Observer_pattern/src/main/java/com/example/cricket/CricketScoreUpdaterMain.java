package com.example.cricket;

import com.example.cricket.model.Score;
import com.example.cricket.util.ConsoleInput;
import com.example.cricket.observer.ScoreObserver;

public class CricketScoreUpdaterMain {
    public static void main(String[] args) {
        CricketScoreUpdater scoreUpdater = new CricketScoreUpdater();
        ScoreObserver scoreObserver = new ScoreObserver();
        scoreUpdater.registerObserver(scoreObserver);

        boolean running = true;
        while (running) {
            try {
                System.out.println("Choose an option:");
                System.out.println("1. Update score");
                System.out.println("2. Quit");
                int choice = ConsoleInput.getInt("Enter your choice: ");

                switch (choice) {
                    case 1:
                        int runs = ConsoleInput.getInt("Enter runs: ");
                        int wickets = ConsoleInput.getInt("Enter wickets: ");
                        int overs = ConsoleInput.getInt("Enter overs: ");

                        Score score = new Score(runs, wickets, overs);
                        scoreUpdater.setScore(score);
                        break;
                    case 2:
                        running = false;
                        System.out.println("Exiting the application. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
