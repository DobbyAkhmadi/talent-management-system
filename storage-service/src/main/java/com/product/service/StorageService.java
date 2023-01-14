package com.product.service;

import com.product.converter.StorageMapper;
import com.product.domain.Storage;
import com.product.dto.StorageRequestDTO;
import com.product.exception.NotFoundException;
import com.product.exception.SystemException;
import com.product.repository.port.LoadStoragePort;
import com.product.repository.port.SaveStoragePort;
import com.product.utility.CustomResponse;
import com.product.utility.RequestPaginate;
import com.product.utility.ResponsePaginate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class StorageService {
    private final SaveStoragePort saveStoragePort;
    private final LoadStoragePort loadStoragePort;
    private final StorageMapper storageMapper;

    public ResponsePaginate getPagination(RequestPaginate requestPaginate) throws SystemException {
        try {
            Page<Storage> partners = loadStoragePort.loadAllStoragePagination(requestPaginate);
            assert partners != null;
            List<Storage> content = partners.getContent();

            ResponsePaginate responsePaginate = new ResponsePaginate();
            responsePaginate.setStatus(HttpStatus.OK);
            responsePaginate.setCode(HttpStatus.OK.value());
            responsePaginate.setData(storageMapper.mapToStorageDtoList(content));
            responsePaginate.setPageIndex(partners.getNumber());
            responsePaginate.setPageSize(partners.getSize());
            responsePaginate.setTotalElements(partners.getTotalElements());
            responsePaginate.setTotalPages(partners.getTotalPages());
            responsePaginate.setNextPage(partners.getPageable().next().getPageNumber());
            responsePaginate.setPreviousPage(partners.getPageable().previousOrFirst().getPageNumber());

            return responsePaginate;
        } catch (Exception e) {
            throw new SystemException(e);
        }

    }

    public CustomResponse getStorageById(UUID uuid) throws NotFoundException {
        try {
            Optional<Storage> storageOptional = loadStoragePort.loadStorageById(uuid);
            CustomResponse customResponse = new CustomResponse();
            if (storageOptional.isPresent()) {
                customResponse.setStatus(HttpStatus.OK);
                customResponse.setCode(HttpStatus.OK.value());
                customResponse.setData(storageMapper.mapToStorage(storageOptional.get()));
            }

            return customResponse;
        } catch (Exception e) {
            throw new NotFoundException(e);
        }

    }

    public CustomResponse storeStorage(StorageRequestDTO requestDTO) throws SystemException {
        try {
            Storage newStorage = new Storage();
            newStorage.setFileName(requestDTO.getFileName());
            newStorage.setFileUrl(requestDTO.getFileUrl());

            Storage storage = saveStoragePort.store(newStorage);

            CustomResponse customResponse = new CustomResponse();
            customResponse.setStatus(HttpStatus.CREATED);
            customResponse.setCode(HttpStatus.CREATED.value());
            customResponse.setData(storageMapper.mapToStorage(storage));
            return customResponse;
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }

    public CustomResponse updateStorage(UUID id, StorageRequestDTO storageRequestDTO) throws SystemException {
        try {

            Storage newStorage = new Storage();
            newStorage.setFileName(storageRequestDTO.getFileName());
            newStorage.setFileUrl(storageRequestDTO.getFileUrl());

            Storage currentStorage = saveStoragePort.update(id, newStorage);

            CustomResponse customResponse = new CustomResponse();
            customResponse.setStatus(HttpStatus.ACCEPTED);
            customResponse.setCode(HttpStatus.ACCEPTED.value());
            customResponse.setData(storageMapper.mapToStorage(currentStorage));
            return customResponse;
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
