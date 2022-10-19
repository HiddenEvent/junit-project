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

        public static Create toDto(Book bookPS) {
            Create dto = new Create();
            dto.id = bookPS.getId();
            dto.title = bookPS.getTitle();
            dto.author = bookPS.getAuthor();
            return dto;
        }
    }

    @NoArgsConstructor
    @Getter
    public static class SearchAll {
        private String id;
        private String title;
        private String author;

        public static SearchAll toDto(Book bookPS) {
            SearchAll dto = new SearchAll();
            dto.id = bookPS.getId();
            dto.title = bookPS.getTitle();
            dto.author = bookPS.getAuthor();
            return dto;
        }
    }

    @NoArgsConstructor
    @Getter
    public static class Detail {
        private String id;
        private String title;
        private String author;

        public static Detail toDto(Book bookPS) {
            Detail dto = new Detail();
            dto.id = bookPS.getId();
            dto.title = bookPS.getTitle();
            dto.author = bookPS.getAuthor();
            return dto;
        }
    }

    @NoArgsConstructor
    @Getter
    public static class Modify {
        private String id;
        private String title;
        private String author;

        public static Modify toDto(Book bookPS) {
            Modify dto = new Modify();
            dto.id = bookPS.getId();
            dto.title = bookPS.getTitle();
            dto.author = bookPS.getAuthor();
            return dto;
        }
    }
}
