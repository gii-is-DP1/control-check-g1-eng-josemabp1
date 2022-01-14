package org.springframework.samples.petclinic.vacination;

import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import org.springframework.stereotype.Component;

@Component
public class VaccineFormatter implements Formatter<Vaccine> {

	@Autowired
	private VaccinationService vaService;
	
    @Override
    public String print(Vaccine object, Locale locale) {
        return object.getName();
    }

    @Override
    public Vaccine parse(String text, Locale locale) throws ParseException {
    	List<Vaccine> findVaccines = this.vaService.getAllVaccines();
		for (Vaccine v : findVaccines) {
			if (v.getName().equals(text)) {
				return v;
			}
		}
		throw new ParseException("Pet not found: " + text, 0);
    }
    
}
