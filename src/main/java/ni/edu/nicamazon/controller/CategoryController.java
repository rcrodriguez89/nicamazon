package ni.edu.nicamazon.controller;

import ni.edu.nicamazon.dao.CategoryDao;
import ni.edu.nicamazon.dto.CategoryDto;
import ni.edu.nicamazon.entities.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.inject.Inject;
import java.net.URI;
import java.util.Optional;
import java.util.function.Function;

@RestController("categoryController")
public class CategoryController {
    @Inject
    private CategoryDao categoryDao;

    @GetMapping(value = "/api/Categories")
    public ResponseEntity<Page<CategoryDto>> getCategories(Pageable pageable) {
        Page<CategoryDto> result = categoryDao.findAll(pageable).map(new CategoryToCategoryDto());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/api/Category/{id}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Long id) {
        Optional<CategoryDto> result = categoryDao.findById(id).map(new CategoryToCategoryDto());
        return new ResponseEntity<>(result.get(), HttpStatus.OK);
    }
    
    private class CategoryToCategoryDto implements Function<Category, CategoryDto> {

        @Override
        public CategoryDto apply(Category category) {
            return new CategoryDto(category.getId(), category.getTitle(), category.getDescription(),
                    String.format("/api/Category/%d/thumbnail", category.getId()),
                    String.format("/api/Category/%d/file", category.getId()));
        }
    }
}