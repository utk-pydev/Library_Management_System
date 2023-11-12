package com.example.webSecurityTutorial;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MyUserRepository extends JpaRepository<MyUser, Integer> {

    MyUser findByEmail(String email);
}
