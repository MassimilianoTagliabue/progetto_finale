package org.lessons.java.progetto_finale.security;

import java.util.Optional;

import org.lessons.java.progetto_finale.model.User;
import org.lessons.java.progetto_finale.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class DatabaseUserDetailService implements UserDetailsService{
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{

        Optional<User> userAttempt = userRepository.findByUsername(username);
        
        if(userAttempt.isEmpty()){
            throw new UsernameNotFoundException("utente non trovato");
        }

        return new DatabaseUserDetails(userAttempt.get());
    }
}
