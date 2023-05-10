package ru.kostyushin.webapp.repository;

import org.springframework.data.repository.CrudRepository;
import ru.kostyushin.webapp.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
