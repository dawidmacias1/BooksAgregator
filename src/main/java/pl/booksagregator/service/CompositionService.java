package pl.booksagregator.service;

import pl.booksagregator.model.dto.CompositionDto;
import pl.booksagregator.model.dto.ResourceDto;

import java.util.List;

public interface CompositionService {

    void addResource(String compositionId, String resourceId);
    void deleteResource(String compositionId, String resourceId);
    List<CompositionDto> getCompositions();
    CompositionDto getComposition(String compositionId);
    List<ResourceDto> getResources(String compositionId);



}
