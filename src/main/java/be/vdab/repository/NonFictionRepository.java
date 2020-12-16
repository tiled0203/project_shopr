package be.vdab.repository;

import be.vdab.domain.item.Book;
import be.vdab.domain.item.book_type.Fiction;
import be.vdab.domain.item.book_type.NonFiction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NonFictionRepository extends JpaRepository<NonFiction, Long> {

    default void createNonFiction(NonFiction nonFiction) {
        save(nonFiction);
    }

    @Query("select b from Book b where b.book_type = 'NON_FICTION' order by b.title, b.author, b.price asc")
    List<Book> getAllFictions();

    NonFiction getNonFictionById(long id);

    NonFiction getNonFictionByTitle(String title);

    default void updateNonFiction(NonFiction nonFiction) {
        save(nonFiction);
    }

    default void deleteNonFiction(NonFiction nonFiction) {
        delete(nonFiction);
    }


}