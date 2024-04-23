package cdweb.sellstories.sellstories.repository;

import cdweb.sellstories.sellstories.entity.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken,Long> {
    PasswordResetToken findByTokenValue(String token);
}

