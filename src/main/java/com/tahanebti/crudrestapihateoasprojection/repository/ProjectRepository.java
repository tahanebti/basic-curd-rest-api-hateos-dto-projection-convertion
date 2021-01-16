package com.tahanebti.crudrestapihateoasprojection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.tahanebti.crudrestapihateoasprojection.domain.Project;

@RepositoryRestResource
public interface ProjectRepository  extends JpaRepository<Project, Long>{

}
