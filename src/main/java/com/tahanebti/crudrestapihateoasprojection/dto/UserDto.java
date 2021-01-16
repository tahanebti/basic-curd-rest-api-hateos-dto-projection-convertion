package com.tahanebti.crudrestapihateoasprojection.dto;

import org.springframework.hateoas.core.Relation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tahanebti.crudrestapihateoasprojection.domain.User;

import lombok.Data;

@Data
@Relation(value = "user", collectionRelation = "users")
public class UserDto implements UserProjection{

	   @JsonIgnore
	    private final User user;
	    private final String name;
}
