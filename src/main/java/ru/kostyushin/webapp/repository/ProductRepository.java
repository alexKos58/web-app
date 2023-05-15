package ru.kostyushin.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kostyushin.webapp.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
