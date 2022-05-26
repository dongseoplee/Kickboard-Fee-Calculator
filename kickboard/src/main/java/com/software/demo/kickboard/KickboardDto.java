package com.software.demo.kickboard;

import lombok.Builder;
import lombok.Setter;

@Setter
public class KickboardDto {
    public Long estimatedTime;
    public Long kickGoingFee;
    public Long singSingFee;
    public Long limeFee;
    public Long gCooterFee;
    public Long swingFee;



    @Builder
    public KickboardDto(Long kickGoingFee, Long singSingFee, Long limeFee, Long gCooterFee, Long swingFee, Long estimatedTime) {
        this.kickGoingFee = kickGoingFee;
        this.singSingFee = singSingFee;
        this.limeFee = limeFee;
        this.gCooterFee = gCooterFee;
        this.swingFee = swingFee;
        this.estimatedTime = estimatedTime;
    }
}
