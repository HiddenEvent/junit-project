package shop.hiddenevent.junitproject.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import shop.hiddenevent.junitproject.domain.Book;
import shop.hiddenevent.junitproject.dto.BookRequestDto;
import shop.hiddenevent.junitproject.repository.BookRepository;
import shop.hiddenevent.junitproject.service.BookService;
import shop.hiddenevent.junitproject.util.idgenerator.IdGenerator;

import static org.assertj.core.api.Assertions.assertThat;

// 통합테스트
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookApiControllerTest {
    @Autowired // DI
    private BookRepository bookRepository;
    @Autowired
    private BookService bookService;
    @Autowired
    private TestRestTemplate rt;

    private static ObjectMapper om;
    private static HttpHeaders headers;

    private final String _title = "junit";
    private final String _author = "리차드킴";
    private final String _id = IdGenerator.generate();

    @BeforeAll //시작할떄 1번만
    public static void init() {
        om = new ObjectMapper();
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

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

    @Test
    void createBook() throws JsonProcessingException {
        // given
        BookRequestDto.Create requestDto = new BookRequestDto.Create();
        requestDto.setTitle("타이틀");
        requestDto.setAuthor("저작자");
        String body = om.writeValueAsString(requestDto);

        System.out.println(body);

        // when
        HttpEntity<String> request = new HttpEntity<>(body, headers);

        ResponseEntity<String> response = rt.exchange("/api/v1/book", HttpMethod.POST, request, String.class);

        // then
        DocumentContext dc = JsonPath.parse(response.getBody()); // String 데이터를 Json형식으로 파싱
        String title = dc.read("$.title");
        String author = dc.read("$.author");

        assertThat(title).isEqualTo("타이틀");
        assertThat(author).isEqualTo("저작자");
    }

    @Test
    void searchAllBook() {
        // given

        //when
        HttpEntity<String> request = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = rt.exchange("/api/v1/book", HttpMethod.GET, request, String.class);

        // then
        DocumentContext dc = JsonPath.parse(response.getBody()); // String 데이터를 Json형식으로 파싱
        String title = dc.read("$.[0].title");
        String author = dc.read("$.[0].author");
        assertThat(title).isEqualTo(_title);
        assertThat(author).isEqualTo(_author);
    }

    @Test
    void searchBook() {
    }

    @Test
    void deleteBook() {
    }

    @Test
    void modifyBook() {
    }
}