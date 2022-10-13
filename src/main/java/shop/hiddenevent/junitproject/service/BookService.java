package shop.hiddenevent.junitproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.hiddenevent.junitproject.common.util.IdGenerator;
import shop.hiddenevent.junitproject.domain.Book;
import shop.hiddenevent.junitproject.dto.BookRequestDto;
import shop.hiddenevent.junitproject.dto.BookResponseDto;
import shop.hiddenevent.junitproject.repository.BookRepository;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    // 1. 책등록
    @Transactional(rollbackFor = RuntimeException.class)
    public BookResponseDto.Save bookSave(BookRequestDto.Save dto) {
        Book book = Book.AllArgsSaveBuilder()
                .id(IdGenerator.generate())
                .title(dto.getTitle())
                .author(dto.getAuthor())
                .build();
        Book bookPS = bookRepository.save(book);
        return new BookResponseDto.Save().toDto(bookPS);
    }

    // 2. 책목록보기
    // 3. 책한건보기
    // 4. 책삭제
    // 5. 책수정
}
