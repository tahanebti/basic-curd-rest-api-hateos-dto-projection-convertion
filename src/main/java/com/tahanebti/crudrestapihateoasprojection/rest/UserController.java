package com.tahanebti.crudrestapihateoasprojection.rest;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static java.util.stream.Collectors.toList;

import com.tahanebti.crudrestapihateoasprojection.domain.User;
import com.tahanebti.crudrestapihateoasprojection.dto.UserDto;
import com.tahanebti.crudrestapihateoasprojection.dto.UserProjection;
import com.tahanebti.crudrestapihateoasprojection.repository.UserRepository;



@RequiredArgsConstructor
@RepositoryRestController
@RequestMapping("/users")
public class UserController {

	   @NonNull private final UserRepository repo;
	   @NonNull private final RepositoryEntityLinks links;
	   @NonNull private final PagedResourcesAssembler<UserProjection> assembler;
	   
	   @GetMapping("/{id}/dto")
	    public ResponseEntity<?> getDto(@PathVariable("id") Integer UserId) {
	        UserProjection dto = repo.getDto(UserId);
	        
	        return ResponseEntity.ok(toResource(dto));
	    }
	    
	    @GetMapping("/dto")
	    public ResponseEntity<?> getDtos() {
	        List<UserProjection> dtos = repo.getDtos();
	        
	        Link listSelfLink = links.linkFor(User.class).slash("/dto").withSelfRel();
	        List<?> resources = dtos.stream().map(this::toResource).collect(toList());
	    
	        return ResponseEntity.ok(new Resources<>(resources, listSelfLink));
	    }
	    
	    @GetMapping("/dtoPaged")
	    public ResponseEntity<?> getDtosPaged(Pageable pageable) {
	        Page<UserProjection> dtos = repo.getDtos(pageable);
	        
	        Link pageSelfLink = links.linkFor(User.class).slash("/dtoPaged").withSelfRel();
	        PagedResources<?> resources = assembler.toResource(dtos, this::toResource, pageSelfLink);
	        
	        return ResponseEntity.ok(resources);
	    }
	   
	   
	    private ResourceSupport toResource(UserProjection projection) {
	        UserDto dto = new UserDto(projection.getUser(), projection.getName());
	        
	        Link UserLink = links.linkForSingleResource(projection.getUser()).withRel("user");
	        Link selfLink = links.linkForSingleResource(projection.getUser()).slash("/dto").withSelfRel();
	        
	        return new Resource<>(dto, UserLink, selfLink);
	    }
	   
	   
}
