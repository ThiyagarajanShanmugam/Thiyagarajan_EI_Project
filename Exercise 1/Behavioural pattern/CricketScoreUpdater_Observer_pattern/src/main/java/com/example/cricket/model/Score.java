package com.example.cricket.model;

public class Score {
    private int runs;
    private int wickets;
    private int overs;

    public Score(int runs, int wickets, int overs) {
        this.runs = runs;
        this.wickets = wickets;
        this.overs = overs;
    }

    public int getRuns() {
        return runs;
    }

    public int getWickets() {
        return wickets;
    }

    public int getOvers() {
        return overs;
    }

    @Override
    public String toString() {
        return "Score [runs=" + runs + ", wickets=" + wickets + ", overs=" + overs + "]";
    }
}
