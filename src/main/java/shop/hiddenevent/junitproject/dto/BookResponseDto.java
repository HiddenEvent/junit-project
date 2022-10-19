package shop.hiddenevent.junitproject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.UtilityClass;
import shop.hiddenevent.junitproject.domain.Book;

@UtilityClass
public class BookResponseDto {
    @NoArgsConstructor
    @Getter
    public static class Create {
        private String id;
        private String title;
        private String author;

        public Create toDto(Book bookPS) {
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

        public static SearchList toDto(Book bookPS) {
            SearchList searchList = new SearchList();
            searchList.id = bookPS.getId();
            searchList.title = bookPS.getTitle();
            searchList.author = bookPS.getAuthor();
            return searchList;
        }
    }
    @NoArgsConstructor
    @Getter
    public static class Detail {
        private String id;
        private String title;
        private String author;

        public Detail toDto(Book bookPS) {
            this.id = bookPS.getId();
            this.title = bookPS.getTitle();
            this.author = bookPS.getAuthor();
            return this;
        }
    }

}
