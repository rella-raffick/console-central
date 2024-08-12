package dev.rellaraffick.consolecentral.controllers;

import dev.rellaraffick.consolecentral.DTO.ProductDTO;
import dev.rellaraffick.consolecentral.records.ConsoleCentralProducts;
import dev.rellaraffick.consolecentral.services.ProductsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    private final ProductsService productService;


    public ProductController(ProductsService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    List<ProductDTO> findAll(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    Optional<ProductDTO> findById(@PathVariable Integer id){
        return productService.getProductById(id);
    }

    @PostMapping("/create/{categoryId}")
    void createProduct(@RequestBody ConsoleCentralProducts product, @PathVariable Integer categoryId){
        productService.createProduct(product, categoryId);
    }

    @PutMapping("/update/{id}")
    void updateProduct(@PathVariable Integer id, @RequestBody ConsoleCentralProducts product){
        productService.updateProduct(id, product);
    }

    @PatchMapping("/update-stock/{id}")
    public void updateStock(@PathVariable Integer id, @RequestBody ProductDTO request) {
        log.info("Updating stock for product with id: " + id);
        log.info("New stock: " + request.getProductStock());
        productService.updateStock(id, request.getProductStock());
    }

    @DeleteMapping("/delete/{id}")
    void deleteProduct(@PathVariable Integer id){
        productService.deleteProduct(id);
    }
}
