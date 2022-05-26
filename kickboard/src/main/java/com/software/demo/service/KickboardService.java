package com.software.demo.service;

import com.software.demo.kickboard.KickboardDto;
import com.software.demo.kickboard.KickboardFeeCalculator;
import com.software.demo.kickboard.KickboardTime;
import org.springframework.stereotype.Service;

@Service
public class KickboardService {

    public KickboardDto getAllFee(long estimatedTime) {
        KickboardFeeCalculator kickboardFeeCalculator = new KickboardFeeCalculator();
        KickboardDto kickboardDto = kickboardFeeCalculator.getAllFee(estimatedTime);
        return kickboardDto;
    }

    public KickboardTime changeToEstimatedTime(Double distance) {
        KickboardTime kickboardTime = new KickboardTime(distance);
        return kickboardTime;
    }
}
