package uk.co.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.co.app.model.Owner;
import uk.co.app.service.interfaces.OwnerService;
import uk.co.app.service.repository.OwnerRepository;

@Service
public class OwnerServiceImpl implements OwnerService {

	@Autowired 
	private OwnerRepository ownerRepository; 
	
	@Override
	public Owner addOwner(Owner owner) {
		return saveOwner(owner);
	}

	private Owner saveOwner(Owner owner) {
		return ownerRepository.save(owner); 
	}

	@Override
	public Owner updateOwner(Owner owner) {
		return saveOwner(owner);
	}

	@Override
	public List<Owner> getAllOwners() {
		return ownerRepository.findAll();
	}

	@Override
	public Optional<Owner> getOwnerById(int ownerId) {
		return ownerRepository.findById(ownerId); 
	}

	@Override
	public void removeOwnerById(int ownerId) {
		ownerRepository.deleteById(ownerId);
	}

}
