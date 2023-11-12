package com.example.webSecurityTutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    MyUserRepository myUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return myUserRepository.findByEmail(username);
    }

    public void createUser(MyUser myUser) throws DuplicateKeyException{
        try {
            myUserRepository.save(myUser);
        }catch (DuplicateKeyException e){
            throw new DuplicateKeyException(Objects.requireNonNull(e.getMessage()));
        }
    }
}
