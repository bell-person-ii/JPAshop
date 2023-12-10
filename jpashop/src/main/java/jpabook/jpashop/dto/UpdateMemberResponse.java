package jpabook.jpashop.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UpdateMemberResponse {

    private Long id;
    private String name;
}
