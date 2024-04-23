package cdweb.sellstories.sellstories.repository;

import cdweb.sellstories.sellstories.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
