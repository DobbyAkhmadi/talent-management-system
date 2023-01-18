package com.product.repository.mapper;

import com.product.domain.Partner;
import com.product.application.response.PartnerResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PartnerMapper {
    PartnerMapper MAPPER = Mappers.getMapper(PartnerMapper.class);
    PartnerResponseDTO toPartner(Partner partner);
    Partner toPartnerDto(PartnerResponseDTO partnerDto);
    List<PartnerResponseDTO> toPartnerDtoList (List<Partner> partnerList);
    List<Partner> toPartnerList (List<PartnerResponseDTO> partnerDtoList);

}
