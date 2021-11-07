package com.hacknc;

public class FPS {

    private static double lastTime;

    public static void setStart(double start)
    {
        lastTime = start;
    }

    public static double newFrame(double currentTime)
    {
        double deltaTime = currentTime - lastTime;
        lastTime = currentTime;
        return deltaTime;
    }
}