package com.mert.dto.request;

import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OyuncuRequestDto {

    private String username;
    private String password;
}
