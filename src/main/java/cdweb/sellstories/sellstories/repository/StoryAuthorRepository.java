package cdweb.sellstories.sellstories.repository;

import cdweb.sellstories.sellstories.entity.StoryAuthor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryAuthorRepository extends JpaRepository<StoryAuthor,Long> {

}
