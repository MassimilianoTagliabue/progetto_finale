package org.lessons.java.progetto_finale.controllers;

import org.lessons.java.progetto_finale.model.Videogame;
import org.lessons.java.progetto_finale.service.VideogameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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
@RequestMapping("/videogame")
public class VideogameController {

    @Autowired
    private VideogameService videogameService;

    // index
    @GetMapping("")
    public String index(Authentication authentication, Model model) {

        model.addAttribute("videogames", videogameService.findAll());
        model.addAttribute("username", authentication.getName());
        return "videogames/index";
    }

    // search
    @GetMapping("/search")
    public String searchByTitle(@RequestParam(name = "title") String title, Model model) {

        model.addAttribute("videogames", videogameService.findByTitle(title));
        return "videogames/index";
    }

    // show
    @GetMapping("/{id}")
    public String show(@PathVariable Integer id, Model model) {

        model.addAttribute("videogame", videogameService.getById(id));
        return "videogames/show";
    }

    // create
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("videogame", new Videogame());
        model.addAttribute("categories", videogameService.findAllCategories());
        model.addAttribute("publishers", videogameService.findAllPublishers());
        return "videogames/create-or-edit";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("videogame") Videogame formVideogame,
            BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", videogameService.findAllCategories());
            model.addAttribute("publishers", videogameService.findAllPublishers());
            return "videogames/create-or-edit";
        }

        videogameService.createOrEdit(formVideogame);

        return "redirect:/videogame";
    }

    // edit
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("videogame", videogameService.getById(id));
        model.addAttribute("categories", videogameService.findAllCategories());
        model.addAttribute("publishers", videogameService.findAllPublishers());
        model.addAttribute("edit", true);
        return "videogames/create-or-edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("videogame") Videogame formVideogame,
            BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", videogameService.findAllCategories());
            model.addAttribute("publishers", videogameService.findAllPublishers());
            return "videogames/create-or-edit";
        }
        videogameService.createOrEdit(formVideogame);

        return "redirect:/videogame";
    }

    // delete
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        videogameService.deleteById(id);

        return "redirect:/videogame";
    }

}
