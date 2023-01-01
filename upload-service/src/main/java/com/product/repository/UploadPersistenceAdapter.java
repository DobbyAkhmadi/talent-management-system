package com.product.repository;

import com.product.domain.Upload;
import com.product.repository.port.DeleteUploadPort;
import com.product.repository.port.LoadUploadPort;
import com.product.repository.port.SaveUploadPort;
import com.product.utility.RequestPaginate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
public class UploadPersistenceAdapter implements LoadUploadPort, SaveUploadPort, DeleteUploadPort {

    @Override
    public void deleteUploadById(UUID uuid) throws Exception {

    }

    @Override
    public Page<Upload> loadAllUploadPagination(RequestPaginate requestPaginate) throws Exception {
        return null;
    }

    @Override
    public Optional<Upload> loadUploadById(UUID uuid) throws Exception {
        return Optional.empty();
    }

    @Override
    public Upload store(Upload upload) throws Exception {
        return null;
    }
}
