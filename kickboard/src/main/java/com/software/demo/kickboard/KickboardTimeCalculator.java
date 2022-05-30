package com.software.demo.kickboard;

import lombok.Getter;

@Getter
public class KickboardTimeCalculator {
    public static long calculateUsingTime(double distance) {
        //1km 이동하는데 5분이 걸린다.
        double perMinute = (distance * 5);
        long kickboardUsingTime = Math.round(perMinute);
        return kickboardUsingTime;
    }
}
