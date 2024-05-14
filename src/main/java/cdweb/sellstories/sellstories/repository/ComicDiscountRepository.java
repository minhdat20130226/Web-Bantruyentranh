package cdweb.sellstories.sellstories.repository;

import cdweb.sellstories.sellstories.entity.ComicDiscount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ComicDiscountRepository extends JpaRepository<ComicDiscount, Long> {
    @Query("SELECT cd.storiesBook.id FROM ComicDiscount cd " +
            "WHERE cd.reduction_rate = (SELECT MAX(cd.reduction_rate) FROM ComicDiscount cd)")
    Long findIdWithMaxReductionRate();
}
