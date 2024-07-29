package com.example.cricket.observer;

import com.example.cricket.model.Score;

public class ScoreObserver implements Observer {
    @Override
    public void update(Score score) {
        System.out.println("Score updated: " + score);
    }
}
