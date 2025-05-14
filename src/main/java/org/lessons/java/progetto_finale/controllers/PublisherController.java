package org.lessons.java.progetto_finale.controllers;

import org.lessons.java.progetto_finale.model.Publisher;
import org.lessons.java.progetto_finale.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



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
    
    //create
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("publisher", new Publisher());
        return "publishers/create-or-edit";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("publisher") Publisher formPublisher,
            BindingResult bindingResult, Model model) {
        
            if(bindingResult.hasErrors()){
                return "publishers/create-or-edit";
            }

            publisherService.createOrEdit(formPublisher);
        
        return "redirect:/publisher";
    }

    //edit
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("publisher", publisherService.getById(id));
        model.addAttribute("edit", true);
        return "publishers/create-or-edit";
    }
    
    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("publisher") Publisher formPublisher,
            BindingResult bindingResult, Model model) {
        
                if(bindingResult.hasErrors()){
                    return "publishers/create-or-edit";
                }

                publisherService.createOrEdit(formPublisher);
        
        return "redirect:/publisher";
    }
    
    //delete
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        
        publisherService.deleteById(id);
        return "redirect:/publisher";
    }
    
    
    
    
}
