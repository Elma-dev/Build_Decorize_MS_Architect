package dev.elma.reservationservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

//Une personne est
//définie par son id, son nom, son email et sa fonction.
@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder
public class Person {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String function;
    @OneToMany(mappedBy = "person")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Reservation> reservation;
}
