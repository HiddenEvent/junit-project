package shop.hiddenevent.junitproject.dto;

import lombok.*;
import lombok.experimental.UtilityClass;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@UtilityClass // 멤버 변수 없이 inner 클래스만 존재할때 사용
public class BookRequestDto {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Create {
        @Size(min = 1, max = 50)
        @NotBlank
        private String title;
        @Size(min = 2, max = 20)
        @NotBlank
        private String author;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Modify {
        @Size(min = 1, max = 50)
        private String title;
        @Size(min = 2, max = 20)
        private String author;
    }

}
