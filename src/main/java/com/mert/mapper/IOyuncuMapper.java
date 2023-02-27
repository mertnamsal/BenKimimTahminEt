package com.mert.mapper;

import com.mert.dto.request.OyuncuRequestDto;
import com.mert.dto.response.OyuncuResponseDto;
import com.mert.repository.entity.Oyuncu;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IOyuncuMapper {
    IOyuncuMapper INSTANCE = Mappers.getMapper(IOyuncuMapper.class);
    Oyuncu toOyuncu (final OyuncuRequestDto dto);
    OyuncuResponseDto toOyuncuResponseDto(final Oyuncu oyuncu);
}
