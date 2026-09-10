package tech.tausif.CargoZen.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tech.tausif.CargoZen.beans.Customer;
import tech.tausif.CargoZen.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public String register(@ModelAttribute Customer customer, RedirectAttributes ra){
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        customer.setPassword(bcrypt.encode(customer.getPassword()));
        if(customerService.register(customer)){
            ra.addFlashAttribute("msg", "Customer Registered Successfully!");
            return "redirect:/customer/customer-dashboard";
        }else{
            ra.addFlashAttribute("msg", "Customer Email Already Exist");
            return "redirect:/register";
        }
    }
}
