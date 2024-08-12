package dev.rellaraffick.consolecentral.repositories;

import dev.rellaraffick.consolecentral.DTO.ProductDTO;
import dev.rellaraffick.consolecentral.records.ConsoleCentralProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductsRepository extends JpaRepository<ConsoleCentralProducts, Integer> {
    @Query("SELECT new dev.rellaraffick.consolecentral.DTO.ProductDTO(p.productId, p.productName, p.productDescription, p.productPrice, p.productStock, c.categoryId) FROM ConsoleCentralProducts p JOIN p.category c")
    List<ProductDTO> findAllWithCategory();

    @Query("SELECT new dev.rellaraffick.consolecentral.DTO.ProductDTO(p.productId, p.productName, p.productDescription, p.productPrice, p.productStock, c.categoryId) FROM ConsoleCentralProducts p JOIN p.category c WHERE p.productId = :id")
    Optional<ProductDTO> findByIdWithCategory(Integer id);
}
