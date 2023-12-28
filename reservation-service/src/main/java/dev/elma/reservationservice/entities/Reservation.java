package dev.elma.reservationservice.entities;

import dev.elma.reservationservice.models.Resource;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder
public class Reservation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String context;
    private Date date;
    private int duration;
    @ManyToOne
    private Person person;
    private Long idResource;
    @Transient
    private Resource resource;



}
