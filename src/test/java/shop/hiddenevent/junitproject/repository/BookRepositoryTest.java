package shop.hiddenevent.junitproject.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import shop.hiddenevent.junitproject.common.util.IdGenerator;
import shop.hiddenevent.junitproject.domain.Book;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest // DB와 관련된 컴포넌트만 메모리에 로딩
class BookRepositoryTest {

    @Autowired // DI
    private BookRepository bookRepository;

    // 1. 책 등록
    @Test
    void 책등록_test() {
        // given (데이터 준비)
        String title = "junit5";
        String author = "RichardKim";
        Book book = Book.AllArgsSaveBuilder()
                .id(IdGenerator.generate())
                .title(title)
                .author(author)
                .build();
        System.out.println(book.getId());

        // when (테스트 실행)
        Book bookPS = bookRepository.save(book);
        // then (테스트 검증)
        assertEquals(title, bookPS.getTitle());
        assertEquals(author, bookPS.getAuthor());
    }// 트랜잭션 종료 (저장된 데이터를 초기화함)

    // 2. 책 목록보기
    @Test
    void 책목록보기_test() {
        // given (데이터 준비)
        String title = "junit5";
        String author = "RichardKim";
        Book book = Book.AllArgsSaveBuilder()
                .id(IdGenerator.generate())
                .title(title)
                .author(author)
                .build();
        bookRepository.save(book);

        // when (테스트 실행)
        List<Book> booksPS = bookRepository.findAll();

        // then (테스트 검증)
        assertEquals(title, booksPS.get(0).getTitle());
        assertEquals(author, booksPS.get(0).getAuthor());

    }

    // 3. 책 한건 보기
    @Test
    void 책한건보기_test() {
        //given
        String title = "junit5";
        String author = "RichardKim";
        String id = IdGenerator.generate();
        Book book = Book.AllArgsSaveBuilder()
                .id(id)
                .title(title)
                .author(author)
                .build();
        bookRepository.save(book);

        // when
        Book bookPS = bookRepository.findById(id).get();

        // then
        assertEquals(title, bookPS.getTitle());
        assertEquals(author, bookPS.getAuthor());

    }

    // 4. 책 수정

    // 5. 책 삭제


}