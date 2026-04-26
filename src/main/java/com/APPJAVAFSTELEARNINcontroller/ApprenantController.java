package com.APPJAVAFSTELEARNINcontroller;

import com.APPJAVAFSTELEARNINservice.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/apprenant")
public class ApprenantController {

    @Autowired
    private InscriptionService inscriptionService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("mesCours", inscriptionService.getMesCours(1L)); // TEMP user
        return "apprenant/dashboard";
    }
}


