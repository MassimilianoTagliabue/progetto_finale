package org.lessons.java.progetto_finale.controllers;

import java.util.List;
import java.util.Optional;

import org.lessons.java.progetto_finale.model.Videogame;
import org.lessons.java.progetto_finale.service.VideogameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/videogame")
public class VideogameRestController {
    
    @Autowired
    private VideogameService videogameService;

    //index
    @GetMapping("")
    public List<Videogame> index(){
        return videogameService.findAll();
    }

    //show
    @GetMapping("/{id}")
    public ResponseEntity<Videogame> show(@PathVariable Integer id) {
        Optional<Videogame> videogame = videogameService.findById(id);

        if (videogame.isEmpty()) {
            return new ResponseEntity<Videogame>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Videogame>(videogame.get(), HttpStatus.OK);
    }

    //create
    @PostMapping("")
    public ResponseEntity<Videogame> create(@Valid @RequestBody Videogame videogame) {
        
        return new ResponseEntity<Videogame>(videogameService.createOrEdit(videogame), HttpStatus.OK);
    }

    //edit
    @PutMapping("/{id}")
    public ResponseEntity<Videogame> edit(@Valid @PathVariable Integer id, @RequestBody Videogame videogame) {
            
        if(videogameService.findById(id).isEmpty()){
            return new ResponseEntity<Videogame>(HttpStatus.NOT_FOUND);
        }

        videogame.setId(id);
        return new ResponseEntity<Videogame>(videogameService.createOrEdit(videogame), HttpStatus.OK);
    }

    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Videogame> delete(@Valid @PathVariable Integer id){

        if (videogameService.findById(id).isEmpty()) {
            return new ResponseEntity<Videogame>(HttpStatus.NOT_FOUND);
        }

        videogameService.deleteById(id);
        return new ResponseEntity<Videogame>(HttpStatus.OK);
    }
    
    
    
}
