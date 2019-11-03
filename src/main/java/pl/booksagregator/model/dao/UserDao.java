package pl.booksagregator.model.dao;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;

@Data
@Document(collection = "User")
public class UserDao {

    @Id
    private String id;

    private String username;

    private String password;

    @Email
    private String email;

    private Date birth;

    private List<String> searched;

    private List<String> favorites;

    private List<CompositionDao> compositions;

}
