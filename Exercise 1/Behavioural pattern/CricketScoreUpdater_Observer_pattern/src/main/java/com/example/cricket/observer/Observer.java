package com.example.cricket.observer;

import com.example.cricket.model.Score;

public interface Observer {
    void update(Score score);
}
