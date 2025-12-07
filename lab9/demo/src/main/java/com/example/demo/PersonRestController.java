package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/people")
public class PersonRestController {

    private final PersonService personService;

    public PersonRestController(PersonService personService)
    {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getAll()
    {
        return personService.getPeople();
    }

    @GetMapping("/{index}")
    public ResponseEntity<Person> getOne(@PathVariable int index)
    {
        Person p = personService.getPerson(index);
        if (p != null) {
            return ResponseEntity.ok(p);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> add(@RequestBody Person person)
    {
        personService.addPerson(person);
        return ResponseEntity.ok("Dodano osobę");
    }

    @PutMapping("/{index}")
    public ResponseEntity<String> update(@PathVariable int index, @RequestBody Person person)
    {
        if (personService.getPerson(index) != null)
        {
            personService.setPerson(index, person);
            return ResponseEntity.ok("Zaktualizowano");
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{index}")
    public ResponseEntity<String> delete(@PathVariable int index)
    {
        if (personService.getPerson(index) != null)
        {
            personService.removePerson(index);
            return ResponseEntity.ok("Usunięto");
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }
}