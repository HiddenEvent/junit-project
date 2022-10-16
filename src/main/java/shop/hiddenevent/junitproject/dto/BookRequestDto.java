package shop.hiddenevent.junitproject.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.UtilityClass;

@UtilityClass
public class BookRequestDto {

    @Getter
    @Setter
    public static class Create {
        private String title;
        private String author;
    }

    @Getter
    @Setter
    public static class Modify {
        private String title;
        private String author;
    }

}
