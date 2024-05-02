package cdweb.sellstories.sellstories.repository;

import cdweb.sellstories.sellstories.dto.StoriesBookDTO;
import cdweb.sellstories.sellstories.entity.StoriesBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoriesBookRepository extends JpaRepository<StoriesBook,Long> {
    List<StoriesBook> findAll();

}
