package dev.rellaraffick.consolecentral.repositories;

import dev.rellaraffick.consolecentral.records.ConsoleCentralCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends JpaRepository<ConsoleCentralCategories, Integer> {
}
