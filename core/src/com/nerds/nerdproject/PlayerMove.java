package com.nerds.nerdproject;

/**
 * Created by michal on 16.04.17.
 */

public class PlayerMove {
    public int x;
    public int y;
    public double duration;
    public double time;

    public PlayerMove(int x, int y, double duration, double time) {
        this.x = x;
        this.y = y;
        this.duration = duration;
        this.time = time;
    }
}
