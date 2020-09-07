package ni.edu.nicamazon.controller;

import ni.edu.nicamazon.dao.ProductDao;
import ni.edu.nicamazon.dto.ProductDto;
import ni.edu.nicamazon.entities.Product;
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

@RestController("productController")
public class ProductController {
    @Inject
    private ProductDao productDao;

    @GetMapping(value = "/api/Products")
    public ResponseEntity<Page<ProductDto>> getProducts(Pageable pageable) {
        Page<ProductDto> result = productDao.findAll(pageable).map(new ProductToProductDto());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/api/Product/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable Long id) {
        Optional<ProductDto> result = productDao.findById(id).map(new ProductToProductDto());
        return new ResponseEntity<>(result.get(), HttpStatus.OK);
    }

    @PostMapping(value = "/api/Product")
    public ResponseEntity<?> newProduct(@RequestBody Product product) {
        product.setId(null);
        product = productDao.save(product);

        // Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(product.getId())
                .toUri();
        responseHeaders.setLocation(newUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/Product/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody Product product, @PathVariable Long id) {
        verifyProduct(id);
        product.setId(id);

        // Save the entity
        product = productDao.save(product);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/Product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        verifyProduct(id);
        productDao.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    private Product verifyProduct(Long id) throws ResourceNotFoundException {
        Optional<Product> Product = productDao.findById(id);

        if (!Product.isPresent()) {
            throw new ResourceNotFoundException("Product #" + id + " not found.");
        }
        
        return Product.get();
    }

    private class ProductToProductDto implements Function<Product, ProductDto> {

        @Override
        public ProductDto apply(Product product) {
            return new ProductDto(product.getId(), product.getTitle(), product.getPrice(), product.isSpecial(), product.getDescription(), product.getCategory(),
                    String.format("/api/Product/%d/thumbnail", product.getId()),
                    String.format("/api/Product/%d/file", product.getId()));
        }
    }
}
