package com.product.repository.port;

import com.product.domain.Upload;
import com.product.utility.RequestPaginate;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

public interface LoadUploadPort {
    Page<Upload> loadAllUploadPagination(RequestPaginate requestPaginate) throws Exception;
    Optional<Upload> loadUploadById(UUID uuid) throws Exception;
}
