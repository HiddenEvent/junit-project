package shop.hiddenevent.junitproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class CommonResponseDto<T> {
    private Integer code;
    private String msg;
    private T body;
}
