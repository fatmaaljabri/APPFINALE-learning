package com.APPJAVAFSTELEARNINcontroller;

import com.APPJAVAFSTELEARNIN.entity.Utilisateur;
import com.APPJAVAFSTELEARNIN.entity.Role;
import com.APPJAVAFSTELEARNINservice.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        model.addAttribute("roles", Role.values());
        return "auth/register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Utilisateur utilisateur) {
        utilisateurService.inscrireNouvelUtilisateur(utilisateur);
        return "redirect:/auth/login?registered=true";
    }
}