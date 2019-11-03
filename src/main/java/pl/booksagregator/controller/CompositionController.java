package pl.booksagregator.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.booksagregator.model.dto.CompositionDto;
import pl.booksagregator.model.dto.ResourceDto;
import pl.booksagregator.service.CompositionService;

import java.util.List;

@RestController
@RequestMapping("/compositions")
@AllArgsConstructor
public class CompositionController {

    private CompositionService compositionService;

    @GetMapping
    public ResponseEntity<List<CompositionDto>> getCompositions() {
        return new ResponseEntity<>(compositionService.getCompositions(), HttpStatus.OK);
    }

    @GetMapping("/{compositionId}")
    public ResponseEntity<CompositionDto> getComposition(@PathVariable String compositionId) {
        return new ResponseEntity<>(compositionService.getComposition(compositionId), HttpStatus.OK);
    }

    @GetMapping("/{compositionId}/resources")
    public ResponseEntity<List<ResourceDto>> getResources(@PathVariable String compositionId) {
        return new ResponseEntity<>(compositionService.getResources(compositionId), HttpStatus.OK);
    }

}
