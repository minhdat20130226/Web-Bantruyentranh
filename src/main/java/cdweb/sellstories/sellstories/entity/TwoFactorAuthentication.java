package cdweb.sellstories.sellstories.entity;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "two_factor_authentication")
public class TwoFactorAuthentication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, updatable = false)
    private Long id;

    private String method;

    @Column(name = "verification_code")
    private String verificationCode;

    @Column(name = "expiry_date")
    @Temporal(TemporalType.TIMESTAMP)
    private String expiryDate;
}
