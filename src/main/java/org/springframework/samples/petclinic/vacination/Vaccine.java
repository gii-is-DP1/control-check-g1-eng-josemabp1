package org.springframework.samples.petclinic.vacination;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.PetType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "vaccines")
public class Vaccine extends BaseEntity {
	
	@Column(name = "name", unique = true)
	@Size(min = 3, max = 50)
	private String name;
	
	@Column(name = "price")
	@Min(0)
    private Double price;
    
    @ManyToOne(optional=false)
	@JoinColumn(name = "pet_type_id")
    @NotNull
	private PetType petType;
}
