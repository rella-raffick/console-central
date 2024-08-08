package dev.rellaraffick.consolecentral.services;

import dev.rellaraffick.consolecentral.records.ConsoleCentralCategories;
import dev.rellaraffick.consolecentral.repositories.CategoriesRepository;
import org.springframework.transaction.annotation.Transactional;

public class CategoriesService {
    private final CategoriesRepository categoriesRepository;

    public CategoriesService(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    public void getCategories() {
        categoriesRepository.findAll();
    }

    public void getCategoryById(Integer categoryId) {
        categoriesRepository.findById(categoryId);
    }

    public void createCategory(ConsoleCentralCategories category) {
        categoriesRepository.save(category);
    }

    @Transactional
    public ConsoleCentralCategories updateCategory(int id, ConsoleCentralCategories category) {
        ConsoleCentralCategories existingCategory = categoriesRepository.findById(id).orElse(null);
        if (existingCategory != null) {
            existingCategory.setCategoryName(category.getCategoryName());
            existingCategory.setCategoryDescription(category.getCategoryDescription());
            categoriesRepository.save(existingCategory);
        }
        return existingCategory;
    }

    public void deleteCategory(int id) {
        categoriesRepository.deleteById(id);
    }
}
