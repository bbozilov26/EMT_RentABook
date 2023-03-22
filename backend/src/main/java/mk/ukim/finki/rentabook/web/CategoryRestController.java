package mk.ukim.finki.rentabook.web;

import mk.ukim.finki.rentabook.models.enumerations.Category;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/categories")
public class CategoryRestController {

    @GetMapping("/getAll")
    public List<Category> getAllCategories() {
        return Arrays.asList(Category.values());
    }
}
