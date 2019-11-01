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
	public List<Vehicle> filterVehicles(String brand, String colour, Double value, Boolean higher) {
		List<Vehicle> filteredVehicles = getVehicleByBrand(brand); 
		
		if(!colour.equals("")) {
			filteredVehicles = filterVehicleByColour(filteredVehicles, colour); 
		}
		
		if(!value.equals(0.00)) {
			filteredVehicles = filterVehicleByValue(filteredVehicles, value, higher); 
		}

		return filteredVehicles; 
	}
	
	public List<Vehicle> filterVehicleByValue(List<Vehicle> vehicles, Double value, Boolean higher) {
		List<Vehicle> vehiclesToReturn = new ArrayList<>(); 
		
		if(higher) {
			for(Vehicle vehicle: vehicles) {
				if(vehicle.getValue() > value) {
					vehiclesToReturn.add(vehicle);
				}
			}
		}
		else {
			for(Vehicle vehicle: vehicles) {
				if(vehicle.getValue() < value) {
					vehiclesToReturn.add(vehicle);
				}
			}
		}
		return vehiclesToReturn; 
	}

	public List<Vehicle> filterVehicleByColour(List<Vehicle> vehicles, String colour){
		List<Vehicle> vehiclesToReturn = new ArrayList<>();
		
		for(Vehicle vehicle: vehicles) {	
			if((vehicle.getColour()).startsWith(colour)) {
				vehiclesToReturn.add(vehicle); 
			}
		}
		return vehiclesToReturn; 
	}
}
