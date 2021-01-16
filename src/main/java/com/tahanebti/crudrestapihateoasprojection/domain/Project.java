package com.tahanebti.crudrestapihateoasprojection.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;

@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@ToString(callSuper = true, exclude = "users")
@Entity
public class Project extends BaseEntity {
    
    private final String name;
    
    @OneToMany
    private final Set<User> users = new HashSet<>();
    
    public Project addUsers(User... users) {
        this.users.addAll(asList(users));
        return this;
    }
}