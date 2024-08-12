package dev.rellaraffick.consolecentral.controllers;

import dev.rellaraffick.consolecentral.records.ConsoleCentralCategories;
import dev.rellaraffick.consolecentral.services.CategoriesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private final CategoriesService categoriesService;

    public CategoryController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @GetMapping("/all")
    List<ConsoleCentralCategories> findAll(){
        return categoriesService.getAllCategories();
    }

    @GetMapping("/{id}")
    Optional<ConsoleCentralCategories> findById(@PathVariable Integer id){
        return categoriesService.getCategoryById(id);
    }

    @PostMapping("/create")
    void createCategory(@RequestBody ConsoleCentralCategories category){
        categoriesService.createCategory(category);
    }

    @PutMapping("/update/{id}")
    ConsoleCentralCategories updateCategory(@PathVariable Integer id, @RequestBody ConsoleCentralCategories category){
        return categoriesService.updateCategory(id, category);
    }

    @DeleteMapping("/delete/{id}")
    void deleteCategory(@PathVariable Integer id){
        categoriesService.deleteCategory(id);
    }
}
