package com.product.repository.port;

import com.product.domain.Partner;
import com.product.exception.NotFoundException;
import com.product.utility.RequestPaginate;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

public interface LoadPartnerPort {
    Page<Partner> loadAllPartnerPagination(RequestPaginate requestPaginate) throws NotFoundException;
    Optional<Partner> loadPartnerById(UUID uuid) throws NotFoundException;
    Optional<Partner> loadPartnerByColumns(String columns,String values) throws NotFoundException;
}
