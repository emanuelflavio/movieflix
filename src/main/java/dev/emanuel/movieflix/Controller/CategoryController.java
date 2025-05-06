package dev.emanuel.movieflix.Controller;

import dev.emanuel.movieflix.Service.CategoryService;
import dev.emanuel.movieflix.Entity.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movieflix/category")
@RequiredArgsConstructor
public class CategoryController {


    private final CategoryService categoryService;

    @GetMapping()
    public List<Category> getAllCategories() {
        return categoryService.findAll();
    }

    @PostMapping()
    public Category saveCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @GetMapping("/{id}")
    public Category getByCategoriesId(@PathVariable Long id) {
        Optional<Category> optCategory = categoryService.findById(id);
        if (optCategory.isPresent()) {
            return optCategory.get();
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteByCategoryId(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }

}
