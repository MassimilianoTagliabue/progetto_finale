package org.lessons.java.progetto_finale.controllers;

import org.lessons.java.progetto_finale.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/publisher")
public class PublisherController {
    
    @Autowired
    private PublisherService publisherService;


    //index
    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("publishers", publisherService.findAll());
        return "publishers/index";
    }

    //show
    @GetMapping("/{id}")
    public String show(@PathVariable Integer id, Model model) {
        model.addAttribute("publisher", publisherService.getById(id));
        return "publishers/show";
    }

    //search
    @GetMapping("/search")
    public String search(@RequestParam (name="name") String name, Model model) {
        model.addAttribute("publishers", publisherService.findByName(name));
        return "publishers/index";
    }
    
    
    
}
