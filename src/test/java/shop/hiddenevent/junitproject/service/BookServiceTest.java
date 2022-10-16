package shop.hiddenevent.junitproject.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import shop.hiddenevent.junitproject.dto.BookRequestDto;
import shop.hiddenevent.junitproject.dto.BookResponseDto;
import shop.hiddenevent.junitproject.repository.BookRepository;
import shop.hiddenevent.junitproject.util.mail.MailSenderStub;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class BookServiceTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void 책등록하기_테스트(){
        //given
        BookRequestDto.Create dto = new BookRequestDto.Create();
        dto.setTitle("제목이다");
        dto.setAuthor("리차드킴이다.");

        // stub
        MailSenderStub mailSenderStub = new MailSenderStub();
        // 각짜 Repository 만들기

        // when
        BookService bookService = new BookService(bookRepository, mailSenderStub);
        BookResponseDto.Create responseDto = bookService.createBook(dto);

        // then
        assertEquals(dto.getTitle(), responseDto.getTitle());
        assertEquals(dto.getAuthor(), responseDto.getAuthor());

    }

}