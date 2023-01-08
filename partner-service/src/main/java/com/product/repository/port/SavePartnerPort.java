package com.product.repository.port;

import com.product.domain.Partner;
import com.product.exception.SystemException;

import java.util.UUID;

public interface SavePartnerPort {
    Partner store(Partner partner) throws SystemException;

    Partner update(UUID uuid, Partner partner) throws SystemException;
}
