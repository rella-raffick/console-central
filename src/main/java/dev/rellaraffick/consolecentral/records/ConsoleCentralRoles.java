package dev.rellaraffick.consolecentral.records;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsoleCentralRoles {
    @jakarta.persistence.Id
    @org.springframework.data.annotation.Id
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer roleId;
    private String roleName;
}
