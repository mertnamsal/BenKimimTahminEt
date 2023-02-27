package com.mert.dto.response;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SoruResponseDto {
    private String soruicerik;
    private int puan;

}
