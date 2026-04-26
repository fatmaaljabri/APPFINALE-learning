package com.APPJAVAFSTELEARNINcontroller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/formateur")
public class FormateurController {

    @GetMapping("/dashboard")
    public String dashboard() {
        return "formateur/dashboard";
    }}
