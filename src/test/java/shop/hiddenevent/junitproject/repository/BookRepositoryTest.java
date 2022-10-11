package shop.hiddenevent.junitproject.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import shop.hiddenevent.junitproject.common.util.IdGenerator;
import shop.hiddenevent.junitproject.domain.Book;

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
    }

    // 2. 책 목록보기

    // 3. 책 한건 보기

    // 4. 책 수정

    // 5. 책 삭제


}