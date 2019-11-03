package pl.booksagregator.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CompositionDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String creator;

    private String name;

    private String description;

    private List<String> tags;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private double rating;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int views;

    private Boolean open;

    private Date release;
}
