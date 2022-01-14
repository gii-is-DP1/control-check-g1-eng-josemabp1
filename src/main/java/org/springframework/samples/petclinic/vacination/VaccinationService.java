package org.springframework.samples.petclinic.vacination;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.pet.Pet;
import org.springframework.samples.petclinic.pet.exceptions.DuplicatedPetNameException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VaccinationService {
	
	@Autowired
	private VaccinationRepository vacRepo;
	
    public List<Vaccination> getAll(){
        return vacRepo.findAll();
    }

    public List<Vaccine> getAllVaccines(){
        return vacRepo.findAllVaccines();
    }

    public Vaccine getVaccine(String typeName) {
        return vacRepo.getVaccine(typeName);
    }
    
    @Transactional(rollbackFor = DuplicatedPetNameException.class)
    public Vaccination save(Vaccination p, Pet pet) throws UnfeasibleVaccinationException, DuplicatedPetNameException {
    	Boolean otherPetType = p.getVaccinatedPet().getType() != pet.getType();
        if (otherPetType = true) {            	
        	throw new DuplicatedPetNameException();
        }else
            return vacRepo.save(p);  
    	}
}

    
