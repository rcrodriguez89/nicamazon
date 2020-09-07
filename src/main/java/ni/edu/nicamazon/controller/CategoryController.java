package ni.edu.nicamazon.controller;

import ni.edu.nicamazon.dao.CategoryDao;
import ni.edu.nicamazon.dto.CategoryDto;
import ni.edu.nicamazon.entities.Category;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.awt.print.Pageable;
import java.util.function.Function;

@RestController("categoryController")
public class CategoryController {
    @Inject
    private CategoryDao categoryDao;

    private class CategoryToCategoryDto implements Function<Category, CategoryDto> {

        @Override
        public CategoryDto apply(Category category) {
            return new CategoryDto(category.getId(), category.getTitle(), category.getDescription(),
                    String.format("/api/Category/%d/thumbnail", category.getId()),
                    String.format("/api/Category/%d/file", category.getId()));
        }
    }
}

