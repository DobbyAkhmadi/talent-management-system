package com.product.repository.port;

import java.util.UUID;

public interface DeleteUploadPort {
    void deleteUploadById (UUID uuid )throws Exception;
}
