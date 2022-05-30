package com.software.demo.controller;

import com.software.demo.kickboard.KickboardDto;
import com.software.demo.service.KickboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class KickboradController {

    private final KickboardService kickboardService;

    @GetMapping("/")
    public String kickboard(Model model) {

        return "main";
    }

    @PostMapping("/")
    @ResponseBody
    public KickboardDto kickboardFee(@RequestParam String distanceStr) {

        Double distance = Double.parseDouble(distanceStr);
        long usingTime = kickboardService.getUsingTime(distance);
        KickboardDto kickboardDto = kickboardService.getAllFee(usingTime);

        return kickboardDto;
    }
}


/*model.addAttribute("kickGoingFee",fees.get("kickGoing"));
        model.addAttribute("singSingFee",fees.get("singSing"));
        model.addAttribute("swingFee",fees.get("swing"));
        model.addAttribute("limeFee",fees.get("lime"));
        model.addAttribute("gcooterFee",fees.get("gcooter"));
        */