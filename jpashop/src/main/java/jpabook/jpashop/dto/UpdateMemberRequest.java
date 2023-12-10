package jpabook.jpashop.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UpdateMemberRequest {

    private String name;
}
