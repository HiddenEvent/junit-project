package shop.hiddenevent.junitproject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.UtilityClass;
import shop.hiddenevent.junitproject.domain.Book;

@UtilityClass
public class BookResponseDto {
    @NoArgsConstructor
    @Getter
    public static class Save {
        private String id;
        private String title;
        private String author;

        public Save toDto(Book bookPS) {
            this.id = bookPS.getId();
            this.title = bookPS.getTitle();
            this.author = bookPS.getAuthor();
            return this;
        }
    }

    @NoArgsConstructor
    @Getter
    public static class SearchList {
        private String id;
        private String title;
        private String author;

        public SearchList toDto(Book bookPS) {
            this.id = bookPS.getId();
            this.title = bookPS.getTitle();
            this.author = bookPS.getAuthor();
            return this;
        }
    }
}
