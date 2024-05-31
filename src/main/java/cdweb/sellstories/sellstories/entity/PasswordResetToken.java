package cdweb.sellstories.sellstories.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "password_reset_token")
public class PasswordResetToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "token_value")
    private String tokenValue;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "expiry_date")
    private LocalDateTime expiryDate;


    public PasswordResetToken(Long idUser,String tokenValue) {
        this.user = new User(idUser);
        this.tokenValue = tokenValue;
        this.expiryDate = LocalDateTime.now().plusHours(2);
    }
}

