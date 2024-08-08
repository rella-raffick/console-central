package dev.rellaraffick.consolecentral.services;

import dev.rellaraffick.consolecentral.records.ConsoleCentralProducts;
import dev.rellaraffick.consolecentral.repositories.ProductsRepository;

public class ProductsService {
    private final ProductsRepository productsRepository;

    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public void getAllProducts() {
        productsRepository.findAll();
    }

    public void getProductById(Integer id) {
        productsRepository.findById(id).orElseThrow();
    }

    public void createProduct(ConsoleCentralProducts product) {
        productsRepository.save(product);
    }

    public void updateProduct(Integer id, ConsoleCentralProducts productDetails) {
        ConsoleCentralProducts existingProduct = productsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        existingProduct.setProductName(productDetails.getProductName());
        existingProduct.setProductDescription(productDetails.getProductDescription());
        existingProduct.setProductPrice(productDetails.getProductPrice());
        existingProduct.setProductStock(productDetails.getProductStock());
        existingProduct.setCategory(productDetails.getCategory());
        productsRepository.save(existingProduct);
    }

    public void deleteProduct(Integer id) {
        productsRepository.deleteById(id);
    }
}
