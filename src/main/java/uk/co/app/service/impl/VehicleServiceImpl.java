package uk.co.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.co.app.model.Vehicle;
import uk.co.app.service.interfaces.VehicleService;
import uk.co.app.service.repository.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;  
	
	@Override
	public List<Vehicle> getAllVehicles() {
		return vehicleRepository.findAll(); 
	}
	
	@Override
	public Vehicle saveVehicle(Vehicle vehicle) {
		return vehicleRepository.save(vehicle); 
	}
	
	@Override
	public Optional<Vehicle> getVehicleById(int vehicleId) {
		return vehicleRepository.findById(vehicleId);
	}
	
	@Override
	public Vehicle addVehicle(Vehicle vehicle) {
		return saveVehicle(vehicle); 
	}

	@Override
	public Vehicle updateVehicle(Vehicle vehicle) {
		return saveVehicle(vehicle); 
	}

	@Override
	public void removeVehicleById(int vehicleId) {
		vehicleRepository.deleteById(vehicleId);
	}

	@Override
	public List<Vehicle> getVehicleByColour(String colour) {
		return vehicleRepository.findByColourStartingWith(colour);
	}
	
	@Override
	public List<Vehicle> getVehicleByBrand(String brand) {
		return vehicleRepository.findByBrandStartingWith(brand);
	}

	@Override
	public List<Vehicle> getVehicleByHigherValue(Double value) {
		return vehicleRepository.findByValueGreaterThanEqual(value);
	}

	@Override
	public List<Vehicle> getVehicleByLowerValue(Double value) {
		return vehicleRepository.findByValueLessThanEqual(value);
		
	}

	@Override
	public List<Vehicle> filterVehicles(String colour, String brand) {
		List<Vehicle> vehicles = vehicleRepository.findByBrandStartingWith(brand); 
		List<Vehicle> vehiclesToReturn = new ArrayList<>();
		
		if(!colour.equals("")) {
			for(Vehicle vehicle: vehicles) {
				
				if((vehicle.getColour()).startsWith(colour)) {
					vehiclesToReturn.add(vehicle); 
				}
			}
			return vehiclesToReturn;
		}
		return vehicles; 
	}
}
