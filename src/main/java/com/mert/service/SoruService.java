package com.mert.service;

import com.mert.dto.request.IdRequestDto;
import com.mert.dto.request.SoruOlusturRequestDto;
import com.mert.dto.response.SoruResponseDto;
import com.mert.mapper.ISoruMapper;
import com.mert.repository.ISoruRepository;
import com.mert.repository.entity.Soru;
import com.mert.utility.ServiceManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SoruService extends ServiceManager<Soru,Long> {
    private final ISoruRepository soruRepository;
    public SoruService(ISoruRepository soruRepository) {
        super(soruRepository);
        this.soruRepository= soruRepository;
    }

    public void soruOlustur(SoruOlusturRequestDto dto) {
        save(ISoruMapper.INSTANCE.toSoru(dto));
    }

    public SoruResponseDto soruGetir(IdRequestDto dto) {
        Optional<Soru> soru = findById(dto.getId());
        if(soru.isPresent()){
            return ISoruMapper.INSTANCE.toSoruResponseDto(soru.get());
        }
        return null;
    }
}
