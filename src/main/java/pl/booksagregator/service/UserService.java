package pl.booksagregator.service;

import pl.booksagregator.model.dto.CompositionDto;
import pl.booksagregator.model.dto.ResourceDto;
import pl.booksagregator.model.dto.UserDto;

import java.util.List;

public interface UserService {

    void addUser(UserDto userDto);
    UserDto getUser(String username);
    List<ResourceDto> getSearched(String username);
    void addSearched(String username, String resourceId);
    List<ResourceDto> getFavorites(String username);
    void addFavorite(String username, String resourceId);
    void addComposition(String username,CompositionDto compositionDto);
    List<CompositionDto> getCompositions(String username);


}
