package com.optimuminfo.metadata.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.optimuminfo.metadata.entity.Modules;
import com.optimuminfo.metadata.repository.ModuleRepository;

@Service
public class ModuleService {
	
	@Autowired
	private ModuleRepository repository;
	
	public Modules saveModule(Modules module) {
		return repository.save(module);
	}

	public List<Modules> getModules() {
		return repository.findAll();
	}

	public Optional<Modules> findModuleById(int moduleId) {
		return repository.findById(moduleId);
	}

	public Modules updateModule(Modules module) {
		return repository.save(module);
	}

	public void deleteModule(int moduleId) {
		repository.deleteById(moduleId);
	}

}
