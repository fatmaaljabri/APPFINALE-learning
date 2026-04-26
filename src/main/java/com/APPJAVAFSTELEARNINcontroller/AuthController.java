package com.APPJAVAFSTELEARNINcontroller;


import com.APPJAVAFSTELEARNIN.entity.Utilisateur;
import com.APPJAVAFSTELEARNINservice.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new Utilisateur());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Utilisateur user) {
        utilisateurService.inscrireNouvelUtilisateur(user);
        return "redirect:/login";
    }}
