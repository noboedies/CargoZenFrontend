package tech.tausif.CargoZen.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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

    @RequestMapping("/PredictVehicle")
    public String predictVehicle(@RequestParam String weight,
                                 @RequestParam String width,
                                 @RequestParam String length,
                                 @RequestParam String height,
                                 RedirectAttributes ra){
        String sys_prompt = """
                Act as Logistic Vehicle Assigner.
                You will be provided with weight, height, length and\s
                width of the product,\s
                you have to suggest the vehicle type using the standard formula used by industries standard..
                Vehicle type must be strictly from the following vehicle only.
                Vehicle list: Bike, Cargo Auto, Mini Truck, Truck.
                """;
        String user_prompt = "Here is the product dimensions: "+weight+" , width: "+width+" , height: "+height+" , length: "+height;
        String result = aiService.askAi(sys_prompt, user_prompt);
        ra.addFlashAttribute("result", result);
        return "redirect:/";
    }
}
