package com.optimuminfo.metadata.service;

import java.util.List;
import java.util.Optional;
import com.optimuminfo.metadata.entity.ModuleColumns;
import com.optimuminfo.metadata.repository.ModuleColumnsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModuleColumnsService {
	
	@Autowired
	private ModuleColumnsRepository repository;
	
	public ModuleColumns saveModuleColumn(ModuleColumns moduleColumns) {
		return repository.save(moduleColumns);
	}
	
	public List<ModuleColumns> getModuleColumns() {
		return repository.findAll();
	}
	
	public Optional<ModuleColumns> findModuleColumnById(int moduleColumnId) {
		return repository.findById(moduleColumnId);
	}
	
	public ModuleColumns updateModuleColumn(ModuleColumns moduleColumn) {
		return repository.save(moduleColumn);
	}
	
	public void deleteModuleColumn(int moduleId) {
		repository.deleteById(moduleId);
	}
	

}
