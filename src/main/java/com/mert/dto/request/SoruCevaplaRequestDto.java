package com.mert.dto.request;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SoruCevaplaRequestDto {
    private Long soruid;
    private String username;
    private String cevap;

}
