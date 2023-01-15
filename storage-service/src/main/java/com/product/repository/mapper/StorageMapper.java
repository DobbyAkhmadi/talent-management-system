package com.product.repository.mapper;


import com.product.domain.Storage;
import com.product.application.response.StorageResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StorageMapper {
    StorageMapper MAPPER = Mappers.getMapper(StorageMapper.class);
    StorageResponseDto mapToStorage(Storage storage);
    Storage mapToStorageDto(StorageResponseDto storageResponseDTO);
    List<StorageResponseDto> mapToStorageDtoList (List<Storage> storageList);
    List<Storage> mapToStorageList (List<StorageResponseDto> partnerDtoList);

}
