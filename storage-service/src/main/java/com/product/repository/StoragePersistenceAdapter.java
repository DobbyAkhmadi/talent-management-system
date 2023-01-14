package com.product.repository;

import com.product.domain.Storage;
import com.product.exception.NotFoundException;
import com.product.exception.SystemException;
import com.product.repository.port.DeleteStoragePort;
import com.product.repository.port.LoadStoragePort;
import com.product.repository.port.SaveStoragePort;
import com.product.utility.RequestPaginate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
public class StoragePersistenceAdapter implements LoadStoragePort, SaveStoragePort, DeleteStoragePort {
    private final StorageRepository storageRepository;

    @Override
    public Page<Storage> loadAllStoragePagination(RequestPaginate requestPaginate) throws NotFoundException {
        try {
            Pageable pageable = PageRequest.of(requestPaginate.getPageIndex(), requestPaginate.getPageSize());
            log.info("load paginate from repository");
            return storageRepository.findAll(pageable);
        } catch (Exception e) {
            log.info("error from loadAllStoragePagination repository : " + e);
            throw new NotFoundException();
        }
    }

    @Override
    public Optional<Storage> loadStorageById(UUID uuid) throws NotFoundException {
        try {
            log.info("load from repository by id : " + uuid);
            return Optional.of(storageRepository.findById(uuid).orElseThrow(NotFoundException::new));
        } catch (Exception e) {
            log.info("error from loadStorageById repository : " + e);
            throw new NotFoundException();
        }
    }

    @Override
    public Optional<Storage> loadStorageByColumns(String columns) throws NotFoundException {
        try {
            log.info("load from repository by " + columns);
            return Optional.of(storageRepository.getByColumn(columns));
        } catch (Exception e) {
            log.info("error from loadStorageByColumns repository : " + e);
            throw new NotFoundException();
        }
    }

    @Override
    public Storage store(Storage storage) throws SystemException {
        try {
            log.info("store from repository " + storage);
            return storageRepository.save(storage);
        } catch (Exception e) {
            log.info("error from store repository : " + e);
            throw new SystemException();
        }
    }

    @Override
    public Storage update(UUID uuid, Storage storage) throws SystemException {
        try {
            Storage newUpdatedStorage = loadStorageById(uuid).orElseThrow(Exception::new);
            newUpdatedStorage.setFileName(storage.getFileName());
            newUpdatedStorage.setFileUrl(storage.getFileUrl());
            log.info("update from repository with id : " + uuid);
            return storageRepository.save(newUpdatedStorage);
        } catch (Exception e) {
            log.info("error from update repository : " + e);
            throw new SystemException();
        }
    }

    @Override
    public void deleteStorageById(UUID uuid) throws NotFoundException {
        try {
            log.info("delete from repository with id : " + uuid);
            storageRepository.deleteById(uuid);
        } catch (Exception e) {
            log.info("error from deleteStorageById repository : " + e);
            throw new NotFoundException();
        }
    }
}
