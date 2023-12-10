package jpabook.jpashop.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Result<T> {

    private T data;
}
