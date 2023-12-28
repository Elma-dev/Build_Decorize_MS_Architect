package dev.elma.ressource_service.web;

import dev.elma.ressource_service.Dtos.ResourceClient;
import dev.elma.ressource_service.Mappers.ResourceMappers;
import dev.elma.ressource_service.Repositories.ResourceRepo;
import dev.elma.ressource_service.entities.Resource;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class ResourceRestController {
    private ResourceRepo resourceRepo;
    @GetMapping("/all")
    public List<Resource> allResources(){
        return resourceRepo.findAll();
    };
    @GetMapping("/{id}")
    public Resource resourceById(@PathVariable Long id){
        return resourceRepo.findById(id).orElseThrow();
    };
    @PostMapping("/add")
    public Resource addResource(@RequestBody ResourceClient resource){
        return resourceRepo.save(ResourceMappers.resClientToResource(resource));
    };
    @PutMapping("/update")
    public Resource updateResource(@RequestBody Resource resource){
        return resourceRepo.save(resource);
    };
    @DeleteMapping("/delete/{id}")
    public void deleteResource(@PathVariable Long id){
        resourceRepo.deleteById(id);
    };

}
