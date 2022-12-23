package com.optimuminfo.metadata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.optimuminfo.metadata.entity.ModuleColumns;
import com.optimuminfo.metadata.service.ModuleColumnsService;

@RestController
public class ModuleColumnsController {
	
	@Autowired
	private ModuleColumnsService service;
	
	@PostMapping("/addModuleColumns")
    @ResponseStatus(HttpStatus.CREATED)
    public ModuleColumns addModuleColumn(@RequestBody ModuleColumns moduleColumn) {
        return service.saveModuleColumn(moduleColumn);
    }

    @GetMapping("/moduleColumns")
    public List<ModuleColumns> findAllModuleColumns(){
        return service.getModuleColumns();
    }

    @GetMapping("/moduleColumnById/{id}")
    public ResponseEntity<ModuleColumns> findModuleColumnById(@PathVariable int id){
        return service.findModuleColumnById(id)
                .map(ResponseEntity :: ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/updateModuleColumn/{id}")
    public ResponseEntity<ModuleColumns> updateModuleColumn(@PathVariable("id") int id,
                                                @RequestBody ModuleColumns moduleColumn) {
        return service.findModuleColumnById(id).map(
                savedModule->{
                    savedModule.setModule_column_id(id);
                    savedModule.setModule_column_id(moduleColumn.getModule_column_id());
                    savedModule.setModule_column_name(moduleColumn.getModule_column_name());
                    savedModule.setModule_column_data_type(moduleColumn.getModule_column_data_type());
                    savedModule.setModule_column_type(moduleColumn.getModule_column_type());;
                    ModuleColumns updateModule = service.updateModuleColumn(savedModule);
                    return new ResponseEntity<>(updateModule, HttpStatus.OK);
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deleteModuleColumn/{id}")
    public ResponseEntity<String> deleteModuleColumn(@PathVariable int id) {
        service.deleteModuleColumn(id);
        return new ResponseEntity<String>("Module Columns deleted successfully!.", HttpStatus.OK);
    }
	

}
