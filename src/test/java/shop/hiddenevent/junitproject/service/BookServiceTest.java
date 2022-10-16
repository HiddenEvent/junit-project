package shop.hiddenevent.junitproject.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import shop.hiddenevent.junitproject.domain.Book;
import shop.hiddenevent.junitproject.dto.BookRequestDto;
import shop.hiddenevent.junitproject.dto.BookResponseDto;
import shop.hiddenevent.junitproject.repository.BookRepository;
import shop.hiddenevent.junitproject.util.idgenerator.IdGenerator;
import shop.hiddenevent.junitproject.util.mail.MailSender;
import shop.hiddenevent.junitproject.util.mail.MailSenderStub;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.*;


@ExtendWith(MockitoExtension.class) /*가짜 메모리 환경*/
class BookServiceTest {
    @InjectMocks /*@Mock으로 선언된 가짜 환경을 주입해준다.*/
    private BookService bookService;

    @Mock /* 가짜 객체 */
    private BookRepository bookRepository;

    @Mock /* 가짜 객체 */
    private MailSender mailSender;

    @Test
    void 책등록하기_테스트() {
        //given
        BookRequestDto.Create dto = new BookRequestDto.Create();
        dto.setTitle("제목이다");
        dto.setAuthor("리차드킴이다.");
        String id = IdGenerator.generate();

        // stub - 행동 정의
        when(bookRepository.save(any())) /* any 함수는 어떤 값이 들어가든 상관없다는 뜻 */
                .thenReturn(Book.AllArgsSaveBuilder()
                        .id(id)
                        .title(dto.getTitle())
                        .author(dto.getAuthor())
                        .build()); /* bookRepository.save() 함수는  thenReturn 의 값으로 리턴 줘라*/
        /* mailSender.send()함수는  true 의 값으로 리턴 줘라*/
        when(mailSender.send()).thenReturn(true);

        // when
        BookResponseDto.Create responseDto = bookService.createBook(dto);

        // then  = >
//        assertEquals(dto.getTitle(), responseDto.getTitle());
//        assertEquals(dto.getAuthor(), responseDto.getAuthor());

        // https://assertj.github.io/doc/ 의존 추가 후 변경
        assertThat(dto.getTitle()).isEqualTo(responseDto.getTitle());
        assertThat(dto.getAuthor()).isEqualTo(responseDto.getAuthor());
    }

}