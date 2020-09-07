package ni.edu.nicamazon.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class CategoryDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("Id")
    private Long id;

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Desc")
    private String description;

    @JsonProperty("ImageS")
    private String imageS;

    @JsonProperty("ImageL")
    private String imageL;

    public CategoryDto() {}

    public CategoryDto(Long id, String title, String description, String imageS, String imageL) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageS = imageS;
        this.imageL = imageL;
    }
}
