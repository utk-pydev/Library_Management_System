package com.example.MySqlTutorial.Model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Person {

    /*
    *
    * Difference b/w Identity and Auto
    *
    * Identity
    * The table is created by sql command for auto increment
    * Auto
    * The table is created without auto increment
    *
    *
     AUTO -
     create table person(id int primary key, ....)
     insert into person(id, name, ...) VALUES (<ID>, <name>, ....)
     First it begins transaction  acquires a Lock For update then updates the values for a row
     *
     * IDENTITY -
     create table person(id int primary key auto_increment, ..... )
     insert into person(name, ...) VALUES (<name>, ...)
    *
    * */


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name", length = 30)
    private String firstName;
    private String lastName;
    private int age;
    private String dob;
    /*
    * Three types of columns in hibernate
    *
    * Detached - A detached instance is an object that has been persistent, but its Session has been closed.
    *
    * Persistent - An object that has a database identity associated with it is called a persistent object.
    *
    * Transient - Objects instantiated using the new operator are called transient objects.
    *  */
    @Transient
    private String countryCode;
}
