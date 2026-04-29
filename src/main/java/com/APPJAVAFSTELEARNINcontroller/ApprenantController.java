package com.APPJAVAFSTELEARNINcontroller;

import com.APPJAVAFSTELEARNIN.entity.*;
import com.APPJAVAFSTELEARNINservice.InscriptionService;
import com.APPJAVAFSTELEARNINservice.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/apprenant")
public class ApprenantController {
	
    @Autowired
    private InscriptionService inscriptionService;

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/dashboard")
    public String dashboard(Model model, Principal principal) {
        Utilisateur apprenant = utilisateurService
            .findByEmail(principal.getName());
        model.addAttribute("mesCours", 
            inscriptionService.getMesCours(apprenant.getId()));
        return "apprenant/dashboard";
    }

    @PostMapping("/inscrire/{coursId}")
    public String inscrire(@PathVariable Long coursId, 
                           Principal principal) {
        Utilisateur apprenant = utilisateurService
            .findByEmail(principal.getName());
        inscriptionService.inscrire(apprenant.getId(), coursId);
        return "redirect:/apprenant/mes-cours";
    }

    @GetMapping("/mes-cours")
    public String mesCours(Model model, Principal principal) {
        Utilisateur apprenant = utilisateurService
            .findByEmail(principal.getName());
        model.addAttribute("inscriptions", 
            inscriptionService.getMesCours(apprenant.getId()));
        return "apprenant/mes-cours";
    }
}