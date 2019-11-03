package pl.booksagregator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.booksagregator.model.dto.AuthenticatedUserDto;
import pl.booksagregator.service.AuthenticationService;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

    private AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping("/login")
    public AuthenticatedUserDto getAuthentication() {
        return authenticationService.getAuthenticatedUser();
    }
}
