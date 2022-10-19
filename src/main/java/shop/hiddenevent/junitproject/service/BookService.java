package shop.hiddenevent.junitproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.hiddenevent.junitproject.util.idgenerator.IdGenerator;
import shop.hiddenevent.junitproject.domain.Book;
import shop.hiddenevent.junitproject.dto.BookRequestDto;
import shop.hiddenevent.junitproject.dto.BookResponseDto;
import shop.hiddenevent.junitproject.repository.BookRepository;
import shop.hiddenevent.junitproject.util.mail.MailSender;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;
    private final MailSender mailSender;

    // 1. 책등록
    @Transactional(rollbackFor = RuntimeException.class)
    public BookResponseDto.Create createBook(BookRequestDto.Create dto) {
        Book book = Book.AllArgsSaveBuilder()
                .id(IdGenerator.generate())
                .title(dto.getTitle())
                .author(dto.getAuthor())
                .build();
        Book bookPS = bookRepository.save(book);
        if (!mailSender.send()){
            throw new RuntimeException("메일이 전송되지 않았습니다.");
        }
        return BookResponseDto.Create.toDto(bookPS);
    }

    // 2. 책목록보기
    public List<BookResponseDto.SearchAll> searchAllBook() {
        return bookRepository.findAll()
                .stream()
                .map(BookResponseDto.SearchAll::toDto)
                .collect(Collectors.toList());
    }

    // 3. 책한건보기
    public BookResponseDto.Detail searchBook(String id) {
        Optional<Book> bookOP = bookRepository.findById(id);
        if (bookOP.isPresent()) {
            return BookResponseDto.Detail.toDto(bookOP.get());
        } else {
            throw new RuntimeException("해당 아이디를 찾을 수 없습니다.");
        }

    }
    // 4. 책삭제
    @Transactional(rollbackFor = RuntimeException.class)
    public void deleteBook(String id){
        bookRepository.deleteById(id);
    }

    // 5. 책수정
    @Transactional(rollbackFor = RuntimeException.class)
    public void modifyBook(String id, BookRequestDto.Modify dto){
        Optional<Book> bookOP = bookRepository.findById(id);
        if (bookOP.isPresent()) {
            Book book = bookOP.get();
            book.modifyBook(dto.getTitle(), dto.getAuthor());
        } else {
            throw new RuntimeException("해당 아이디를 찾을 수 없습니다.");
        }
    }
}
