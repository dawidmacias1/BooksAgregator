package pl.booksagregator.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResourceDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;

    private String key;

    private String type;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private double rating;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int views;
}
