package com.product.converter;


import com.product.domain.Storage;
import com.product.dto.StorageResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StorageMapper {
    StorageMapper MAPPER = Mappers.getMapper(StorageMapper.class);
    StorageResponseDTO mapToStorage(Storage storage);
    Storage mapToStorageDto(StorageResponseDTO storageResponseDTO);
    List<StorageResponseDTO> mapToStorageDtoList (List<Storage> storageList);
    List<Storage> mapToStorageList (List<StorageResponseDTO> partnerDtoList);

}
