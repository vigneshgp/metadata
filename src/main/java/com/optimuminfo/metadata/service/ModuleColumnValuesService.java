package com.optimuminfo.metadata.service;

import java.util.List;
import java.util.Optional;
import com.optimuminfo.metadata.entity.ModuleColumnValues;
import com.optimuminfo.metadata.repository.ModuleColumnValuesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModuleColumnValuesService {

    @Autowired
    private ModuleColumnValuesRepository repository;

    public ModuleColumnValues saveModule(ModuleColumnValues module) {
        return repository.save(module);
    }

    public List<ModuleColumnValues> getModules() {
        return repository.findAll();
    }

    public Optional<ModuleColumnValues> findModuleById(int moduleId) {
        return repository.findById(moduleId);
    }

    public ModuleColumnValues updateModule(ModuleColumnValues module) {
        return repository.save(module);
    }

    public void deleteModule(int moduleId) {
        repository.deleteById(moduleId);
    }
}
