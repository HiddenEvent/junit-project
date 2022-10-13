package shop.hiddenevent.junitproject.dto;

import lombok.Getter;
import lombok.experimental.UtilityClass;

@UtilityClass
public class BookRequestDto {

    @Getter
    public static class Save {
        private String title;
        private String author;
    }

}
