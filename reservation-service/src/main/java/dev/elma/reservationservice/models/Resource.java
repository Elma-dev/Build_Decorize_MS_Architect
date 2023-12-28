package dev.elma.reservationservice.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Resource {
    private Long id;
    private String name;
    private String type;
}
