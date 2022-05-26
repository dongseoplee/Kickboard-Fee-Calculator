package com.software.demo.kickboard;

import lombok.Getter;

@Getter
public class KickboardTime {

    private Long estimatedTime;  // 이동 시간

    public KickboardTime(Double distance) {
        this.estimatedTime = calculateKickboardTime(distance);
    }

    public long calculateKickboardTime(double distance) {
        double perMinute = (distance * 5);
        long kickboardMinute = Math.round(perMinute);

        return kickboardMinute;
    }
}
