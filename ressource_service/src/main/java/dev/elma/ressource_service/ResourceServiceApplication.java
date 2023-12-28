package dev.elma.ressource_service;

import dev.elma.ressource_service.Repositories.ResourceRepo;
import dev.elma.ressource_service.entities.Resource;
import dev.elma.ressource_service.enums.ResourceType;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.List;
import java.util.Random;

@SpringBootApplication
@AllArgsConstructor
@EnableDiscoveryClient
public class ResourceServiceApplication implements CommandLineRunner {
    ResourceRepo resourceRepo;

    public static void main(String[] args) {
        SpringApplication.run(ResourceServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        List.of("resource1","resource2","resource3").forEach(
                r->{
                    Resource resource = Resource
                            .builder()
                            .name(r)
                            .type(Math.random()>0.5? ResourceType.MATERIEL_INFO:ResourceType.MATERIEL_AUDIO_VISUAL)
                            .build();
                    resourceRepo.save(resource);

                }
        );
    }
}
