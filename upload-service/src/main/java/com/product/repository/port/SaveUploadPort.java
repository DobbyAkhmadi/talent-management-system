package com.product.repository.port;

import com.product.domain.Upload;

public interface SaveUploadPort {
    Upload store(Upload upload) throws Exception;
}
