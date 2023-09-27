package com.example.MySqlTutorial.Model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Person {

    @Id
    private int id;
    @Column(name = "first_name", length = 30)
    private String firstName;
    private String lastName;
    private int age;
    private String dob;
    @Transient
    private String countryCode;
}
