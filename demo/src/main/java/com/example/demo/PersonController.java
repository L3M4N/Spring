package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService)
    {
        this.personService = personService;
    }

    @GetMapping("/people")
    public String listPeople(Model model)
    {
        model.addAttribute("people", personService.getPeople());
        return "list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model)
    {
        model.addAttribute("person", new Person());
        return "add";
    }

    @PostMapping("/save")
    public String savePerson(@ModelAttribute Person person)
    {
        personService.addPerson(person);
        return "redirect:/people";
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/people";
    }
}