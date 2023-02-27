package com.mert.mapper;

import com.mert.dto.request.SoruOlusturRequestDto;
import com.mert.dto.response.SoruResponseDto;
import com.mert.repository.entity.Soru;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface ISoruMapper {
    ISoruMapper INSTANCE = Mappers.getMapper(ISoruMapper.class);
    Soru toSoru(final SoruOlusturRequestDto dto);
    Soru toSoru(final SoruResponseDto dto);
    SoruResponseDto toSoruResponseDto(final Soru soru);
}
