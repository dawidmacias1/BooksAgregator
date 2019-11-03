package pl.booksagregator.model.dao;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Resource")
public class ResourceDao {

    @Id
    private String id;

    private String key;

    private String type;

    private RatingDao  rating;

    private int views;
}
