package uk.co.app.service.interfaces;

import java.util.List;
import java.util.Optional;
import uk.co.app.model.Vehicle;

public interface VehicleService {
	
	public List<Vehicle> getAllVehicles(); 
	public Vehicle addVehicle(Vehicle vehicle); 
	public Vehicle saveVehicle(Vehicle vehicle); 
	public Vehicle updateVehicle(Vehicle vehicle); 
	public Optional<Vehicle> getVehicleById(int vehicleId);
	
	public List<Vehicle> getVehicleByColour(String colour); 
	public List<Vehicle> getVehicleByHigherValue(Double value);
	public List<Vehicle> getVehicleByLowerValue(Double value); 
	
	public List<Vehicle> getVehicleByBrand(String brand);
	
	public void removeVehicleById(int vehicleId);
	
	public List<Vehicle> filterVehicles(String colour, String brand, Double value, Boolean higher);
	
}
