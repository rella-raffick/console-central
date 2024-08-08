package dev.rellaraffick.consolecentral.records;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsoleCentralCategories {
    @jakarta.persistence.Id
    @org.springframework.data.annotation.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    private String categoryName;
    private String categoryDescription;
}
