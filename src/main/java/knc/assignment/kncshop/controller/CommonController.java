package knc.assignment.kncshop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class CommonController {

    @GetMapping("/")
    public String homeController() {
        log.info("Home Controller");
        return "/index";
    }
}