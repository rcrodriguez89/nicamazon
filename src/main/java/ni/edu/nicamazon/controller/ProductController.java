package ni.edu.nicamazon.controller;

import ni.edu.nicamazon.dao.ProductDao;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController("productController")
public class ProductController {

    @Inject
    private ProductDao productDao;

}
