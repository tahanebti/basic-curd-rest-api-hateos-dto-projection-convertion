package com.tahanebti.crudrestapihateoasprojection.domain;

import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@ToString(callSuper = true)
@Entity
public class User extends BaseEntity {
    private final String name;
}