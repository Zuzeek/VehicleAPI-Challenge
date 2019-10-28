package uk.co.app.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uk.co.app.model.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

	List<Vehicle> findByColourStartingWith(String colour);
	List<Vehicle> findByValueGreaterThanEqual(Double value);
	List<Vehicle> findByValueLessThanEqual(Double value);
	List<Vehicle> findByBrandStartingWith(String brand);
	
}
