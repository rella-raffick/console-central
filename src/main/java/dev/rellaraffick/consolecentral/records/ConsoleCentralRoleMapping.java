package dev.rellaraffick.consolecentral.records;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsoleCentralRoleMapping {
    @jakarta.persistence.Id
    @org.springframework.data.annotation.Id
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer roleMappingId;
    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private ConsoleCentralUser user;
    @ManyToOne
    @JoinColumn(name = "roleId", referencedColumnName = "roleId")
    private ConsoleCentralRoles role;
}
