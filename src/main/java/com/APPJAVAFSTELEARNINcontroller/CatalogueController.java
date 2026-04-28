package com.APPJAVAFSTELEARNINcontroller;

import com.APPJAVAFSTELEARNINservice.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CatalogueController {

    @Autowired
    private CoursService coursService;

    @GetMapping("/")
    public String home() {
        return "redirect:/cours";
    }

    @GetMapping("/cours")
    public String catalogue(Model model,
                            @PageableDefault(size = 6, sort = "dateCreation") Pageable pageable,
                            @RequestParam(required = false) String titre,
                            @RequestParam(required = false) String categorie,
                            @RequestParam(required = false) String niveau) {
        model.addAttribute("cours", coursService.getCataloguePublic(pageable));
        model.addAttribute("titre", titre);
        model.addAttribute("categorie", categorie);
        model.addAttribute("niveau", niveau);
        return "catalogue";
    }

    @GetMapping("/cours/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("cours", coursService.findById(id));
        return "cours-detail";
    }
}