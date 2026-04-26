package com.APPJAVAFSTELEARNINservice;


import com.APPJAVAFSTELEARNIN.entity.Lecon;
import com.APPJAVAFSTELEARNIN.entity.Module;
import com.APPJAVAFSTELEARNIN.repository.LeconRepository;
import com.APPJAVAFSTELEARNIN.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeconService {

    @Autowired
    private LeconRepository LeconRepository;

    @Autowired
    private ModuleRepository ModuleRepository;

    public Lecon creerLecon(Lecon lecon, Long moduleId) {
        Module module = ModuleRepository.findById(moduleId).orElseThrow();
        lecon.setModule(module);
        return LeconRepository.save(lecon);
    }

    public List<Lecon> listerParModule(Long moduleId) {
        Module module = ModuleRepository.findById(moduleId).orElseThrow();
        return LeconRepository.findByModule(module);
    }
}