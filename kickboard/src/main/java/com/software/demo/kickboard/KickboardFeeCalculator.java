package com.software.demo.kickboard;

import lombok.Setter;

import java.time.LocalTime;

import static com.software.demo.kickboard.KickboardCompany.*;

@Setter
public class KickboardFeeCalculator {


    public long getKickGoingFee(long usingTime) {
        long kickGoingFee = KICKGOING.getBasicFee();

        if (usingTime > KICKGOING.basicMinute) {
            kickGoingFee = kickGoingFee + KICKGOING.perMinuteFee * (usingTime - KICKGOING.basicMinute);
        }
        return kickGoingFee;
    }

    public long getSingSingFee(long usingTime) {
        long singsingFee;
        int nowHour = getNowHour();

        if (isNight(nowHour,SINGSING)) {
            singsingFee = SINGSINGNIGTH.getBasicFee();
            if (usingTime > SINGSINGNIGTH.basicMinute) {
                singsingFee = singsingFee + SINGSINGNIGTH.perMinuteFee * (usingTime - SINGSINGNIGTH.basicMinute);
            }

        } else {
            singsingFee = SINGSING.getBasicFee();

            if (usingTime > SINGSING.basicMinute) {
                singsingFee = singsingFee + SINGSING.perMinuteFee * (usingTime - SINGSING.basicMinute);
            }
        }


        return singsingFee;
    }

    /*private boolean isSingSingNight() {
        if (LocalTime.now().getHour() >= 0 && LocalTime.now().getHour() < 6) {
            return true;
        }

        return false;
    }*/

    public long getSwingFee(long usingTime) {
        long swingFee;
        int nowHour = getNowHour();

        if (isNight(nowHour,SWING)) {
            swingFee = SWINGNIGHT.getBasicFee();

            if (usingTime > SWINGNIGHT.basicMinute) {
                swingFee = swingFee + SWINGNIGHT.perMinuteFee * (usingTime - SWINGNIGHT.basicMinute);
            }

        } else {
            swingFee = SWING.getBasicFee();

            if (usingTime > SWING.basicMinute) {
                swingFee = swingFee + SWING.perMinuteFee * (usingTime - SWING.basicMinute);
            }
        }
        return (long) (swingFee * (0.6));
    }

    /*private boolean isSwingNight(int hour) {
        if (hour >= 21 || hour < 6) {
            return true;
        }

        return false;
    }*/

    public long getLimeFee(long usingTime) {

        long limeFee = LIME.getBasicFee();

        if (usingTime > LIME.basicMinute) {
            limeFee = limeFee + LIME.perMinuteFee * (usingTime - LIME.basicMinute);
        }
        return limeFee;
    }

    public long getGcooterFee(long usingTime) {

        long gcooterFee;
        int nowHour = getNowHour();


        if (isNight(nowHour, GCOOTER)) {
            gcooterFee = GCOOTERNIGHT.getBasicFee();

            if (usingTime > GCOOTERNIGHT.basicMinute) {
                gcooterFee = gcooterFee + GCOOTERNIGHT.perMinuteFee * (usingTime - GCOOTERNIGHT.basicMinute);
            }

        } else {
            gcooterFee = GCOOTER.getBasicFee();

            if (usingTime > GCOOTER.basicMinute) {
                gcooterFee = gcooterFee + GCOOTER.perMinuteFee * (usingTime - GCOOTER.basicMinute);
            }
        }

        return gcooterFee;

    }



    public boolean isNight(int hour, KickboardCompany company) {

        switch (company) {
            case GCOOTER:
                if (hour >= 0 && hour < 5) {
                    System.out.println("isNight true");
                    return true;
                }
                break;
            case SWING:
                if (hour >= 21 || hour < 6) {
                    System.out.println("isNight true");
                    return true;
                }
                break;
            case SINGSING:
                if (hour >= 0 && hour < 6) {
                    System.out.println("isNight true");
                    return true;
                }
                break;
        }

        return false;
    }

    public int getNowHour() {
        System.out.println("LocalTime.now().getHour() = " + LocalTime.now().getHour());
        return 3;

    }

    public KickboardDto getAllFee(long usingTime) {

        long kickGoingFee = getKickGoingFee(usingTime);
        long singSingFee = getSingSingFee(usingTime);
        long swingFee = getSwingFee(usingTime);
        long limeFee = getLimeFee(usingTime);
        long gcooterFee = getGcooterFee(usingTime);

        KickboardDto kickboardDto = KickboardDto.builder()
                .kickGoingFee(kickGoingFee)
                .singSingFee(singSingFee)
                .swingFee(swingFee)
                .limeFee(limeFee)
                .gCooterFee(gcooterFee)
                .estimatedTime(usingTime)
                .build();

        return kickboardDto;
    }
}
