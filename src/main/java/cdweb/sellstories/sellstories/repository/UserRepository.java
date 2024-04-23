package cdweb.sellstories.sellstories.repository;

import cdweb.sellstories.sellstories.dto.UserDTO;
import cdweb.sellstories.sellstories.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
   boolean existsByEmail(String email);
   Long findIdByEmail(String email);

    Optional<User> findByEmailAndPassWord(String email,String password);
}