package cdweb.sellstories.sellstories.repository;


import cdweb.sellstories.sellstories.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission,Long> {
}
