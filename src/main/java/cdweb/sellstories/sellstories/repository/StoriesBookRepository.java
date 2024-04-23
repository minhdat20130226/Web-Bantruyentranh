package cdweb.sellstories.sellstories.repository;

import cdweb.sellstories.sellstories.entity.StoriesBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoriesBookRepository extends JpaRepository<StoriesBook,Long> {
}
