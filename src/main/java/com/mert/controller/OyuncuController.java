package com.mert.controller;

import com.mert.dto.request.OyuncuRequestDto;
import com.mert.dto.request.SoruCevaplaRequestDto;
import com.mert.dto.response.OyuncuResponseDto;
import com.mert.service.OyuncuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mert.constant.EndPoint.*;
@RestController
@RequiredArgsConstructor
@RequestMapping(VERSION+API+OYUNCU)
public class OyuncuController {

    private final OyuncuService oyuncuService;

    @PostMapping(REGISTER)
    @CrossOrigin(origins = "*")
    public ResponseEntity<OyuncuResponseDto> register(@RequestBody OyuncuRequestDto dto){

        return ResponseEntity.ok(oyuncuService.savedto(dto));
    }
    @GetMapping(LOGIN)
    @CrossOrigin(origins = "*")
    public ResponseEntity<Boolean> login(OyuncuRequestDto dto){
        return ResponseEntity.ok(oyuncuService.controlLogin(dto));
    }
    @GetMapping(FINDALL)
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<OyuncuResponseDto>> findAll(){
        return ResponseEntity.ok(oyuncuService.findAllResponseDtos());
    }
    @GetMapping(FINDBYID)
    @CrossOrigin(origins = "*")
    public ResponseEntity<OyuncuResponseDto> findById(Long id){
        return ResponseEntity.ok(oyuncuService.findByIdOyuncu(id));
    }
    @GetMapping(FINDBYNAME)
    @CrossOrigin(origins = "*")
    public ResponseEntity<OyuncuResponseDto> findByUsername(String username){
        return ResponseEntity.ok(oyuncuService.findByUsername(username));
    }
    @GetMapping(SORUCEVAPLA)
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> soruCevapla(SoruCevaplaRequestDto dto){
        return ResponseEntity.ok(oyuncuService.cevapKontrol(dto));
    }
    @GetMapping(SIRALAMA)
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<OyuncuResponseDto>> siralama(){
        return ResponseEntity.ok(oyuncuService.siralamaGetir());
    }

}
