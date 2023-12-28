package dev.elma.ressource_service.Dtos;

import dev.elma.ressource_service.enums.ResourceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class ResourceClient {
    private String name;
    private String type;
}
