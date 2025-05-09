package org.lessons.java.progetto_finale.repository;

import org.lessons.java.progetto_finale.model.Videogame;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface VideogameRepository extends JpaRepository<Videogame,Integer>{
    
    public List<Videogame> findByTitleContaining(String title);
}
