package ni.edu.nicamazon.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ni.edu.nicamazon.entities.Category;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("Id")
    private Long id;

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Price")
    private BigDecimal price;

    @JsonProperty("IsSpecial")
    private boolean special;

    @JsonProperty("Desc")
    private String description;

    private Category category;

    @JsonProperty("ImageS")
    private String imageS;

    @JsonProperty("ImageL")
    private String imageL;

    public ProductDto() {}

    public ProductDto(Long id, String title, BigDecimal price, boolean special, String description, Category category,
                      String imageS, String imageL) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.special = special;
        this.description = description;
        this.category = category;
        this.imageS = imageS;
        this.imageL = imageL;
    }
}
