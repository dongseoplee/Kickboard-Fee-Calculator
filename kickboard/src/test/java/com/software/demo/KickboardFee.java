package com.software.demo;

import com.software.demo.kickboard.KickboardFeeCalculator;
import com.software.demo.kickboard.KickboardTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.software.demo.kickboard.KickboardCompany.*;

public class KickboardFee {

    @Test
    @DisplayName("이동거리(km/h)를 이동시간(minute)으로 변환한다.")
    void calculateTime() {
        //given
        double distance = 5;
        KickboardTime kickboardTime = new KickboardTime(distance);

        //when
        Long time = kickboardTime.calculateKickboardTime(distance);

        //then
        Assertions.assertEquals(25,time);
    }

    @Test
    @DisplayName("이동시간이 소수점일시 반올림 한다.")
    void calculateDecimalTime() {
        //given
        double distance = 1.9;
        KickboardTime kickboardTime = new KickboardTime(distance);

        //when
        Long time = kickboardTime.calculateKickboardTime(distance);

        //then
        Assertions.assertEquals(10,time);
    }


    @Test
    @DisplayName("킥고잉-요금을 계산한다.")
    void getKickGoingFee() {
        //given
        double distance = 10;
        int hour = 3;
        KickboardTime kickboardTime = new KickboardTime(distance);
        Long time = kickboardTime.getEstimatedTime();

        //when
        KickboardFeeCalculator kickboardFeeCalculator = new KickboardFeeCalculator() {
            @Override
            public int getNowHour() {
                return hour;
            }
        };;
        long fee = kickboardFeeCalculator.getKickGoingFee(time);

        //then
        Assertions.assertEquals(5500,fee);
    }


    @Test
    @DisplayName("씽씽-요금을 계산한다.")
    void getSingSingFee() {
        //given
        double distance = 10;
        int hour = 10;
        KickboardTime kickboardTime = new KickboardTime(distance);

        //when
        KickboardFeeCalculator kickboardFeeCalculator = new KickboardFeeCalculator() {
            @Override
            public int getNowHour() {
                return hour;
            }
        };
        long fee = kickboardFeeCalculator.getSingSingFee(kickboardTime.getEstimatedTime());

        //then
        Assertions.assertEquals(5500,fee);
    }

    @Test
    @DisplayName("씽씽-오전 10시는 심야시간이 아니다.")
    void isSingSingNightAtAm10() {
        //given
        int hour = 10;
        //when
        KickboardFeeCalculator kickboardFeeCalculator = new KickboardFeeCalculator();
        boolean isNight = kickboardFeeCalculator.isNight(hour, SINGSING);
        //then
        Assertions.assertFalse(isNight);
    }

    @Test
    @DisplayName("씽씽-오전 3시는 심야시간이다.")
    void isSingSingNightAtAm3() {
        //given
        int hour = 3;

        //when
        KickboardFeeCalculator kickboardFeeCalculator = new KickboardFeeCalculator();
        boolean isNight = kickboardFeeCalculator.isNight(hour, SINGSING);
        //then
        Assertions.assertTrue(isNight);
    }

    @Test
    @DisplayName("씽씽-심야요금을 계산한다")
    void getSingSingNightFee() {
        //given
        double distance = 10;
        int hour = 3;
        KickboardTime kickboardTime = new KickboardTime(distance);
        Long time = kickboardTime.getEstimatedTime();

        //when
        KickboardFeeCalculator kickboardFeeCalculator = new KickboardFeeCalculator() {
            @Override
            public int getNowHour() {
                return hour;
            }
        };

        long fee = kickboardFeeCalculator.getSingSingFee(time);

        //then
        Assertions.assertEquals(6500,fee);
    }

    @Test
    @DisplayName("스윙-요금을계산한다.")
    void getSwingFee() {
        //given
        double distance = 10;
        int hour = 10;
        KickboardTime kickboardTime = new KickboardTime(distance);
        Long time = kickboardTime.getEstimatedTime();


        //when
        KickboardFeeCalculator kickboardFeeCalculator = new KickboardFeeCalculator() {
            @Override
            public int getNowHour() {
                return hour;
            }
        };
        long fee = kickboardFeeCalculator.getSwingFee(time);

        //then
        Assertions.assertEquals(6120,fee);
    }

