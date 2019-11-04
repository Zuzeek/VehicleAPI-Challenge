package uk.co.app.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uk.co.app.model.Owner;
import uk.co.app.service.interfaces.OwnerService;

@RestController
@RequestMapping("/owners")
public class OwnerController {
	
	@Autowired
	private OwnerService ownerService; 
	
	// create owner 
	@PostMapping
	public Owner createOwner(@Valid @RequestBody Owner owner) {
		return ownerService.addOwner(owner);  
	}
	
	// update owner 
	@PutMapping("/{id}")
	public Owner updateOwner(@Valid @RequestBody Owner owner) {
		return ownerService.updateOwner(owner); 
	}
	
	// delete owner 
	@DeleteMapping("/{id}")
	public void deleteOwner(@PathVariable(value = "id") int ownerId) {
		ownerService.removeOwnerById(ownerId); 
	}
	
	// fetch all owners 
	@GetMapping
	public List<Owner> getAllOwners(){
		return ownerService.getAllOwners(); 
	}
	
	// fetch owner by id 
	@GetMapping("/{id}")
	public Optional<Owner> searchOwnerById(@PathVariable(value = "id") int ownerId) {
		return ownerService.getOwnerById(ownerId); 
	}
	
}
