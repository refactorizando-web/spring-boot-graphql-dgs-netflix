package com.refactorizando.samples.dgs.domain.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserInput {

    private String firstName;

    private String lastName;

    private int age;

    private String address;

    private String country;

    private String city;
}
