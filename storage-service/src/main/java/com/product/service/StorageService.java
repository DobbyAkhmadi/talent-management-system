package com.product.service;

import com.product.application.request.StorageRequestDto;
import com.product.application.usecase.IStorageUseCase;
import com.product.domain.Storage;
import com.product.exception.NotFoundException;
import com.product.exception.SystemException;
import com.product.repository.mapper.StorageMapper;
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
public class StorageService implements IStorageUseCase {
    private final SaveStoragePort saveStoragePort;
    private final LoadStoragePort loadStoragePort;
    private final StorageMapper storageMapper;

    public ResponsePaginate getPagination(RequestPaginate requestPaginate) throws SystemException {
        try {
            Page<Storage> storagePage = loadStoragePort.loadAllStoragePagination(requestPaginate);
            assert storagePage != null;
            List<Storage> content = storagePage.getContent();

            ResponsePaginate responsePaginate = new ResponsePaginate();
            responsePaginate.setStatus(HttpStatus.OK);
            responsePaginate.setCode(HttpStatus.OK.value());
            responsePaginate.setData(storageMapper.mapToStorageDtoList(content));
            responsePaginate.setPageIndex(storagePage.getNumber());
            responsePaginate.setPageSize(storagePage.getSize());
            responsePaginate.setTotalElements(storagePage.getTotalElements());
            responsePaginate.setTotalPages(storagePage.getTotalPages());
            responsePaginate.setNextPage(storagePage.getPageable().next().getPageNumber());
            responsePaginate.setPreviousPage(storagePage.getPageable().previousOrFirst().getPageNumber());

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

    @Override
    public CustomResponse getStorageByCode(String code) throws NotFoundException {
        try {
            Optional<Storage> storageOptional = loadStoragePort.loadStorageByColumns("flagCode", code);
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

    public CustomResponse storeStorage(StorageRequestDto requestDTO) throws SystemException {
        try {

            Storage newStorage = new Storage();
            newStorage.setFileName(requestDTO.getFile().getOriginalFilename());
            newStorage.setContentType(requestDTO.getFile().getContentType());
            newStorage.setFileSize(requestDTO.getFile().getSize());

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

}
