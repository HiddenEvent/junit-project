package shop.hiddenevent.junitproject.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.hiddenevent.junitproject.dto.BookRequestDto;
import shop.hiddenevent.junitproject.dto.BookResponseDto;
import shop.hiddenevent.junitproject.dto.CommonResponseDto;
import shop.hiddenevent.junitproject.service.BookService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class BookApiController {

    private final BookService bookService;

    // 1. 책등록
    @PostMapping("/v1/book")
    public ResponseEntity<?> createBook(@RequestBody @Valid BookRequestDto.Create requestDto, BindingResult bindingResult ) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            throw new RuntimeException(errorMap.toString());
        }
        BookResponseDto.Create responseDto = bookService.createBook(requestDto);
        return ResponseEntity.ok().body(CommonResponseDto.builder()
                    .code(1)
                    .msg("글 저장 성공")
                    .body(responseDto)
                    .build());
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
