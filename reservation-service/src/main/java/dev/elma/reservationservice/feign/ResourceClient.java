package dev.elma.reservationservice.feign;

import dev.elma.reservationservice.models.Resource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "resource-service")
public interface ResourceClient {
    @GetMapping("/{id}")
    Resource getResourceById(@PathVariable Long id);
    @GetMapping("/all")
    List<Resource> getAllResources();
}
