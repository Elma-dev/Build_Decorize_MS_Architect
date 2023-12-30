package dev.elma.ressource_service.entities;

import dev.elma.ressource_service.enums.ResourceType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString @Builder
public class Resource {
    @Id @GeneratedValue
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private ResourceType type;
}
