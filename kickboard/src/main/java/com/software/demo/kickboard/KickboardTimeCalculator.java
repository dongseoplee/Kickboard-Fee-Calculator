package com.software.demo.kickboard;

import lombok.Getter;

@Getter
public class KickboardTimeCalculator {


    public static long calculateUsingTime(double distance) {
        double perMinute = (distance * 5);
        long kickboardUsingTime = Math.round(perMinute);
        return kickboardUsingTime;
    }
}
