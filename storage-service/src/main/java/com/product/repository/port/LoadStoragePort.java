package com.product.repository.port;

import com.product.domain.Storage;
import com.product.exception.NotFoundException;
import com.product.utility.RequestPaginate;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

public interface LoadStoragePort {
    Page<Storage> loadAllStoragePagination(RequestPaginate requestPaginate) throws NotFoundException;
    Optional<Storage> loadStorageById(UUID uuid) throws NotFoundException;
    Optional<Storage> loadStorageByColumns(String columns,String values) throws NotFoundException;
}
