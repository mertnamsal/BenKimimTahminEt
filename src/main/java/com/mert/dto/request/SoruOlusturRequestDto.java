package com.mert.dto.request;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SoruOlusturRequestDto {

    String soruicerik;
    String dogrucevap;
    int puan;
}
