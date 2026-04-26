package com.APPJAVAFSTELEARNINcontroller;
import com.APPJAVAFSTELEARNIN.entity.Module;
import com.APPJAVAFSTELEARNINservice.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/formateur/modules")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

 

	@PostMapping("/create")
    public String create(Module module, @RequestParam Long coursId) {
        moduleService.creerModule(module, coursId);
        return "redirect:/formateur/cours";
    }}
