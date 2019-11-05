package pl.booksagregator.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @GetMapping("/login")
    public ResponseEntity getAuthentication() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
