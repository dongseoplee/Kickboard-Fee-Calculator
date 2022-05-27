package com.software.demo.service;

import com.software.demo.kickboard.KickboardDto;
import com.software.demo.kickboard.KickboardFeeCalculator;
import com.software.demo.kickboard.KickboardTimeCalculator;
import org.springframework.stereotype.Service;

@Service
public class KickboardService {

    public KickboardDto getAllFee(long usingTime) {
        KickboardFeeCalculator kickboardFeeCalculator = new KickboardFeeCalculator();
        KickboardDto kickboardDto = kickboardFeeCalculator.getAllFee(usingTime);
        return kickboardDto;
    }

    public long getUsingTime(Double distance) {
        return KickboardTimeCalculator.calculateUsingTime(distance);

    }
}
