package com.example.cricket;

import com.example.cricket.model.Score;
import com.example.cricket.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class CricketScoreUpdater {
    private List<Observer> observers = new ArrayList<>();
    private Score score;

    public void registerObserver(Observer observer) {
        observers.add(observer);
        System.out.println("Observer registered: " + observer.getClass().getSimpleName());
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
        System.out.println("Observer removed: " + observer.getClass().getSimpleName());
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(score);
        }
        System.out.println("Observers notified with new score: " + score);
    }

    public void setScore(Score score) {
        this.score = score;
        notifyObservers();
    }
}
