package dev.rellaraffick.consolecentral.repositories;

import dev.rellaraffick.consolecentral.records.ConsoleCentralReviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewsRepository extends JpaRepository<ConsoleCentralReviews, Integer> {
}
