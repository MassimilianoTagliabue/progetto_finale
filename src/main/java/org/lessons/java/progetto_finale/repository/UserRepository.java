package org.lessons.java.progetto_finale.repository;

import java.util.Optional;

import org.lessons.java.progetto_finale.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{

    Optional<User> findByUsername(String username);
    
}
