package com.example.product_service.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.product_service.Entity.Product;
import com.example.product_service.Repository.ProductRepo;


@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepo productRepo;

    
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productRepo.save(product);
    }

    
    @GetMapping 
    public List<Product> getall() {
        return productRepo.findAll();
    }

   
    @GetMapping("/{id}")
    public ResponseEntity<Product> getproductid(@PathVariable Long id) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id " + id));
        return ResponseEntity.ok(product);
    }

   
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {

        Product product = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id " + id));

        product.setName(updatedProduct.getName());
        product.setPrice(updatedProduct.getPrice());

        Product savedProduct = productRepo.save(product);

        return ResponseEntity.ok(savedProduct);
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {

        Product product = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id " + id));

        productRepo.delete(product);

        return ResponseEntity.ok("Product deleted successfully");
    }
}