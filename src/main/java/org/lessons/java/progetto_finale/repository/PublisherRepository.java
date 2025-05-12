package org.lessons.java.progetto_finale.repository;

import java.util.List;

import org.lessons.java.progetto_finale.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Integer>{
    
    public List<Publisher> findByNameContaining(String name);
}
