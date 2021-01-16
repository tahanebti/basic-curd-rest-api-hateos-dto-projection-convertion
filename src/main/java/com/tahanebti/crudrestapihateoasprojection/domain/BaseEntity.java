package com.tahanebti.crudrestapihateoasprojection.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Version;

import org.springframework.hateoas.Identifiable;

import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor(force = true)
@Entity
@Inheritance(strategy = InheritanceType	.TABLE_PER_CLASS)
public class BaseEntity implements Identifiable<Long>{
	
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private final Long id;

    @Version
    private Long version;
	
    @Override
    public String toString() {
        return "(id=" + this.getId() + ")";
    }

}
