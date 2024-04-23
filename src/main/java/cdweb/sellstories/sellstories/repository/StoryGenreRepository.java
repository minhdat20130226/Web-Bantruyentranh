package cdweb.sellstories.sellstories.repository;

import cdweb.sellstories.sellstories.entity.StoryGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryGenreRepository extends JpaRepository<StoryGenre,Long> {
}
