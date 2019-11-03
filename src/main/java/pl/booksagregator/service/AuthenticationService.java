package pl.booksagregator.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.booksagregator.model.dto.AuthenticatedUserDto;

@Service
public class AuthenticationService {

    public AuthenticatedUserDto getAuthenticatedUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return new AuthenticatedUserDto(username, "Jan", "Kowalski");
    }

}
