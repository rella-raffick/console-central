package dev.rellaraffick.consolecentral.repositories;

import dev.rellaraffick.consolecentral.records.ConsoleCentralUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<ConsoleCentralUser, Integer> {
    ConsoleCentralUser findByEmail(String email);
}
