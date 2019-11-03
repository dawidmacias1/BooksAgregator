package pl.booksagregator.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.booksagregator.model.dto.ResourceDto;
import pl.booksagregator.service.ResourceService;

import java.util.List;

@RestController
@RequestMapping("/resources")
@AllArgsConstructor
public class ResourceController {

    private ResourceService resourceService;

    @PostMapping
    public ResponseEntity addResource(@RequestBody ResourceDto resourceDto) {
        resourceService.addResource(resourceDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ResourceDto>> getResources() {
        return new ResponseEntity<>(resourceService.getResources(), HttpStatus.OK);
    }

    @GetMapping("/{resourceId}")
    public ResponseEntity<ResourceDto> getResource(@PathVariable String resourceId) {
        return new ResponseEntity<>(resourceService.getResource(resourceId), HttpStatus.OK);
    }



}
