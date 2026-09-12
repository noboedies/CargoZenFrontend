package tech.tausif.CargoZen.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tech.tausif.CargoZen.beans.Driver;
import tech.tausif.CargoZen.service.DriverService;

import java.io.IOException;

@Controller
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping("/register")
    public String register(@ModelAttribute Driver driver, @RequestPart MultipartFile lic, @RequestPart MultipartFile rc, RedirectAttributes ra) throws IOException {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        driver.setPassword(bcrypt.encode(driver.getPassword()));
        driver.setVehicle_rc(rc.getBytes());
        driver.setDriving_license(lic.getBytes());
        if(driverService.register(driver)) {
            ra.addFlashAttribute("msg", "Driver Registered Successfully but Wait for Admin approval! ");
            return "redirect:/";
        }else {
            ra.addFlashAttribute("msg", "Driver Email Already Exist!");
            return "redirect:/register";
        }
    }
}
