package cdweb.sellstories.sellstories.repository;

import cdweb.sellstories.sellstories.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
   boolean existsByEmail(String email);
   Long findIdByEmail(String email);
   User findUserByEmail(String email);
}
