package SE9.SEproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Map {

    @GetMapping("/")
    public String map() {
        return "test";
    }
}
