package dev.rellaraffick.consolecentral.repositories;

import dev.rellaraffick.consolecentral.records.ConsoleCentralRoleMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMappingRepository extends JpaRepository<ConsoleCentralRoleMapping, Integer> {
}
