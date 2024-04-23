package cdweb.sellstories.sellstories.repository;

import cdweb.sellstories.sellstories.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
}
