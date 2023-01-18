package com.product.application.usecase;

import com.product.application.request.PartnerRequestDTO;
import com.product.exception.NotFoundException;
import com.product.exception.SystemException;
import com.product.utility.CustomResponse;
import com.product.utility.RequestPaginate;
import com.product.utility.ResponsePaginate;

import java.util.UUID;

public interface IPartnerUseCase {
    ResponsePaginate getPagination(RequestPaginate requestPaginate) throws SystemException;

    CustomResponse storePartner(PartnerRequestDTO requestDTO) throws SystemException;

    CustomResponse updatePartner(UUID id, PartnerRequestDTO requestDTO) throws SystemException;

    CustomResponse getPartnerById(UUID uuid) throws NotFoundException;
}
