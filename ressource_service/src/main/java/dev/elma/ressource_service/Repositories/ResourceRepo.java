package dev.elma.ressource_service.Repositories;

import dev.elma.ressource_service.entities.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepo extends JpaRepository<Resource, Long> {

}
