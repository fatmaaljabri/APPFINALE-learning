package com.APPJAVAFSTELEARNINcontroller;


import com.APPJAVAFSTELEARNIN.entity.Cours;
import com.APPJAVAFSTELEARNINservice.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/formateur/cours")
public class CoursController {

    @Autowired
    private CoursService coursService;

    @GetMapping
    public String list() {
        return "formateur/cours-list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("cours", new Cours());
        return "formateur/create-cours";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Cours cours,
                       @RequestParam("image") MultipartFile file) throws Exception {

        coursService.creer(cours, file);
        return "redirect:/formateur/cours";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        coursService.supprimer(id);
        return "redirect:/formateur/cours";
    }}