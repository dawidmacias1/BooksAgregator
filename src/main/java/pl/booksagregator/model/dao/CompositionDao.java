package pl.booksagregator.model.dao;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
public class CompositionDao {

    @Id
    private ObjectId id;

    private String name;

    private String description;

    private List<String> tags;

    private RatingDao rating;

    private int views;

    private Boolean open;

    private Date release;

    private List<String> resources;
}
