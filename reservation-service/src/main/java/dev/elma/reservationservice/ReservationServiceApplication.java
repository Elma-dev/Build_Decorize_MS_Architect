package dev.elma.reservationservice;

import dev.elma.reservationservice.entities.Person;
import dev.elma.reservationservice.entities.Reservation;
import dev.elma.reservationservice.repositories.PersonRepo;
import dev.elma.reservationservice.repositories.ReservationRepo;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Date;
import java.util.List;

@SpringBootApplication
@AllArgsConstructor
@EnableDiscoveryClient
@EnableFeignClients
public class ReservationServiceApplication implements CommandLineRunner {
    private PersonRepo personRepo;
    private ReservationRepo reservationRepo;

    public static void main(String[] args) {
        SpringApplication.run(ReservationServiceApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        List.of("Abdeljalil","Mohamed","Ali").forEach(
                p->{
                    Person person = Person
                            .builder()
                            .name(p)
                            .function("functionality")
                            .email(p + "@Gmail.com")
                            .build();
                    personRepo.save(person);

                }
        );
        Person person = Person
                .builder()
                .name("Ahmed")
                .function("XYZ")
                .email("Ahmed@Gmail.com")
                .build();
        personRepo.save(person);
        List.of("Res1","Res2","Res3").forEach(
                r->{
                    Reservation reservation = Reservation
                            .builder()
                            .name(r)
                            .date(new Date())
                            .context(r + " context")
                            .idResource(1L)
                            .person(person)
                            .duration(30)
                            .build();
                    reservationRepo.save(reservation);

                }
        );

    }
}
