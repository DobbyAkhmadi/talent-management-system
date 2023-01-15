package com.product.repository.port;

import com.product.exception.NotFoundException;

import java.util.UUID;

public interface DeleteStoragePort {
    void deleteStorageById (UUID uuid )throws NotFoundException;
}
