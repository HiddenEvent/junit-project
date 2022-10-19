package shop.hiddenevent.junitproject.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.hiddenevent.junitproject.dto.BookRequestDto;
import shop.hiddenevent.junitproject.dto.BookResponseDto;
import shop.hiddenevent.junitproject.dto.CommonResponseDto;
import shop.hiddenevent.junitproject.service.BookService;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class BookApiController {

    private final BookService bookService;

    // 1. 책등록
    @PostMapping("/v1/book")
    public ResponseEntity<BookResponseDto.Create> createBook(@RequestBody BookRequestDto.Create requestDto) {
        BookResponseDto.Create responseDto = bookService.createBook(requestDto);
        return ResponseEntity.ok().body(responseDto);
    }
    // 2. 책목록보기
    public ResponseEntity<List<BookResponseDto.SearchAll>> searchAllBook() {
        return null;
    }
    // 3. 책한건보기
    public ResponseEntity<BookResponseDto.Detail> searchBook(String id) {
        return null;
    }
    // 4. 책삭제
    public ResponseEntity<?> deleteBook(String id){
        return null;
    }
    // 5. 책수정
    public ResponseEntity<BookResponseDto.Modify> modifyBook(String id, BookRequestDto.Modify requestDto){
        return null;
    }
}
