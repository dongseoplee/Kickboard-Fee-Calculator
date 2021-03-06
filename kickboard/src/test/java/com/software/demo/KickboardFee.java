package com.software.demo;

import com.software.demo.kickboard.KickboardFeeCalculator;
import com.software.demo.kickboard.KickboardTimeCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static com.software.demo.kickboard.KickboardCompany.*;

public class KickboardFee {

    @Test
    @DisplayName("이동거리(km/h)를 이동시간(minute)으로 변환한다.")
    void calculateTime() {
        //given
        double distance = 5;

        //when
        long usingTime = KickboardTimeCalculator.calculateUsingTime(distance);

        //then
        Assertions.assertEquals(25,usingTime);
    }

    @Test
    @DisplayName("이동시간이 소수점일시 첫째자리에서 반올림 한다.")
    void calculateDecimalTime() {
        //given
        double distance = 1.9;

        long usingTime = KickboardTimeCalculator.calculateUsingTime(distance);

        //then
        Assertions.assertEquals(10,usingTime);
    }


    @Test
    @DisplayName("킥고잉-요금을 계산한다.")
    void getKickGoingFee() {
        //given
        double distance = 10;
        int hour = 3;
        long usingTime = KickboardTimeCalculator.calculateUsingTime(distance);

        //when
        KickboardFeeCalculator kickboardFeeCalculator = new KickboardFeeCalculator() {
            @Override
            public int getNowHour() {
                return hour;
            }
        };;
        long fee = kickboardFeeCalculator.getKickGoingFee(usingTime);

        //then
        Assertions.assertEquals(5500,fee);
    }


    @Test
    @DisplayName("씽씽-요금을 계산한다.")
    void getSingSingFee() {
        //given
        double distance = 10;
        int hour = 10;
        long usingTime = KickboardTimeCalculator.calculateUsingTime(distance);

        //when
        KickboardFeeCalculator kickboardFeeCalculator = new KickboardFeeCalculator() {
            @Override
            public int getNowHour() {
                return hour;
            }
        };
        long fee = kickboardFeeCalculator.getSingSingFee(usingTime);

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
        double distance = 1.6;
        int hour = 3;
        long usingTime = KickboardTimeCalculator.calculateUsingTime(distance);

        //when
        KickboardFeeCalculator kickboardFeeCalculator = new KickboardFeeCalculator() {
            @Override
            public int getNowHour() {
                return hour;
            }
        };

        long fee = kickboardFeeCalculator.getSingSingFee(usingTime);

        //then
        Assertions.assertEquals(2300,fee);
    }

    @Test
    @DisplayName("스윙-요금을계산한다.")
    void getSwingFee() {
        //given
        double distance = 10;
        int hour = 10;
        long usingTime = KickboardTimeCalculator.calculateUsingTime(distance);


        //when
        KickboardFeeCalculator kickboardFeeCalculator = new KickboardFeeCalculator() {
            @Override
            public int getNowHour() {
                return hour;
            }
        };
        long fee = kickboardFeeCalculator.getSwingFee(usingTime);

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
        System.out.println("LocalTime.now().getHour() = " + LocalTime.now().getHour());
        long usingTime = KickboardTimeCalculator.calculateUsingTime(distance);
        int hour = 3;

        //when
        KickboardFeeCalculator kickboardFeeCalculator = new KickboardFeeCalculator() {
            @Override
            public int getNowHour() {
                return hour;
            }
        };
        long fee = kickboardFeeCalculator.getSwingFee(usingTime);

        //then
        Assertions.assertEquals(8220,fee);
    }

    @Test
    @DisplayName("라임-요금을 계산한다.")
    void getLimeFee() {
        //given
        double distance = 10;
        long usingTime = KickboardTimeCalculator.calculateUsingTime(distance);

        //when
        KickboardFeeCalculator kickboardFeeCalculator = new KickboardFeeCalculator();
        long fee = kickboardFeeCalculator.getLimeFee(usingTime);

        //then
        Assertions.assertEquals(10200,fee);
    }




    @Test
    @DisplayName("지쿠터-요금을 계산한다.")
    void getGcooterFee() {
        //given
        double distance = 10;
        int hour = 10;
        long usingTime = KickboardTimeCalculator.calculateUsingTime(distance);

        //when
        KickboardFeeCalculator kickboardFeeCalculator = new KickboardFeeCalculator() {
            @Override
            public int getNowHour() {
                return hour;
            }
        };
        long fee = kickboardFeeCalculator.getGcooterFee(usingTime);

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
        long usingTime = KickboardTimeCalculator.calculateUsingTime(distance);

        //when
        KickboardFeeCalculator kickboardFeeCalculator = new KickboardFeeCalculator() {
            @Override
            public int getNowHour() {
                return hour;
            }
        };;

        long fee = kickboardFeeCalculator.getGcooterFee(usingTime);

        //then
        Assertions.assertEquals(7370,fee);
    }
}
