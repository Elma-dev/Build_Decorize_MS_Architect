package dev.elma.reservationservice.web;

import dev.elma.reservationservice.Dtos.PersonClient;
import dev.elma.reservationservice.entities.Person;
import dev.elma.reservationservice.mappers.ReservationMapper;
import dev.elma.reservationservice.repositories.PersonRepo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@AllArgsConstructor
@CrossOrigin("*")
public class PersonRestController {
    private PersonRepo personRepo;
    private ReservationMapper reservationMapper;
    @GetMapping("/all")
    public List<Person> getAllPersons() {
        return personRepo.findAll();
    }
    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Long id) {
        return personRepo.findById(id).orElseThrow();
    }
    @PostMapping("/add")
    public Person addPerson(@RequestBody PersonClient person) {
        Person person1 = reservationMapper.PersonClientToPerson(person);
        return personRepo.save(person1);
    }
    @DeleteMapping("/delete/{id}")
    public void deletePerson(@PathVariable Long id) {
        personRepo.deleteById(id);
    }
    @PutMapping("/update")
    public Person updatePerson(@RequestBody PersonClient person) {
        Person person1 = reservationMapper.PersonClientToPerson(person);
        return personRepo.save(person1);
    }
}
