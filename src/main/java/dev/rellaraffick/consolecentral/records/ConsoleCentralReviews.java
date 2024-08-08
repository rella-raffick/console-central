package dev.rellaraffick.consolecentral.records;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsoleCentralReviews {
    @jakarta.persistence.Id
    @org.springframework.data.annotation.Id
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer reviewId;
    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private ConsoleCentralUser user;
    @ManyToOne
    @JoinColumn(name = "productId", referencedColumnName = "productId")
    private ConsoleCentralProducts product;
    private String rating;
    private String comment;
    private LocalDateTime reviewDate;
    @PrePersist
    protected void onCreate() {
        this.reviewDate = LocalDateTime.now();
    }
}
