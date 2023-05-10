package ru.kostyushin.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kostyushin.webapp.entity.Category;
import ru.kostyushin.webapp.repository.CategoryRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    public void deleteById(Long id) throws EntityNotFoundException {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
        categoryRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException
                    ("There is no such category!");
        }
    }

}
