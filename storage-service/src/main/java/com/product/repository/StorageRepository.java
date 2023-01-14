package com.product.repository;

import com.product.domain.Storage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StorageRepository extends JpaRepository<Storage, UUID> {
    @Query("SELECT p FROM Storage p WHERE p.fileName LIKE %?1% OR p.fileUrl LIKE %?1%")
    Page<Storage> searchByColumn(String searchKey, Pageable pageable);

    @Query("SELECT p FROM Storage p WHERE p.id = ?1 OR p.fileName = ?1 OR p.fileUrl = ?1")
    Storage getByColumn(String searchKey);
}
