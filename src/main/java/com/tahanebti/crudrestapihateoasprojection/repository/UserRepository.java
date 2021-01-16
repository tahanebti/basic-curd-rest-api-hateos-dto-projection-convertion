package com.tahanebti.crudrestapihateoasprojection.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.tahanebti.crudrestapihateoasprojection.domain.User;
import com.tahanebti.crudrestapihateoasprojection.dto.UserProjection;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {

	@RestResource(path = "byName", rel = "byName")
	Page<User> findByNameContainingIgnoreCase(@Param("name") String namePart, Pageable pageable);

	@RestResource(exported = false)
	@Query("select p as user, p.name as name from User p where p.id = ?1")
	UserProjection getDto(Long userId);

	@RestResource(exported = false)
	@Query("select p as user, p.name as name from User p")
	List<UserProjection> getDtos();

	@RestResource(exported = false)
	@Query("select p as user, p.name as name from User p")
	Page<UserProjection> getDtos(Pageable pageable);

}
