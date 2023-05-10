package ru.kostyushin.webapp.repository;

import org.springframework.data.repository.CrudRepository;
import ru.kostyushin.webapp.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
