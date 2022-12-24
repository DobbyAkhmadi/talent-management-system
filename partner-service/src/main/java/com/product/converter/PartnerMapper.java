package com.product.converter;

import com.product.domain.Partner;
import com.product.dto.PartnerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Mapper
public interface PartnerMapper {
    PartnerMapper MAPPER = Mappers.getMapper(PartnerMapper.class);
    PartnerResponse toPartner(Partner partner);
    Partner toPartnerDto(PartnerResponse partnerDto);
    List<PartnerResponse> toPartnerDtoList (List<Partner> partnerList);
    List<Partner> toPartnerList (List<PartnerResponse> partnerDtoList);
}
