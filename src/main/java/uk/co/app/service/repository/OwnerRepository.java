package uk.co.app.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uk.co.app.model.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Integer>{

}
