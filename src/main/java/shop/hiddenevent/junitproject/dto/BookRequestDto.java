package shop.hiddenevent.junitproject.dto;

import lombok.*;
import lombok.experimental.UtilityClass;

@UtilityClass // 멤버 변수 없이 inner 클래스만 존재할때 사용
public class BookRequestDto {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Create {
        private String title;
        private String author;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Modify {
        private String title;
        private String author;
    }

}
