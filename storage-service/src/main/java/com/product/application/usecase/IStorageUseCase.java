package com.product.application.usecase;

import com.product.application.request.StorageRequestDto;
import com.product.exception.NotFoundException;
import com.product.exception.SystemException;
import com.product.utility.CustomResponse;
import com.product.utility.RequestPaginate;
import com.product.utility.ResponsePaginate;

import java.util.UUID;

public interface IStorageUseCase {
    ResponsePaginate getPagination(RequestPaginate requestPaginate) throws SystemException;

    CustomResponse getStorageById(UUID uuid) throws NotFoundException;

    CustomResponse getStorageByCode(String code) throws NotFoundException;

    CustomResponse storeStorage(StorageRequestDto requestDTO) throws SystemException;

}
