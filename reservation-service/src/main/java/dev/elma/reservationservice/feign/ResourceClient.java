package dev.elma.reservationservice.feign;

import dev.elma.reservationservice.models.Resource;
import dev.elma.reservationservice.security.FeignAdapter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "resource-service",configuration = FeignAdapter.class)
public interface ResourceClient {
    @GetMapping("/{id}")
    Resource getResourceById(@PathVariable Long id);
    @GetMapping("/all")
    List<Resource> getAllResources();
}
