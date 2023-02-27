package com.mert.dto.response;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class OyuncuResponseDto {
    private String username;
    private int puan;
    private int hak;
}
