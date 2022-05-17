package com.software.demo.controller;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@NoArgsConstructor
public class BasicController {

    @GetMapping("/")
    public String kickboard() {
        return "bootStrapTest";
    }
}
