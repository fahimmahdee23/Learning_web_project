
package com.example.learning_web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PhysicsController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/calculate")
    public String calculate(
            @RequestParam double voltage,
            @RequestParam double resistance,
            Model model) {

        if (resistance <= 0 || voltage < 0) {
            model.addAttribute("error", "Enter valid values.");
            return "index";
        }

        double current = voltage / resistance;

        model.addAttribute("voltage", voltage);
        model.addAttribute("resistance", resistance);
        model.addAttribute("current", current);

        return "index";
    }
}
