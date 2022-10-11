package shop.hiddenevent.junitproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.hiddenevent.junitproject.domain.Book;

public interface BookRepository extends JpaRepository<Book, String> {
}
