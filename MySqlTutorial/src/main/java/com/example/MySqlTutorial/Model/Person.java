package com.example.MySqlTutorial.Model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String dob;
}
