package dev.elma.ressource_service.Mappers;

import dev.elma.ressource_service.Dtos.ResourceClient;

import dev.elma.ressource_service.entities.Resource;
import dev.elma.ressource_service.enums.ResourceType;

public class ResourceMappers {
    public static Resource resClientToResource(ResourceClient resClient){
         return Resource
                 .builder()
                 .type(ResourceType.valueOf(resClient.getType()))
                 .build();


    }
    public static ResourceClient resourceToResClient(Resource resource){
        return ResourceClient
                .builder()
                .name(resource.getName())
                .type(resource.getType().toString())
                .build();
    }
}
