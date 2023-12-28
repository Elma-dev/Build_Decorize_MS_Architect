package dev.elma.reservationservice.Dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Builder
@Data
public class PersonClient {
    private String name;
    private String email;
    private String function;
}
