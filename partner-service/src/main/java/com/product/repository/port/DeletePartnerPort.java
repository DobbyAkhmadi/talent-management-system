package com.product.repository.port;

import java.util.UUID;

public interface DeletePartnerPort {
    void deletePartnerById (UUID uuid )throws Exception;
}
