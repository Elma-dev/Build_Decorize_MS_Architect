package dev.elma.reservationservice.repositories;

import dev.elma.reservationservice.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person, Long>{
}
