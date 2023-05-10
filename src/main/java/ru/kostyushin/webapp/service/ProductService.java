package ru.kostyushin.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kostyushin.webapp.entity.Category;
import ru.kostyushin.webapp.entity.Product;
import ru.kostyushin.webapp.repository.ProductRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }


    public Product saveProduct(Product product){
    return productRepository.save(product);
    }

    public void deleteById(Long id) throws EntityNotFoundException {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException
                    ("There is no such product!");
        }
    }
}
