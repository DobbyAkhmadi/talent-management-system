package com.product.repository.port;

import com.product.domain.Partner;

import java.util.Optional;
import java.util.UUID;

public interface SavePartnerPort {
    Optional<Partner> store(Partner partner) throws Exception;

    Optional<Partner> update(UUID uuid, Partner partner) throws Exception;
}
