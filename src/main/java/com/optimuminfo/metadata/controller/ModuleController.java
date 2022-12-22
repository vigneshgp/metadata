package com.optimuminfo.metadata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.optimuminfo.metadata.entity.Modules;
import com.optimuminfo.metadata.service.ModuleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class ModuleController {

	@Autowired
	private ModuleService service;
	
	@PostMapping("/addModule")
	@ResponseStatus(HttpStatus.CREATED)
	public Modules addModule(@RequestBody Modules module) {
		return service.saveModule(module);
	}
	
	@GetMapping("/modules")
	public List<Modules> findAllModules(){
		return service.getModules();
	}
	
	@GetMapping("/moduleById/{id}")
	public ResponseEntity<Modules> findModuleById(@PathVariable int id){
		return service.findModuleById(id)
        		.map(ResponseEntity :: ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@PutMapping("/updateModule/{id}")
	 public ResponseEntity<Modules> updateModule(@PathVariable("id") int id,
				@RequestBody Modules module) {
		return service.findModuleById(id).map(
				savedModule->{
					savedModule.setModule_id(id);
					savedModule.setModule_name(module.getModule_name());
					Modules updateModule = service.updateModule(savedModule);
					return new ResponseEntity<>(updateModule, HttpStatus.OK);
				}).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        service.deleteModule(id);
        return new ResponseEntity<String>("Module deleted successfully!.", HttpStatus.OK);
    }
	
}
