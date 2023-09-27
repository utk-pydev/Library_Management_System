package com.example.MySqlTutorial.Model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Person {

    @Id
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String dob;
}
