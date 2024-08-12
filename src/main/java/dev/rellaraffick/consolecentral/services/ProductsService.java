package dev.rellaraffick.consolecentral.services;

import dev.rellaraffick.consolecentral.DTO.ProductDTO;
import dev.rellaraffick.consolecentral.records.ConsoleCentralCategories;
import dev.rellaraffick.consolecentral.records.ConsoleCentralProducts;
import dev.rellaraffick.consolecentral.repositories.CategoriesRepository;
import dev.rellaraffick.consolecentral.repositories.ProductsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {
    private final ProductsRepository productsRepository;
    private final CategoriesRepository categoriesRepository;

    public ProductsService(ProductsRepository productsRepository, CategoriesRepository categoriesRepository) {
        this.productsRepository = productsRepository;
        this.categoriesRepository = categoriesRepository;
    }

    public List<ProductDTO> getAllProducts() {
        return productsRepository.findAllWithCategory();
    }

    public Optional<ProductDTO> getProductById(Integer id) {
        return Optional.of(productsRepository.findByIdWithCategory(id).orElseThrow());
    }

    public void createProduct(ConsoleCentralProducts product, Integer categoryId) {
        ConsoleCentralCategories category = categoriesRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        product.setCategory(category);

        productsRepository.save(product);
    }

    public void updateProduct(Integer id, ConsoleCentralProducts productDetails) {
        ConsoleCentralProducts existingProduct = productsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        existingProduct.setProductName(productDetails.getProductName());
        existingProduct.setProductDescription(productDetails.getProductDescription());
        existingProduct.setProductPrice(productDetails.getProductPrice());
        existingProduct.setProductStock(productDetails.getProductStock());
        existingProduct.setCategory(existingProduct.getCategory());
        productsRepository.save(existingProduct);
    }

    public void updateStock(Integer id, Integer stock) {
        ConsoleCentralProducts existingProduct = productsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        existingProduct.setProductStock(stock);
        existingProduct.setCategory(existingProduct.getCategory());
        productsRepository.save(existingProduct);
    }

    public void deleteProduct(Integer id) {
        productsRepository.deleteById(id);
    }
}
