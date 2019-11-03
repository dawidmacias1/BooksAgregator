package pl.booksagregator.service;

import pl.booksagregator.model.dto.ResourceDto;

import java.util.List;

public interface ResourceService {

    void addResource(ResourceDto resourceDto);
    List<ResourceDto> getResources();
    ResourceDto getResource(String resourceId);
    List<ResourceDto> getResoucesDtoByIds(List<String> ids);
    boolean existsResource(String id);


}
