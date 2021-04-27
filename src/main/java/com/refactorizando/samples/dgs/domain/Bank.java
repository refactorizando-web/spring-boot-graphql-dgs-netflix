package com.refactorizando.samples.dgs.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Bank {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private String country;

    @OneToMany(mappedBy = "bank")
    private Set<User> users;

    @OneToMany(mappedBy = "bank")
    private Set<Account> accounts;
}
