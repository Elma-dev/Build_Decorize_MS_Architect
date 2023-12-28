package dev.elma.reservationservice.web;

import dev.elma.reservationservice.Dtos.ReservationClient;
import dev.elma.reservationservice.entities.Person;
import dev.elma.reservationservice.entities.Reservation;
import dev.elma.reservationservice.feign.ResourceClient;
import dev.elma.reservationservice.mappers.ReservationMapper;
import dev.elma.reservationservice.models.Resource;
import dev.elma.reservationservice.repositories.PersonRepo;
import dev.elma.reservationservice.repositories.ReservationRepo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
@AllArgsConstructor
@CrossOrigin("*")
public class ReservationRestController {
    private PersonRepo personRepo;
    private ResourceClient resourceClient;
    private ReservationRepo reservationRepo;
    private ReservationMapper reservationMapper;
    
    @GetMapping("/all")
    public List<Reservation> getAllReservations(){
        List<Reservation> all = reservationRepo.findAll();
        all.forEach(r->{
            Long idResource = r.getIdResource();
            Resource resource = resourceClient.getResourceById(idResource);
            r.setResource(resource);

        });
        return all;
    }
    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable Long id){
        Reservation reservation = reservationRepo.findById(id).orElseThrow();
        Long idResource = reservation.getIdResource();
        Resource resource = resourceClient.getResourceById(idResource);
        reservation.setResource(resource);
        return reservation;
    }
    @PostMapping("/add")
    public Reservation addReservation(@RequestBody ReservationClient reservation){
        Reservation reservation1 = reservationMapper.ReservationClientToReservation(reservation);
        Long idPerson = reservation.getIdPerson();
        Person person = personRepo.findById(idPerson).orElseThrow();
        reservation1.setPerson(person);

        return reservationRepo.save(reservation1);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteReservation(@PathVariable Long id){
        reservationRepo.deleteById(id);
    }
    @PutMapping("/update")
    public Reservation updateReservation(@RequestBody ReservationClient reservation){
        Reservation reservation1 = reservationMapper.ReservationClientToReservation(reservation);
        Long idPerson = reservation.getIdPerson();
        Person person = personRepo.findById(idPerson).orElseThrow();
        reservation1.setPerson(person);
        return reservationRepo.save(reservation1);
    }
}
