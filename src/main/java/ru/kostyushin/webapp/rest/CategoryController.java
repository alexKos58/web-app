package ru.kostyushin.webapp.rest;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kostyushin.webapp.entity.Category;
import ru.kostyushin.webapp.service.CategoryService;

import java.util.Map;

@NoArgsConstructor
@Controller
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/categories")
    public String findAllCategories(Map<String, Object> model) {
        Iterable<Category> categories = categoryService.findAll();
        model.put("categories", categories);
        return "categories";
    }

    @PostMapping("/categories")
    public String addCategory(@RequestParam String name, @RequestParam String description, Map<String, Object> model) {
        Category category = Category.builder()
                .categoryName(name)
                .categoryDescription(description)
                .build();

        categoryService.saveCategory(category);
        Iterable<Category> categories = categoryService.findAll();
        model.put("categories", categories);
        return "categories";
    }


    @PostMapping("delete-category")
    public String deleteCategory(@RequestParam Long id) {

        categoryService.deleteById(id);
        return "redirect:/categories";
    }

    @GetMapping("/update-category/{id}")
    public String updateCategoryForm(@PathVariable("id") Long id, Map<String, Object> model) {
        Category category = categoryService.findById(id);
        model.put("category", category);
        return "/category-update";
    }

    @PostMapping("/update-category")
    public String updateCategory(Category category){
        categoryService.saveCategory(category);
        return "redirect:/categories";
    }
}