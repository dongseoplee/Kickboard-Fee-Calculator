package com.software.demo.kickboard;

import lombok.Setter;

import java.time.LocalTime;

import static com.software.demo.kickboard.KickboardCompany.*;

@Setter
public class KickboardFeeCalculator {


    public long getKickGoingFee(long minute) {
        long kickGoingFee = KICKGOING.getBasicFee();

        if (minute > KICKGOING.basicMinute) {
            kickGoingFee = kickGoingFee + KICKGOING.perMinuteFee * (minute - KICKGOING.basicMinute);
        }
        return kickGoingFee;
    }

    public long getSingSingFee(long minute) {
        long singsingFee;
        int nowHour = getNowHour();

        if (isNight(nowHour,SINGSING)) {
            singsingFee = SINGSINGNIGTH.getBasicFee();

            if (minute > SINGSINGNIGTH.basicMinute) {
                singsingFee = singsingFee + SINGSINGNIGTH.perMinuteFee * (minute - SINGSINGNIGTH.basicMinute);
            }

        } else {
            singsingFee = SINGSING.getBasicFee();

            if (minute > SINGSING.basicMinute) {
                singsingFee = singsingFee + SINGSING.perMinuteFee * (minute - SINGSING.basicMinute);
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

    public long getSwingFee(long minute) {
        long swingFee;
        int nowHour = getNowHour();

        if (isNight(nowHour,SWING)) {
            swingFee = SWINGNIGHT.getBasicFee();

            if (minute > SWINGNIGHT.basicMinute) {
                swingFee = swingFee + SWINGNIGHT.perMinuteFee * (minute - SWINGNIGHT.basicMinute);
            }

        } else {
            swingFee = SWING.getBasicFee();

            if (minute > SWING.basicMinute) {
                swingFee = swingFee + SWING.perMinuteFee * (minute - SWING.basicMinute);
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

    public long getLimeFee(long minute) {

        long limeFee = LIME.getBasicFee();

        if (minute > LIME.basicMinute) {
            limeFee = limeFee + LIME.perMinuteFee * (minute - LIME.basicMinute);
        }
        return limeFee;
    }

    public long getGcooterFee(long minute) {

        long gcooterFee;
        int nowHour = getNowHour();


        if (isNight(nowHour, GCOOTER)) {
            gcooterFee = GCOOTERNIGHT.getBasicFee();

            if (minute > GCOOTERNIGHT.basicMinute) {
                gcooterFee = gcooterFee + GCOOTERNIGHT.perMinuteFee * (minute - GCOOTERNIGHT.basicMinute);
            }

        } else {
            gcooterFee = GCOOTER.getBasicFee();

            if (minute > GCOOTER.basicMinute) {
                gcooterFee = gcooterFee + GCOOTER.perMinuteFee * (minute - GCOOTER.basicMinute);
            }
        }

        return gcooterFee;

    }



    public boolean isNight(int hour, KickboardCompany company) {

        switch (company) {
            case GCOOTER:
                if (hour >= 0 && hour < 5) {
                    return true;
                }
                break;
            case SWING:
                if (hour >= 21 || hour < 6) {
                    return true;
                }
                break;
            case SINGSING:
                if (hour >= 0 && hour < 6) {
                    return true;
                }
                break;
        }

        return false;
    }

    public int getNowHour() {
        return LocalTime.now().getHour();
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
