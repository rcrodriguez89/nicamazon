package ni.edu.nicamazon.controller;

import ni.edu.nicamazon.dao.CategoryDao;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController("categoryController")
public class CategoryController {
    @Inject
    private CategoryDao categoryDao;


}

