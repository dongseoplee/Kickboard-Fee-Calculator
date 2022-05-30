package com.software.demo;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

public class time {

    @Test
    public void timeTest() {
        int hour = LocalTime.now().getHour();
        System.out.println("hour = " + hour);
    }
}
