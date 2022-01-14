package org.springframework.samples.petclinic.vacination;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface VaccinationRepository extends CrudRepository<Vaccination,String> {
    
	List<Vaccination> findAll();
    @Query("SELECT vaccine FROM Vaccine vaccine ORDER BY vaccine.name")
    List<Vaccine> findAllVaccines();
    Optional<Vaccination> findById(int id);
    Vaccination save(Vaccination p);
    @Query("SELECT vaccine FROM Vaccine vaccine WHERE vaccine.name =:name")
    Vaccine getVaccine(String name);
}
