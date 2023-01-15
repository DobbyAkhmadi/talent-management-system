package com.product.repository.port;


import com.product.domain.Storage;
import com.product.exception.SystemException;

public interface SaveStoragePort {
    Storage store(Storage storage) throws SystemException;
}
