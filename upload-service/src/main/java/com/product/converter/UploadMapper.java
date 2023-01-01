package com.product.converter;

import com.product.domain.Upload;
import com.product.dto.UploadResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UploadMapper {
    UploadMapper MAPPER = Mappers.getMapper(UploadMapper.class);
    UploadResponseDTO toPartner(Upload upload);
    Upload toPartnerDto(UploadResponseDTO uploadResponseDTO);
    List<UploadResponseDTO> toUploadDtoList (List<Upload> uploadList);
    List<Upload> toPartnerList (List<UploadResponseDTO> uploadResponseDTOList);

}
