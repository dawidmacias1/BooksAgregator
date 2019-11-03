package pl.booksagregator.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.booksagregator.exception.ApiRequestForbiddenException;
import pl.booksagregator.exception.ApiRequestNotFoundException;
import pl.booksagregator.mapper.CompositionMapper;
import pl.booksagregator.mapper.ResourceMapper;
import pl.booksagregator.model.dao.CompositionDao;
import pl.booksagregator.model.dao.UserDao;
import pl.booksagregator.model.dto.CompositionDto;
import pl.booksagregator.model.dto.ResourceDto;
import pl.booksagregator.repository.ResourceRepository;
import pl.booksagregator.repository.UserRepository;
import pl.booksagregator.service.util.PermissionChecker;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static pl.booksagregator.service.util.PermissionChecker.checkPermission;

@Service
@AllArgsConstructor
public class CompositionServiceImpl implements CompositionService {

    private UserRepository userRepository;
    private ResourceService resourceService;
    private CompositionMapper compositionMapper;


    @Override
    public void addResource(String compositionId, String resourceId) {

    }

    @Override
    public void deleteResource(String compositionId, String resourceId) {

    }

    @Override
    public List<ResourceDto> getResources(String compositionId) {
        Optional<UserDao> userDao = userRepository.findUserByCompositionId(compositionId);
        return userDao.map(dao -> dao.getCompositions()
                .stream()
                .filter(comp -> comp.getId().toString().equals(compositionId))
                .peek(comp -> checkPermission(dao.getUsername(), comp.getOpen()))
                .flatMap(res -> resourceService.getResoucesDtoByIds(res.getResources()).stream())
                .collect(Collectors.toList()))
                .orElseThrow(() -> new ApiRequestNotFoundException("Composition not found"));
    }

    @Override
    public List<CompositionDto> getCompositions() {
        List<CompositionDto> compositionDtos = new ArrayList<>();
        return userRepository.findAll().stream()
                .flatMap(userDao -> userDao.getCompositions()
                        .stream()
                        .filter(CompositionDao::getOpen)
                        .map(dao -> compositionMapper.mapDaoToDto(userDao.getUsername(), dao)))
                .collect(Collectors.toList());
    }

    @Override
    public CompositionDto getComposition(String compositionId) {
        Optional<UserDao> userDao = userRepository.findUserByCompositionId(compositionId);
        CompositionDto compositionDto = userDao.map(dao ->
                compositionMapper.mapDaoToDto(dao.getUsername(), dao.getCompositions()
                        .stream()
                        .filter(comp -> comp.getId().toString().equals(compositionId))
                        .findAny().get()))
                .orElseThrow(() -> new ApiRequestNotFoundException("Composition not found"));
        checkPermission(userDao.get().getUsername(), compositionDto.getOpen());
        return compositionDto;
    }

}
