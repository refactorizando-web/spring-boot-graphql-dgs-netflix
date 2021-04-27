package com.refactorizando.samples.dgs.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    private String firstName;

    private String lastName;

    private int age;

    private String address;

    private String country;

    private String city;

    @OneToMany(mappedBy = "user")
    private Set<Account> accounts;

    @ManyToOne()
    private Bank bank;
}
