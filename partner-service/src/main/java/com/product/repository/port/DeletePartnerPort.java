package com.product.repository.port;

import com.product.exception.NotFoundException;

import java.util.UUID;

public interface DeletePartnerPort {
    void deletePartnerById (UUID uuid )throws NotFoundException;
}
