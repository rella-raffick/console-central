package dev.rellaraffick.consolecentral.repositories;

import dev.rellaraffick.consolecentral.records.ConsoleCentralProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<ConsoleCentralProducts, Integer> {
}
