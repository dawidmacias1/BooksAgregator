package pl.booksagregator.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.booksagregator.exception.ApiRequestConflictException;
import pl.booksagregator.exception.ApiRequestNotFoundException;
import pl.booksagregator.mapper.CompositionMapper;
import pl.booksagregator.mapper.UserMapper;
import pl.booksagregator.model.dao.UserDao;
import pl.booksagregator.model.dto.CompositionDto;
import pl.booksagregator.model.dto.ResourceDto;
import pl.booksagregator.model.dto.UserDto;
import pl.booksagregator.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static pl.booksagregator.service.util.PermissionChecker.checkPermission;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final CompositionMapper compositionMapper;
    private final ResourceService resourceService;


    @Override
    public void addUser(UserDto userDto) {
        if (userRepository.existsByUsername(userDto.getUsername())) {
            throw new ApiRequestConflictException("User exist");
        }
        userRepository.save(userMapper.mapDtoToDao(userDto));
    }

    @Override
    public UserDto getUser(String username) {
        checkPermission(username);
        Optional<UserDao> userDao = userRepository.findByUsername(username);
        return userDao.map(userMapper::mapDaoToDto)
                .orElseThrow(() -> new ApiRequestNotFoundException("User not found"));
    }

    @Override
    public List<ResourceDto> getSearched(String username) {
        checkPermission(username);
        Optional<UserDao> userDao = userRepository.findByUsername(username);
        return userDao.map(dao -> resourceService.getResoucesDtoByIds(dao.getSearched()))
                .orElseThrow(() -> new ApiRequestNotFoundException("User not found"));
    }

    @Override
    public void addSearched(String username, String resourceId) {
        checkPermission(username);
        Optional<UserDao> userDao = userRepository.findByUsername(username);
        ifResourceNotFoundThrowException(resourceId);
        userDao.ifPresentOrElse(
                dao -> {
                    dao.setSearched(addResourceToSearched(resourceId, dao.getSearched()));
                    userRepository.save(dao);
                }, () -> {
                    throw new ApiRequestNotFoundException("User not found");
                });
    }

    private void ifResourceNotFoundThrowException(String resourceId) {
        if (!resourceService.existsResource(resourceId)) {
            throw new ApiRequestNotFoundException("Resource not found");
        }
    }

    private List<String> addResourceToSearched(String resourceId, List<String> resourceIds) {
        resourceIds.remove(resourceId);
        resourceIds.add(0, resourceId);
        if (resourceIds.size() > 10) {
            resourceIds.remove(10);
        }
        return resourceIds;
    }

    @Override
    public List<ResourceDto> getFavorites(String username) {
        checkPermission(username);
        Optional<UserDao> userDao = userRepository.findByUsername(username);
        return userDao.map(dao -> resourceService.getResoucesDtoByIds(dao.getFavorites()))
                .orElseThrow(() -> new ApiRequestNotFoundException("User not found"));
    }

    @Override
    public void addFavorite(String username, String resourceId) {
        checkPermission(username);
        Optional<UserDao> userDao = userRepository.findByUsername(username);
        ifResourceNotFoundThrowException(resourceId);
        userDao.ifPresentOrElse(
                dao -> {
                    dao.getFavorites().add(resourceId);
                    userRepository.save(dao);
                }, () -> {
                    throw new ApiRequestNotFoundException("User not found");
                });
    }


    @Override
    public void addComposition(String username, CompositionDto compositionDto) {
        checkPermission(username);
        Optional<UserDao> userDao = userRepository.findByUsername(username);
        userDao.ifPresentOrElse(dao -> {
            dao.getCompositions().add(0, compositionMapper.mapDtoToDao(compositionDto));
            userRepository.save(dao);
        }, () -> {
            throw new ApiRequestNotFoundException("User not found");
        });
    }

    @Override
    public List<CompositionDto> getCompositions(String username) {
        checkPermission(username);
        return userRepository.findByUsername(username).stream()
                .flatMap(userDao -> userDao.getCompositions().stream())
                .map(compositionDao -> compositionMapper.mapDaoToDto(username, compositionDao))
                .collect(Collectors.toList());
    }

}