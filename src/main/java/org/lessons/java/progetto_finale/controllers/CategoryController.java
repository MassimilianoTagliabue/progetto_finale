package org.lessons.java.progetto_finale.controllers;

import org.lessons.java.progetto_finale.model.Category;
import org.lessons.java.progetto_finale.service.CategoryService;
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
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // index
    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "categories/index";
    }

    // show
    @GetMapping("/{id}")
    public String show(@RequestParam Integer id, Model model) {
        model.addAttribute("category", categoryService.getById(id));
        return "categories/show";
    }

    //search
    @GetMapping("/search")
    public String search(@RequestParam(name ="name") String name, Model model) {

        model.addAttribute("categories", categoryService.findByName(name));
        return "categories/index";
    }
    

    // create
    @GetMapping("/create")
    public String create(Model model) {

        model.addAttribute("category", new Category());
        return "categories/create-or-edit";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("category") Category formCategory,
            BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "categories/create-or-edit";
        }

        categoryService.createOrUpdate(formCategory);

        return "redirect:/categories";
    }

    //edit
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {

        model.addAttribute("category", categoryService.getById(id));
        model.addAttribute("edit", true);
        return "categories/create-or-edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("category") Category formCategory,
            BindingResult bindingResult, Model model) {
        
                if(bindingResult.hasErrors()){
                    return"categories/create-or-edit";
                }

                categoryService.createOrUpdate(formCategory);
        
        return "redirect:/categories";
    }

    //delete
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
       
        categoryService.deleteById(id);
        return "redirect:/categories";
    }
    
    
    

}
