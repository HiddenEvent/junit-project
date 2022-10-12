package shop.hiddenevent.junitproject.repository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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

    private final String _title = "junit";
    private final String _author = "리차드킴";
    private final String _id = IdGenerator.generate();

    //    @BeforeAll // 테스트 시작전에 한번만 실행
    @BeforeEach  /* 각 테스트 시작전에 한번씩 실행 */
    void 공통_given() {

        // 가정 1: {데이터준비() + 1 책등록}, {데이터준비() + 2 책목록보기}
        // 가정 2: {데이터준비() + 1 책등록 + 데이터준비() + 2 책목록보기}

        Book book = Book.AllArgsSaveBuilder()
                .id(_id)
                .title(_title)
                .author(_author)
                .build();
        bookRepository.save(book);
    }

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
;

        // when (테스트 실행)
        List<Book> booksPS = bookRepository.findAll();
        System.out.println("사이즈 ? : "+booksPS.size());

        // then (테스트 검증)
        assertEquals(_title, booksPS.get(0).getTitle());
        assertEquals(_author, booksPS.get(0).getAuthor());

    }

    // 3. 책 한건 보기
    @Test
    void 책한건보기_test() {
        //given

        // when
        Book bookPS = bookRepository.findById(_id).get();

        // then
        assertEquals(_title, bookPS.getTitle());
        assertEquals(_author, bookPS.getAuthor());

    }

    // 4. 책 수정

    // 5. 책 삭제


}