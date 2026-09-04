package tech.tausif.CargoZen.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tech.tausif.CargoZen.service.AiService;

@Controller
public class CargoZenController {


    @Autowired
    private AiService aiService;

    @RequestMapping(value = {"/", "/index", "/home"})
    public String home(){
        return "index";
    }

    //role based or neutral login page.
    @GetMapping("/login")
    public String login(@RequestParam(required = false) String role){
        return "login";
    }

    //Role based or neutral signup Page;
    @GetMapping("/register")
    public String register(@RequestParam(required = false)String role){
        return "register";
    }

    @GetMapping("/book-shipment")
    public String bookShipment(){
        return "book-shipment";
    }

    @GetMapping("/shipments")
    public String shipments(){
        return "shipments";
    }

    @GetMapping("/shipment")
    public String shipment(){
        return "shipment";
    }

    @GetMapping("/customer-dashboard")
    public String customerDashboard(){
        return "customer-dashboard";
    }

    @GetMapping("/logout")
    public String logout(){
        return "redirect:/";
    }
}
