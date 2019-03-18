package com.example.iverson.pruebacuatro.models;

public class PortionWrapper {

    private int total_hits;
    private double max_score;
    private Portion[] hits;

    public PortionWrapper() {
    }

    public int getTotal_hits() {
        return total_hits;
    }

    public void setTotal_hits(int total_hits) {
        this.total_hits = total_hits;
    }

    public double getMax_score() {
        return max_score;
    }

    public void setMax_score(double max_score) {
        this.max_score = max_score;
    }

    public Portion[] getHits() {
        return hits;
    }

    public void setHits(Portion[] hits) {
        this.hits = hits;
    }


}
