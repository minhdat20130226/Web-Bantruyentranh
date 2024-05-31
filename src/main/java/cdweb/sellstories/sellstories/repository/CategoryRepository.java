package cdweb.sellstories.sellstories.repository;

import cdweb.sellstories.sellstories.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("SELECT c.storyAuthor.name, c.storyTranslator.name, c.placePublication.name, c.storyGenre.name FROM Category c")
    List<Object[]> findAllAuthorsTranslatorsPublicationsGenres();

    @Query("SELECT c,cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook WHERE c.storiesBook.id = :storiesBookId")
    List<Object[]> findByStoriesBookId(@Param("storiesBookId") Long storiesBookId);

    @Query("SELECT c, cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE c.storiesBook.status = :statusBook " +
            "AND (cd.decreaseDay <= CURRENT_TIMESTAMP AND (cd.expirationDateDeduced IS NULL OR cd.expirationDateDeduced >= CURRENT_TIMESTAMP)) ")
    List<Object[]> getBooks(@Param("statusBook") String statusBook);

    @Query("SELECT COUNT(c) FROM Category c WHERE c.storyAuthor.id = :authorId")
    int countBooksByAuthorId(@Param("authorId") Long authorId);

    @Query("SELECT COUNT(c) FROM Category c WHERE c.placePublication.id = :translatorId")
    int countBooksByPlacePublication(@Param("translatorId") Long translatorId);

    @Query("SELECT COUNT(c) FROM Category c WHERE c.storyGenre.id = :genreId")
    int countBooksByGenreId(@Param("genreId") Long genreId);

    // >>>>>>> query category font-end page SearchBook
    //TODO>>>>>>>>>>>>>>>>>>>>>> SORT WITH NAME BOOK
    //   TODO SORT WITH GENRE NAME
    @Query("SELECT c, cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE c.storyGenre.name = :storyGenreName ORDER BY c.storiesBook.name ASC")
    Page<Object[]> sortASCBooksByGenreName(@Param("storyGenreName") String storyGenreName, Pageable pageable);

    @Query("SELECT c, cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE c.storyGenre.name = :storyGenreName ORDER BY c.storiesBook.name DESC")
    Page<Object[]> sortDESCBooksByGenreName(@Param("storyGenreName") String storyGenreName, Pageable pageable);

    //   TODO SORT WITH AUTHOR NAME
    @Query("SELECT c,cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE c.storyAuthor.name = :authorName ORDER BY c.storiesBook.name ASC")
    Page<Object[]> sortASCBooksByAuthorName(@Param("authorName") String authorName, Pageable pageable);

    @Query("SELECT c,cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE c.storyAuthor.name = :authorName ORDER BY c.storiesBook.name DESC")
    Page<Object[]> sortDESCBooksByAuthorName(@Param("authorName") String authorName, Pageable pageable);

    //   TODO SORT WITH PUBLISHER NAME
    @Query("SELECT c,cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE c.placePublication.name = :placePublicationName ORDER BY c.storiesBook.name ASC")
    Page<Object[]> sortASCBooksByPublisherName(@Param("placePublicationName") String placePublicationName, Pageable pageable);

    @Query("SELECT c,cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE c.placePublication.name = :placePublicationName ORDER BY c.storiesBook.name DESC")
    Page<Object[]> sortDESCBooksByPublisherName(@Param("placePublicationName") String placePublicationName, Pageable pageable);

    //   TODO SORT WITH AGE RANGE
    @Query("SELECT c,cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE c.storiesBook.readingAge.age > :largerValue " +
            "ORDER BY c.storiesBook.name ASC")
    Page<Object[]> sortASCBooksByAgeRange(@Param("largerValue") int largerValue, Pageable pageable);

    @Query("SELECT c,cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE c.storiesBook.readingAge.age >= :startAge AND c.storiesBook.readingAge.age <= :endAge " +
            "ORDER BY c.storiesBook.name ASC")
    Page<Object[]> sortASCBooksByAgeRange(@Param("startAge") int startAge, @Param("endAge") int endAge, Pageable pageable);

    @Query("SELECT c,cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE c.storiesBook.readingAge.age > :largerValue " +
            "ORDER BY c.storiesBook.name DESC")
    Page<Object[]> sortDESCBooksByAgeRange(@Param("largerValue") int largerValue, Pageable pageable);

    @Query("SELECT c,cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE c.storiesBook.readingAge.age >= :startAge AND c.storiesBook.readingAge.age <= :endAge " +
            "ORDER BY c.storiesBook.name DESC")
    Page<Object[]> sortDESCBooksByAgeRange(@Param("startAge") int startAge, @Param("endAge") int endAge, Pageable pageable);

    //   TODO SORT WITH PRICE RANGE
    @Query("SELECT c,cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE c.storiesBook.price > :largerValue " +
            "ORDER BY c.storiesBook.name ASC")
    Page<Object[]> sortASCBooksByPriceRange(@Param("largerValue") int largerValue, Pageable pageable);

    @Query("SELECT c,cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE c.storiesBook.price >= :startPrice AND c.storiesBook.price <= :endPrice " +
            "ORDER BY c.storiesBook.name ASC")
    Page<Object[]> sortASCBooksByPriceRange(@Param("startPrice") int startPrice, @Param("endPrice") int endPrice, Pageable pageable);

    @Query("SELECT c,cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE c.storiesBook.price > :largerValue " +
            "ORDER BY c.storiesBook.name DESC")
    Page<Object[]> sortDESCBooksByPriceRange(@Param("largerValue") int largerValue, Pageable pageable);

    @Query("SELECT c,cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE c.storiesBook.price >= :startPrice AND c.storiesBook.price <= :endPrice " +
            "ORDER BY c.storiesBook.name DESC")
    Page<Object[]> sortDESCBooksByPriceRange(@Param("startPrice") int startPrice, @Param("endPrice") int endPrice, Pageable pageable);


    //  TODO>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> SORT WITH "IS NEW"
    //   TODO SORT WITH GENRE
    @Query("SELECT c, cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE c.storyGenre.name = :storyGenreName ORDER BY c.storiesBook.createdDate DESC")
    Page<Object[]> sortBooksByIsNewGenreName(@Param("storyGenreName") String storyGenreName, Pageable pageable);
    //   TODO SORT WITH AUTHOR
    @Query("SELECT c, cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE c.storyAuthor.name = :authorName ORDER BY c.storiesBook.createdDate DESC")
    Page<Object[]> sortBooksByIsNewAuthorName(@Param("authorName") String authorName, Pageable pageable);
    //   TODO SORT WITH PUBLISHER
    @Query("SELECT c, cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE c.placePublication.name = :placePublicationName ORDER BY c.storiesBook.createdDate DESC")
    Page<Object[]> sortBooksByIsNewPublisherName(@Param("placePublicationName") String placePublicationName, Pageable pageable);

    //   TODO SORT WITH AGE RANGE
    @Query("SELECT c,cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE c.storiesBook.readingAge.age > :largerValue " +
            "ORDER BY c.storiesBook.createdDate DESC")
    Page<Object[]> sortDESCBooksIsNewByAgeRange(@Param("largerValue") int largerValue, Pageable pageable);

    @Query("SELECT c,cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE c.storiesBook.readingAge.age >= :startAge AND c.storiesBook.readingAge.age <= :endAge " +
            "ORDER BY c.storiesBook.createdDate DESC")
    Page<Object[]> sortDESCBooksIsNewByAgeRange(@Param("startAge") int startAge, @Param("endAge") int endAge, Pageable pageable);

    //   TODO SORT WITH PRICE RANGE
    @Query("SELECT c,cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE c.storiesBook.price > :largerValue " +
            "ORDER BY c.storiesBook.createdDate DESC")
    Page<Object[]> sortASCBooksByIsNewPriceRange(@Param("largerValue") int largerValue, Pageable pageable);

    @Query("SELECT c,cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE c.storiesBook.price >= :startPrice AND c.storiesBook.price <= :endPrice " +
            "ORDER BY c.storiesBook.createdDate DESC")
    Page<Object[]> sortDESCBooksByIsNewPriceRange(@Param("startPrice") int startPrice, @Param("endPrice") int endPrice, Pageable pageable);


    //  TODO>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> SORT WITH "IS MOST BUY"
    //   TODO SORT WITH GENRE
    @Query("SELECT c, cd, SUM(COALESCE(ob.quantity, 0)) as totalQuantity FROM Category c " +
            "LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "LEFT JOIN OrderBook ob ON ob.stories = c.storiesBook " +
            "WHERE c.storyGenre.name = :storyGenreName " +
            "GROUP BY c, cd " +
            "HAVING SUM(COALESCE(ob.quantity, 0)) >= :larger " +
            "ORDER BY totalQuantity DESC")
    Page<Object[]> sortBooksByIsMostBuyGenreName(@Param("larger") int larger, @Param("storyGenreName") String storyGenreName, Pageable pageable);

    //   TODO SORT WITH AUTHOR
    @Query("SELECT c, cd, SUM(COALESCE(ob.quantity, 0)) as totalQuantity FROM Category c " +
            "LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "LEFT JOIN OrderBook ob ON ob.stories = c.storiesBook " +
            "WHERE c.storyAuthor.name = :authorName " +
            "GROUP BY c, cd " +
            "HAVING SUM(COALESCE(ob.quantity, 0)) >= :larger " +
            "ORDER BY totalQuantity DESC")
    Page<Object[]> sortBooksByIsMostBuyAuthorName(@Param("larger") int larger, @Param("authorName") String authorName, Pageable pageable);

    //   TODO SORT WITH PUBLISHER
    @Query("SELECT c, cd, SUM(COALESCE(ob.quantity, 0)) as totalQuantity FROM Category c " +
            "LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "LEFT JOIN OrderBook ob ON ob.stories = c.storiesBook " +
            "WHERE c.placePublication.name = :placePublicationName " +
            "GROUP BY c, cd " +
            "HAVING SUM(COALESCE(ob.quantity, 0)) >= :larger " +
            "ORDER BY totalQuantity DESC")
    Page<Object[]> sortBooksByIsMostBuyPlacePublicationName(@Param("larger") int larger, @Param("placePublicationName") String placePublicationName, Pageable pageable);

    //   TODO SORT WITH AGE RANGE
    @Query("SELECT c, cd, SUM(COALESCE(ob.quantity, 0)) as totalQuantity FROM Category c " +
            "LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "LEFT JOIN OrderBook ob ON ob.stories = c.storiesBook " +
            "WHERE c.storiesBook.readingAge.age > :largerValue " +
            "GROUP BY c, cd " +
            "HAVING SUM(COALESCE(ob.quantity, 0)) >= :larger " +
            "ORDER BY totalQuantity DESC")
    Page<Object[]> sortDESCBooksByIsMostBuyAgeRange(@Param("larger") int larger,@Param("largerValue") int largerValue, Pageable pageable);

    @Query("SELECT c, cd, SUM(COALESCE(ob.quantity, 0)) as totalQuantity FROM Category c " +
            "LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "LEFT JOIN OrderBook ob ON ob.stories = c.storiesBook " +
            "WHERE c.storiesBook.readingAge.age >= :startAge AND c.storiesBook.readingAge.age <= :endAge " +
            "GROUP BY c, cd " +
            "HAVING SUM(COALESCE(ob.quantity, 0)) >= :larger " +
            "ORDER BY totalQuantity DESC")
    Page<Object[]> sortDESCBooksByIsMostBuyAgeRange(@Param("larger") int larger,@Param("startAge") int startAge, @Param("endAge") int endAge, Pageable pageable);

    //   TODO SORT WITH PRICE RANGE
    @Query("SELECT c, cd, SUM(COALESCE(ob.quantity, 0)) as totalQuantity FROM Category c " +
            "LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "LEFT JOIN OrderBook ob ON ob.stories = c.storiesBook " +
            "WHERE c.storiesBook.price > :largerValue " +
            "GROUP BY c, cd " +
            "HAVING SUM(COALESCE(ob.quantity, 0)) >= :larger " +
            "ORDER BY totalQuantity DESC")
    Page<Object[]> sortDESCBooksByIsMostBuyPriceRange(@Param("larger") int larger,@Param("largerValue") int largerValue, Pageable pageable);

    @Query("SELECT c, cd, SUM(COALESCE(ob.quantity, 0)) as totalQuantity FROM Category c " +
            "LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "LEFT JOIN OrderBook ob ON ob.stories = c.storiesBook " +
            "WHERE c.storiesBook.price >= :startPrice AND c.storiesBook.price <= :endPrice " +
            "GROUP BY c, cd " +
            "HAVING SUM(COALESCE(ob.quantity, 0)) >= :larger " +
            "ORDER BY totalQuantity DESC")
    Page<Object[]> sortDESCBooksByIsMostBuyPriceRange(@Param("larger") int larger,@Param("startPrice") int startPrice, @Param("endPrice") int endPrice, Pageable pageable);


    //  TODO>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> SORT WITH "IS MOST DISCOUNT"
    //   TODO SORT WITH GENRE
    @Query("SELECT c, cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE c.storyGenre.name = :storyGenreName " +
            "AND cd.reduction_rate IS NOT NULL ORDER BY cd.reduction_rate DESC")
    Page<Object[]> sortBooksByIsMostDiscountGenreName(@Param("storyGenreName") String storyGenreName, Pageable pageable);

    //   TODO SORT WITH AUTHOR
    @Query("SELECT c, cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE c.storyAuthor.name = :authorName " +
            "AND cd.reduction_rate IS NOT NULL ORDER BY cd.reduction_rate DESC")
    Page<Object[]> sortBooksByIsMostDiscountAuthorName(@Param("authorName") String authorName, Pageable pageable);

    //   TODO SORT WITH PUBLISHER
    @Query("SELECT c, cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE c.placePublication.name = :placePublicationName " +
            "AND cd.reduction_rate IS NOT NULL ORDER BY cd.reduction_rate DESC")
    Page<Object[]> sortBooksByIsMostDiscountPublisherName(@Param("placePublicationName") String placePublicationName, Pageable pageable);
    //   TODO SORT WITH AGE RANGE
    @Query("SELECT c,cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE c.storiesBook.readingAge.age > :largerValue " +
            "AND cd.reduction_rate IS NOT NULL ORDER BY cd.reduction_rate DESC")
    Page<Object[]> sortDESCBooksByIsMostDiscountAgeRange(@Param("largerValue") int largerValue, Pageable pageable);

    @Query("SELECT c,cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE c.storiesBook.readingAge.age >= :startAge AND c.storiesBook.readingAge.age <= :endAge " +
            "AND cd.reduction_rate IS NOT NULL ORDER BY cd.reduction_rate DESC")
    Page<Object[]> sortDESCBooksByIsMostDiscountAgeRange(@Param("startAge") int startAge, @Param("endAge") int endAge, Pageable pageable);

    //   TODO SORT WITH PRICE RANGE
    @Query("SELECT c,cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE c.storiesBook.price > :largerValue " +
            "AND cd.reduction_rate IS NOT NULL ORDER BY cd.reduction_rate DESC")
    Page<Object[]> sortDESCBooksByIsMostDiscountPriceRange(@Param("largerValue") int largerValue, Pageable pageable);

    @Query("SELECT c,cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE c.storiesBook.price >= :startPrice AND c.storiesBook.price <= :endPrice " +
            "AND cd.reduction_rate IS NOT NULL ORDER BY cd.reduction_rate DESC")
    Page<Object[]> sortDESCBooksByIsMostDiscountPriceRange(@Param("startPrice") int startPrice, @Param("endPrice") int endPrice, Pageable pageable);


    //  TODO>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> SORT WITH "VIEW COUNT DESC"
    //   TODO SORT WITH GENRE
    //   TODO SORT WITH AUTHOR
    //   TODO SORT WITH PUBLISHER


    //  TODO>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> SORT BOOK WITH PRICE
    //   TODO SORT WITH GENRE
    @Query("SELECT c, cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook" +
            " WHERE c.storyGenre.name = :storyGenreName " +
            "ORDER BY c.storiesBook.price -(c.storiesBook.price*(cd.reduction_rate*0.01)) ASC")
    Page<Object[]> sortPriceASCBooksByGenreName(@Param("storyGenreName") String storyGenreName, Pageable pageable);

    @Query("SELECT c, cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook" +
            " WHERE c.storyGenre.name = :storyGenreName " +
            "ORDER BY c.storiesBook.price -(c.storiesBook.price*(cd.reduction_rate*0.01)) DESC")
    Page<Object[]> sortPriceDESCBooksByGenreName(@Param("storyGenreName") String storyGenreName, Pageable pageable);

    //   TODO SORT WITH AUTHOR
    @Query("SELECT c, cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook" +
            " WHERE c.storyAuthor.name = :authorName " +
            "ORDER BY c.storiesBook.price -(c.storiesBook.price*(cd.reduction_rate*0.01)) ASC")
    Page<Object[]> sortPriceASCBooksByAuthorName(@Param("authorName") String authorName, Pageable pageable);

    @Query("SELECT c, cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook" +
            " WHERE c.storyAuthor.name = :authorName " +
            "ORDER BY c.storiesBook.price -(c.storiesBook.price*(cd.reduction_rate*0.01)) DESC")
    Page<Object[]> sortPriceDESCBooksByAuthorName(@Param("authorName") String authorName, Pageable pageable);

    //   TODO SORT WITH PUBLISHER
    @Query("SELECT c, cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook" +
            " WHERE c.placePublication.name = :placePublicationName " +
            "ORDER BY c.storiesBook.price -(c.storiesBook.price*(cd.reduction_rate*0.01)) ASC")
    Page<Object[]> sortPriceASCBooksByPublisherName(@Param("placePublicationName") String placePublicationName, Pageable pageable);

    @Query("SELECT c, cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook" +
            " WHERE c.placePublication.name = :placePublicationName " +
            "ORDER BY c.storiesBook.price -(c.storiesBook.price*(cd.reduction_rate*0.01)) DESC")
    Page<Object[]> sortPriceDESCBooksByPublisherName(@Param("placePublicationName") String placePublicationName, Pageable pageable);

    //   TODO SORT WITH AGE RANGE
    @Query("SELECT c,cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE c.storiesBook.readingAge.age > :largerValue " +
            "ORDER BY c.storiesBook.price -(c.storiesBook.price*(cd.reduction_rate*0.01)) ASC")
    Page<Object[]> sortPriceASCBooksByAgeRange(@Param("largerValue") int largerValue, Pageable pageable);

    @Query("SELECT c,cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE c.storiesBook.readingAge.age >= :startAge AND c.storiesBook.readingAge.age <= :endAge " +
            "ORDER BY c.storiesBook.price -(c.storiesBook.price*(cd.reduction_rate*0.01)) ASC")
    Page<Object[]> sortPriceASCBooksByAgeRange(@Param("startAge") int startAge, @Param("endAge") int endAge, Pageable pageable);

    @Query("SELECT c,cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE c.storiesBook.readingAge.age > :largerValue " +
            "ORDER BY c.storiesBook.price -(c.storiesBook.price*(cd.reduction_rate*0.01)) DESC")
    Page<Object[]> sortPriceDESCBooksByAgeRange(@Param("largerValue") int largerValue, Pageable pageable);

    @Query("SELECT c,cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE c.storiesBook.readingAge.age >= :startAge AND c.storiesBook.readingAge.age <= :endAge " +
            "ORDER BY c.storiesBook.price -(c.storiesBook.price*(cd.reduction_rate*0.01)) DESC")
    Page<Object[]> sortPriceDESCBooksByAgeRange(@Param("startAge") int startAge, @Param("endAge") int endAge, Pageable pageable);

    //   TODO SORT WITH PRICE RANGE
    @Query("SELECT c,cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE c.storiesBook.price > :largerValue " +
            "ORDER BY c.storiesBook.price -(c.storiesBook.price*(cd.reduction_rate*0.01)) ASC")
    Page<Object[]> sortPriceASCBooksByPriceRange(@Param("largerValue") int largerValue, Pageable pageable);

    @Query("SELECT c,cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE c.storiesBook.price >= :startPrice AND c.storiesBook.price <= :endPrice " +
            "ORDER BY c.storiesBook.price -(c.storiesBook.price*(cd.reduction_rate*0.01)) ASC")
    Page<Object[]> sortPriceASCBooksByPriceRange(@Param("startPrice") int startPrice, @Param("endPrice") int endPrice, Pageable pageable);

    @Query("SELECT c,cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE c.storiesBook.price > :largerValue " +
            "ORDER BY c.storiesBook.price -(c.storiesBook.price*(cd.reduction_rate*0.01)) DESC")
    Page<Object[]> sortPriceDESCBooksByPriceRange(@Param("largerValue") int largerValue, Pageable pageable);

    @Query("SELECT c,cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE c.storiesBook.price >= :startPrice AND c.storiesBook.price <= :endPrice " +
            "ORDER BY c.storiesBook.price -(c.storiesBook.price*(cd.reduction_rate*0.01)) DESC")
    Page<Object[]> sortPriceDESCBooksByPriceRange(@Param("startPrice") int startPrice, @Param("endPrice") int endPrice, Pageable pageable);

    //TODO>>>>>>>>>>>>>>>>>>>>>> FIND
    // TODO FIND GENRE
    @Query("SELECT c, cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE c.storyGenre.name = :storyGenreName")
    Page<Object[]> findBooksByGenreName(@Param("storyGenreName") String storyGenreName, Pageable pageable);
    // TODO FIND AUTHOR
    @Query("SELECT c,cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE c.storyAuthor.name = :authorName")
    Page<Object[]> findBooksByAuthorName(@Param("authorName") String authorName, Pageable pageable);
    // TODO FIND PUBLISHER
    @Query("SELECT c,cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE c.placePublication.name = :placePublicationName")
    Page<Object[]> findBooksByPublisherName(@Param("placePublicationName") String placePublicationName, Pageable pageable);

    // TODO FIND RANGE AGE
    @Query("SELECT c,cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE c.storiesBook.readingAge.age > :largerValue")
    Page<Object[]> findBooksByAgeRange(@Param("largerValue") int largerValue, Pageable pageable);

    @Query("SELECT c,cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE c.storiesBook.readingAge.age >= :startAge AND c.storiesBook.readingAge.age <= :endAge")
    Page<Object[]> findBooksByAgeRange(@Param("startAge") int startAge, @Param("endAge") int endAge, Pageable pageable);

    // TODO FIND PRICE RANGE
    @Query("SELECT c,cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE c.storiesBook.price > :largerValue")
    Page<Object[]> findBooksByPriceRange(@Param("largerValue") int largerValue, Pageable pageable);

    @Query("SELECT c,cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE c.storiesBook.price >= :startPrice AND c.storiesBook.price <= :endPrice")
    Page<Object[]> findBooksByPriceRange(@Param("startPrice") int startPrice, @Param("endPrice") int endPrice, Pageable pageable);

    // query search on header front-end with "genresOption" is value=>"All"
    @Query("SELECT c,cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook WHERE LOWER(c.storiesBook.name) LIKE CONCAT(:nameBook, '%')")
    List<Object[]> findBooksByGenresOptionAndNameBook(@Param("nameBook") String nameBook);

    // query search on header front-end with "genresOption" different with value=>"All"
    @Query("SELECT c, cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE c.storyGenre.name = :genresOption AND LOWER(c.storiesBook.name) LIKE CONCAT('%', LOWER(:nameBook), '%')")
    List<Object[]> findBooksByGenresOptionAndNameBook(@Param("genresOption") String genresOption, @Param("nameBook") String nameBook);

    // TODO LIST PRODUCT SAME
    @Query("SELECT c,cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE c.storyAuthor.name = :authorName")
    List<Object[]> findBooksByAuthorName(@Param("authorName") String nameBook);

    @Query("SELECT c, cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE c.storyGenre.name = :genreName")
    List<Object[]> findBooksByGenreName(@Param("genreName") String genreName);

    @Query("SELECT c, cd FROM Category c LEFT JOIN ComicDiscount cd ON c.storiesBook = cd.storiesBook " +
            "WHERE c.storyTranslator.name = :translatorName")
    List<Object[]> findBooksByTranslatorName(@Param("translatorName") String translatorName);


}
