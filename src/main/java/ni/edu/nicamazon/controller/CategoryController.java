package ni.edu.nicamazon.controller;

import ni.edu.nicamazon.dao.CategoryDao;
import ni.edu.nicamazon.dto.CategoryDto;
import ni.edu.nicamazon.entities.Category;
import ni.edu.nicamazon.infrastructure.error.ResourceNotFoundException;
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

    @PostMapping(value = "/api/Category")
    public ResponseEntity<?> newCategory(@RequestBody Category category) {
        category.setId(null);
        category = categoryDao.save(category);

        // Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(category.getId())
                .toUri();
        responseHeaders.setLocation(newUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/Category/{id}")
    public ResponseEntity<?> updateCategory(@RequestBody Category category, @PathVariable Long id) {
        verifyCategory(id);

        category.setId(id);

        // Save the entity
        category = categoryDao.save(category);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/Category/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        verifyCategory(id);

        categoryDao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private Category verifyCategory(Long id) throws ResourceNotFoundException {
        Optional<Category> category = categoryDao.findById(id);

        if (!category.isPresent()) {
            throw new ResourceNotFoundException("Category #" + id + " not found.");
        }

        return category.get();
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