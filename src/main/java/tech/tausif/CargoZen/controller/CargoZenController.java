package tech.tausif.CargoZen.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tech.tausif.CargoZen.service.AiService;

@Controller
public class CargoZenController {


    @Autowired
    private AiService aiService;

    @RequestMapping(value = {"/", "/index". "/home"})
    public String home(){
        return "index";
    }
}
