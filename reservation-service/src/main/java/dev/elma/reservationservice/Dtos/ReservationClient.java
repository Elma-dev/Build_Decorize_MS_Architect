package dev.elma.reservationservice.Dtos;

import dev.elma.reservationservice.entities.Person;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ReservationClient {
    private String name;
    private String context;
    private int duration;
    private Long idPerson;
    private Long idResource;
}
