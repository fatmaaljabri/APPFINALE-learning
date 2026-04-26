package com.APPJAVAFSTELEARNINcontroller;


import com.APPJAVAFSTELEARNINservice.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CatalogueController {

    @Autowired
    private CoursService coursService;

    @GetMapping("/cours")
    public String catalogue(Model model, Pageable pageable) {
        model.addAttribute("cours", coursService.getCataloguePublic(pageable));
        return "catalogue";
    }

    @GetMapping("/cours/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("coursId", id);
        return "cours-detail";
    }}
    
