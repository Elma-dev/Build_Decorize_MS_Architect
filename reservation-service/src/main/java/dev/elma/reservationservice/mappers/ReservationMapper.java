package dev.elma.reservationservice.mappers;

import dev.elma.reservationservice.Dtos.PersonClient;
import dev.elma.reservationservice.Dtos.ReservationClient;
import dev.elma.reservationservice.entities.Person;
import dev.elma.reservationservice.entities.Reservation;
import dev.elma.reservationservice.repositories.PersonRepo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.Date;

@AllArgsConstructor
@Getter
@Component
public class ReservationMapper {

    PersonRepo personRepo;
    public Reservation ReservationClientToReservation(ReservationClient reservationClient){
        Person person = personRepo.findById(reservationClient.getIdPerson()).orElseThrow(() -> new RuntimeException("Person not found"));
        return Reservation.builder()
                .name(reservationClient.getName())
                .context(reservationClient.getContext())
                .date(new Date())
                .duration(reservationClient.getDuration())
                .person(person)
                .idResource(reservationClient.getIdResource())
                .build();

    }
    public ReservationClient ReservationToReservationClient(Reservation reservation){
        return ReservationClient.builder()
                .name(reservation.getName())
                .context(reservation.getContext())
                .duration(reservation.getDuration())
                .idPerson(reservation.getPerson().getId())
                .idResource(reservation.getIdResource())
                .build();

    }
    public Person PersonClientToPerson(PersonClient personClient){
        return Person.builder()
                .name(personClient.getName())
                .email(personClient.getEmail())
                .function(personClient.getFunction())
                .build();
    }
    public PersonClient PersonToPersonClient(Person person){
        return PersonClient.builder()
                .name(person.getName())
                .email(person.getEmail())
                .function(person.getFunction())
                .build();
    }
}
