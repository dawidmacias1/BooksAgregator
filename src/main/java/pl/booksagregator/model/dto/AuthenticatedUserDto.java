package pl.booksagregator.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthenticatedUserDto {

    private String username;

    private String firstName;

    private String lastName;
}
