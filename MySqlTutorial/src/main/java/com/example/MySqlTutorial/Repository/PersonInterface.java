package com.example.MySqlTutorial.Repository;

import com.example.MySqlTutorial.Model.Person;
import org.hibernate.validator.internal.engine.resolver.JPATraversableResolver;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonInterface extends JpaRepository<Person, Integer> {

}
