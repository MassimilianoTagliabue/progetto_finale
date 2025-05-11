package org.lessons.java.progetto_finale.controllers;

import org.lessons.java.progetto_finale.service.VideogameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/videogame")
public class VideogameController {

    @Autowired
    private VideogameService videogameService;
    
    @GetMapping("")
    public String index(Authentication authentication, Model model) {
        
        model.addAttribute("videogames", videogameService.findAll());
        model.addAttribute("username", authentication.getName());
        return "videogames/index";
    }

    @GetMapping("/search")
    public String searchByTitle(@RequestParam(name = "title") String title, Model model) {
        
        model.addAttribute("videogames", videogameService.findByTitle(title));
        return "videogames/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Integer id, Model model) {

        model.addAttribute("videogame", videogameService.getById(id));
        return "videogames/show";
    }
    
    


    
}
