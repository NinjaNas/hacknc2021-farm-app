package com.hacknc;

import java.time.Duration;
import java.time.Instant;

public class FPS {
    private FPS() {}

    private static Duration fpsDeltaTime = Duration.ZERO;
    private static Duration LastTime = Duration.ZERO;
    private static Instant beginTime = Instant.now();
    private static double deltaTime = fpsDeltaTime.toMillis() - LastTime.toMillis();


    public static void calculatebeginningTime(){
        beginTime = Instant.now();
        fpsDeltaTime = Duration.ZERO;
    }

    public static void calcDeltaTime(){
        fpsDeltaTime = Duration.between(beginTime, Instant.now());
        deltaTime = (double)fpsDeltaTime.toMillis() - LastTime.toMillis();
        LastTime = fpsDeltaTime;
    }

    public static double getDeltaTime(){
        return deltaTime/1000; //changes milliseconds to seconds
    }
}