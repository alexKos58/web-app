package ru.kostyushin.webapp.rest;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kostyushin.webapp.entity.Category;
import ru.kostyushin.webapp.entity.Product;
import ru.kostyushin.webapp.service.ProductService;

import java.time.LocalDate;
import java.util.Map;

@NoArgsConstructor
@Controller
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String findAllProducts(Map<String, Object> model) {
        Iterable<Product> products = productService.findAll();
        model.put("products", products);
        return "/products";
    }

    @PostMapping("/products")
    public String addCategory(@RequestParam String name, @RequestParam String description, @RequestParam Category category,
                              @RequestParam String manufacturer, @RequestParam Integer price, Map<String, Object> model){

        Product product = Product.builder()
                .productName(name)
                .productDescription(description)
                .category(category)
                .productManufacturer(manufacturer)
                .price(price)
                .build();


        productService.saveProduct(product);
        Iterable<Product> products = productService.findAll();
        model.put("products", products);
        return "/products";
    }

    @PostMapping ("/delete-product")
    public String deleteProduct(@RequestParam Long id){
        productService.deleteById(id);
        return "redirect:/products";
    }

    @GetMapping("/product-update/{id}")
    public String updateProductForm(@PathVariable("id") Long id, Map<String, Object> model) {
        Product product = productService.findById(id);
        model.put("product", product);
        return "/product-update";
    }

    @PostMapping("/product-update")
    public String updateProduct(Product product ){
        productService.saveProduct(product);
        return "redirect:/products";
    }
}
