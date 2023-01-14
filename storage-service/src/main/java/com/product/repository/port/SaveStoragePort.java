package com.product.repository.port;


import com.product.domain.Storage;
import com.product.exception.SystemException;

import java.util.UUID;

public interface SaveStoragePort {
    Storage store(Storage partner) throws SystemException;
    Storage update(UUID uuid, Storage partner) throws SystemException;
}
