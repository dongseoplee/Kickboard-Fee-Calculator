package com.software.demo.kickboard;

import lombok.Getter;

@Getter
public enum KickboardCompany {

    KICKGOING(1000,100,5),

    SINGSING(1000,100,5), //심야 24 ~ 6
    SINGSINGNIGTH(2000,100,5), //심야 24 ~ 6

    SWING(1200,180,0), //심야 21 ~ 6    * 0.6
    SWINGNIGHT(1200,250,0), //심야 21 ~ 6

    LIME(1200,180,0),

    GCOOTER(300,130,1), //심야 24 ~ 5
    GCOOTERNIGHT(1000,130,1); //심야 24 ~ 5

    public final long basicFee;
    public final long perMinuteFee;
    public final long basicMinute;

    KickboardCompany(long basicFee, long perMinuteFee, long basicMinute) {
        this.basicFee = basicFee;
        this.perMinuteFee = perMinuteFee;
        this.basicMinute = basicMinute;
    }

}
