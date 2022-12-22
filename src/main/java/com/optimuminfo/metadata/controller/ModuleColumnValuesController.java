package com.optimuminfo.metadata.controller;

import java.util.List;
import com.optimuminfo.metadata.entity.ModuleColumnValues;
import com.optimuminfo.metadata.service.ModuleColumnValuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
@RestController
public class ModuleColumnValuesController {

    @Autowired
    private ModuleColumnValuesService service;

    @PostMapping("/addModuleColumnValues")
    @ResponseStatus(HttpStatus.CREATED)
    public ModuleColumnValues addModule(@RequestBody ModuleColumnValues module) {
        return service.saveModule(module);
    }

    @GetMapping("/modulesColumnValues")
    public List<ModuleColumnValues> findAllModules(){
        return service.getModules();
    }

    @GetMapping("/moduleColumnValuesById/{id}")
    public ResponseEntity<ModuleColumnValues> findModuleById(@PathVariable int id){
        return service.findModuleById(id)
                .map(ResponseEntity :: ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/updateModuleColumnValues/{id}")
    public ResponseEntity<ModuleColumnValues> updateModule(@PathVariable("id") int id,
                                                @RequestBody ModuleColumnValues module) {
        return service.findModuleById(id).map(
                savedModule->{
                    savedModule.setModule_column_value_id(id);
                    savedModule.setModule_column_id(module.getModule_column_id());
                    savedModule.setModule_colum_key(module.getModule_colum_key());
                    savedModule.setModule_column_key_value(module.getModule_column_key_value());
                    ModuleColumnValues updateModule = service.updateModule(savedModule);
                    return new ResponseEntity<>(updateModule, HttpStatus.OK);
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deleteModuleColumnValues/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        service.deleteModule(id);
        return new ResponseEntity<String>("Module Column Values deleted successfully!.", HttpStatus.OK);
    }
}
