package com.APPJAVAFSTELEARNINservice;


import com.APPJAVAFSTELEARNIN.entity.Lecon;
import com.APPJAVAFSTELEARNIN.entity.Module;
import com.APPJAVAFSTELEARNIN.repository.LeconRepository;
import com.APPJAVAFSTELEARNIN.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleService {

    @Autowired
    private LeconRepository leconRepository;

    @Autowired
    private ModuleRepository moduleRepository;

    public Module creerModule(Module module) {
        return moduleRepository.save(module);
    }

    public List<Lecon> listerParModule(Long moduleId) {
        Module module = moduleRepository.findById(moduleId).orElseThrow();
        return leconRepository.findByModule(module);
    }

	public void creerModule(Module module, Long coursId) {
		// TODO Auto-generated method stub
		
	}


}