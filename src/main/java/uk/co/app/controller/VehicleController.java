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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uk.co.app.model.Vehicle;
import uk.co.app.service.interfaces.VehicleService;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService; 
	
	// Get All Vehicles
	@GetMapping
	public List<Vehicle> getAllVehicles(){
		return vehicleService.getAllVehicles(); 
	}
	
	// Get a Single Vehicle
	@GetMapping("/{id}")
	public Optional<Vehicle> searchVehicleById(@PathVariable(value = "id") int vehicleId) {
		return vehicleService.getVehicleById(vehicleId);
	}
	
	// Get a Vehicle by: brand, colour -> filter method
	@GetMapping("/filter")
	public List<Vehicle> searchVehiclesByFilters( 
			@RequestParam(value = "brand", defaultValue = "") String brand, 
			@RequestParam(value = "colour", defaultValue = "") String colour,
			@RequestParam(value = "value", defaultValue = "0.00") Double value,
			@RequestParam(value = "higher", defaultValue = "") Boolean higher) {
		
		return vehicleService.filterVehicles(brand, colour, value, higher); 
	}
	
    // Create a new Vehicle
	@PostMapping
	public Vehicle createVehicle(@Valid @RequestBody Vehicle vehicle) {
		return vehicleService.addVehicle(vehicle); 
	}
	
    // Update a Vehicle
	@PutMapping("/{id}")
	public Vehicle updateVehicle(@Valid @RequestBody Vehicle vehicle) {
		return vehicleService.updateVehicle(vehicle); 
	}
	
    // Delete a Vehicle 
	@DeleteMapping("/{id}")
	public void deleteVehicle(@PathVariable(value = "id") int vehicleId) { 
		vehicleService.removeVehicleById(vehicleId);
	}
}
