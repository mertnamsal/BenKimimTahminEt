package com.mert.service;

import com.mert.dto.request.OyuncuRequestDto;
import com.mert.dto.request.SoruCevaplaRequestDto;
import com.mert.dto.response.OyuncuResponseDto;
import com.mert.exception.BenKimimException;
import com.mert.exception.ErrorType;
import com.mert.mapper.IOyuncuMapper;
import com.mert.repository.IOyuncuRepository;
import com.mert.repository.entity.Oyuncu;
import com.mert.repository.entity.Soru;
import com.mert.utility.ServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OyuncuService extends ServiceManager<Oyuncu,Long> {

    private final IOyuncuRepository oyuncuRepository;
    private final SoruService soruService;
    public OyuncuService(IOyuncuRepository oyuncuRepository,SoruService soruService) {
        super(oyuncuRepository);
        this.oyuncuRepository = oyuncuRepository;
        this.soruService = soruService;
    }

    public OyuncuResponseDto savedto(OyuncuRequestDto dto) {
        Optional<Oyuncu> oyuncu = oyuncuRepository.findByUsername(dto.getUsername());
        if(oyuncu.isEmpty()){
            Oyuncu oyuncuMapper = IOyuncuMapper.INSTANCE.toOyuncu(dto);
            oyuncuMapper.setHak(5);
            save(oyuncuMapper);
            return IOyuncuMapper.INSTANCE.toOyuncuResponseDto(oyuncuMapper);
        }else{
            throw new BenKimimException(ErrorType.KULLANICI_HATASI,"Böyle bir kullanıcı Mevcut");
        }

    }

    public Boolean controlLogin(OyuncuRequestDto dto) {
        Optional<Oyuncu> oyuncu = oyuncuRepository.findByUsernameAndPassword(dto.getUsername(), dto.getPassword());
        if(oyuncu.isPresent()){
            return true;
        }
        return false;
    }

    public List<OyuncuResponseDto> findAllResponseDtos() {
        List<OyuncuResponseDto> result = new ArrayList<>();
        findAll().forEach(x->{
            result.add(IOyuncuMapper.INSTANCE.toOyuncuResponseDto(x));
        });
        return result;
    }

    public OyuncuResponseDto findByIdOyuncu(Long id) {
        Optional<Oyuncu> oyuncu= findById(id);
        if(oyuncu.isPresent()){
            return IOyuncuMapper.INSTANCE.toOyuncuResponseDto(oyuncu.get());
        }else{
            throw new BenKimimException(ErrorType.KULLANICI_BULUNAMADI);
        }


    }

    public OyuncuResponseDto findByUsername(String username) {
        Optional<Oyuncu> oyuncu = oyuncuRepository.findByUsername(username);
        if(oyuncu.isPresent()){
            return IOyuncuMapper.INSTANCE.toOyuncuResponseDto(oyuncu.get());
        }else{
            throw new BenKimimException(ErrorType.KULLANICI_BULUNAMADI_ISIM);
        }
    }

    public String cevapKontrol(SoruCevaplaRequestDto dto) {
        Optional<Soru> soru = soruService.findById(dto.getSoruid());
        Optional<Oyuncu> oyuncu = oyuncuRepository.findByUsername(dto.getUsername());
        if(soru.isPresent() && oyuncu.isPresent()){
            if(oyuncu.get().getHak()!=0){
                if(soru.get().getDogrucevap().equalsIgnoreCase(dto.getCevap())){
                    oyuncu.get().setPuan(oyuncu.get().getPuan()+soru.get().getPuan());

                    save(oyuncu.get());
                    return "Doğru cevap";
                }else{
                    oyuncu.get().setHak(oyuncu.get().getHak()-1);
                    save(oyuncu.get());
                    return "Yanlış Cevap";
                }
            }
            return "Hakkınız bitmiş";
        }
        return "Böyle bir kullanıcı veya soru yok";
    }

    public List<OyuncuResponseDto> siralamaGetir() {
        List<OyuncuResponseDto> result = new ArrayList<>();
        oyuncuRepository.findByOrderByPuanDesc().forEach(x->{
            result.add(IOyuncuMapper.INSTANCE.toOyuncuResponseDto(x));
        });
        return result;
    }
}