    @Test
    @DisplayName("스윙-오전 10시는 심야시간이 아니다.")
    void isSwingNightAt10Am() {
        //given
        int hour = 10;

        //when
        KickboardFeeCalculator kickboardFeeCalculator = new KickboardFeeCalculator();
        boolean isNight = kickboardFeeCalculator.isNight(hour, SWING);

        //then
        Assertions.assertFalse(isNight);
    }

    @Test
    @DisplayName("스윙-오전 3시는 심야시간이다.")
    void isSwingNightAt3Am() {
        //given
        int hour = 3;

        //when
        KickboardFeeCalculator kickboardFeeCalculator = new KickboardFeeCalculator();
        boolean isNight = kickboardFeeCalculator.isNight(hour, SWING);

        //then
        Assertions.assertTrue(isNight);
    }

    @Test
    @DisplayName("스윙-심야요금을 계산한다.")
    void getSwingNightFee() {
        //given
        double distance = 10;
        KickboardTime kickboardTime = new KickboardTime(distance);
        Long time = kickboardTime.getEstimatedTime();
        int hour = 3;

        //when
        KickboardFeeCalculator kickboardFeeCalculator = new KickboardFeeCalculator() {
            @Override
            public int getNowHour() {
                return hour;
            }
        };
        long fee = kickboardFeeCalculator.getSwingFee(time);

        //then
        Assertions.assertEquals(8220,fee);
    }

    @Test
    @DisplayName("라임-요금을 계산한다.")
    void getLimeFee() {
        //given
        double distance = 10;
        KickboardTime kickboardTime = new KickboardTime(distance);
        Long time = kickboardTime.getEstimatedTime();

        //when
        KickboardFeeCalculator kickboardFeeCalculator = new KickboardFeeCalculator();
        long fee = kickboardFeeCalculator.getLimeFee(time);

        //then
        Assertions.assertEquals(10200,fee);
    }




    @Test
    @DisplayName("지쿠터-요금을 계산한다.")
    void getGcooterFee() {
        //given
        double distance = 10;
        KickboardTime kickboardTime = new KickboardTime(distance);
        Long time = kickboardTime.getEstimatedTime();

        //when
        KickboardFeeCalculator kickboardFeeCalculator = new KickboardFeeCalculator();
        long fee = kickboardFeeCalculator.getGcooterFee(time);

        //then
        Assertions.assertEquals(6670,fee);
    }


    @Test
    @DisplayName("지쿠터-오전 3시는 심야시간이다.")
    void isGcooterNightAt3Am() {
        //given
        int hour = 3;

        //when
        KickboardFeeCalculator kickboardFeeCalculator = new KickboardFeeCalculator();
        boolean isNight = kickboardFeeCalculator.isNight(hour, SWING);

        //then
        Assertions.assertTrue(isNight);
    }


    @Test
    @DisplayName("지쿠터-오전 10시는 심야시간이 아니다.")
    void isGcooterNightAt10Am() {
        //given
        int hour = 10;

        //when
        KickboardFeeCalculator kickboardFeeCalculator = new KickboardFeeCalculator();
        boolean isNight = kickboardFeeCalculator.isNight(hour, SWING);

        //then
        Assertions.assertFalse(isNight);
    }


    @Test
    @DisplayName("지쿠터-심야요금을 계산한다.")
    void getGcooterNightFee() {
        //given
        double distance = 10;
        int hour = 3;
        KickboardTime kickboardTime = new KickboardTime(distance);
        Long time = kickboardTime.getEstimatedTime();

        //when
        KickboardFeeCalculator kickboardFeeCalculator = new KickboardFeeCalculator() {
            @Override
            public int getNowHour() {
                return hour;
            }
        };;

        long fee = kickboardFeeCalculator.getGcooterFee(time);

        //then
        Assertions.assertEquals(7370,fee);
    }
}
