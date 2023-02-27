package com.mert.controller;

import com.mert.dto.request.IdRequestDto;
import com.mert.dto.request.SoruOlusturRequestDto;
import com.mert.dto.response.ResultDto;
import com.mert.dto.response.SoruResponseDto;
import com.mert.service.SoruService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.mert.constant.EndPoint.*;
@RestController
@RequiredArgsConstructor
@RequestMapping(VERSION+API+SORU)
public class SoruController {
    private final SoruService soruService;

    @PostMapping(OLUSTUR)
    @CrossOrigin(origins = "*")
    public ResponseEntity<ResultDto> soruOlustur(@RequestBody SoruOlusturRequestDto dto){
        soruService.soruOlustur(dto);
        return ResponseEntity.ok(ResultDto.builder().state(true).build());
    }
    @GetMapping(GETIR)
    @CrossOrigin(origins = "*")
    public ResponseEntity<SoruResponseDto> soruGetir(IdRequestDto dto){
        return ResponseEntity.ok(soruService.soruGetir(dto));
    }



}
