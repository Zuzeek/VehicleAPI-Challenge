package uk.co.app.service.interfaces;

import java.util.List;
import java.util.Optional;

import uk.co.app.model.Owner;

public interface OwnerService {
	
	public Owner addOwner(Owner owner); 
	public Owner updateOwner(Owner owner); 
	
	public List<Owner> getAllOwners();
	public Optional<Owner> getOwnerById(int ownerId);
	public void removeOwnerById(int ownerId); 
	
}
