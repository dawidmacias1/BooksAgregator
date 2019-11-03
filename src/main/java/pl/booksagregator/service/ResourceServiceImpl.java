package pl.booksagregator.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.booksagregator.exception.ApiRequestNotFoundException;
import pl.booksagregator.mapper.ResourceMapper;
import pl.booksagregator.model.dao.ResourceDao;
import pl.booksagregator.model.dto.ResourceDto;
import pl.booksagregator.repository.ResourceRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ResourceServiceImpl implements ResourceService {

    private ResourceRepository resourceRepository;
    private ResourceMapper resourceMapper;

    @Override
    public void addResource(ResourceDto resourceDto) {
        resourceRepository.save(resourceMapper.mapDtoToDao(resourceDto));
    }

    @Override
    public List<ResourceDto> getResources() {
        return resourceRepository.findAll().stream()
                .map(res -> resourceMapper.mapDaoToDto(res))
                .collect(Collectors.toList());
    }

    @Override
    public ResourceDto getResource(String resourceId) {
        return resourceRepository.findById(resourceId)
                .map(res -> resourceMapper.mapDaoToDto(res))
                .orElseThrow(() -> new ApiRequestNotFoundException("Resource not found"));
    }

    @Override
    public List<ResourceDto> getResoucesDtoByIds(List<String> ids) {
        return ids.stream()
                .map(id -> resourceRepository.findById(id)
                        .orElseThrow(() -> new ApiRequestNotFoundException("Resource " + id + " not found")))
                .map(res -> resourceMapper.mapDaoToDto(res))
                .collect(Collectors.toList());
    }

    @Override
    public boolean existsResource(String id) {
        return resourceRepository.existsById(id);
    }


}
