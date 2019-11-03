package pl.booksagregator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.booksagregator.model.dto.CompositionDto;
import pl.booksagregator.model.dto.ResourceDto;
import pl.booksagregator.model.dto.UserDto;
import pl.booksagregator.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity addUser(@RequestBody UserDto userDto) {
        userService.addUser(userDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDto> getUser(@PathVariable String username) {
        return new ResponseEntity<>(userService.getUser(username), HttpStatus.OK);
    }

    @GetMapping("/{username}/searches")
    public ResponseEntity<List<ResourceDto>> getSearched(@PathVariable String username) {
        return new ResponseEntity<>(userService.getSearched(username), HttpStatus.OK);
    }

    @PutMapping("/{username}/searches/{resourceId}")
    public ResponseEntity addSearched(@PathVariable String username, @PathVariable String resourceId) {
        userService.addSearched(username, resourceId);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/{username}/favorites")
    public ResponseEntity<List<ResourceDto>> getFavorites(@PathVariable String username) {
        return new ResponseEntity<>(userService.getFavorites(username), HttpStatus.OK);
    }

    @PutMapping("/{username}/favorites/{resourceId}")
    public ResponseEntity addFavorite(@PathVariable String username, @PathVariable String resourceId) {
        userService.addFavorite(username, resourceId);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("/{username}/compositions")
    public ResponseEntity addComposition(@PathVariable String username, @RequestBody CompositionDto compositionDto) {
        userService.addComposition(username,compositionDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/{username}/compositions")
    public ResponseEntity<List<CompositionDto>> getCompositions(@PathVariable String username) {
        return new ResponseEntity<>(userService.getCompositions(username), HttpStatus.OK);
    }
}
