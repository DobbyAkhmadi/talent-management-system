package com.product.repository;

import com.product.domain.Upload;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UploadRepository extends JpaRepository<Upload, UUID> {
    @Query("SELECT p FROM Upload p WHERE p.fileName LIKE %?1% OR p.urlName LIKE %?1%")
    Page<Upload> searchByColumn(String searchKey, Pageable pageable);

    @Query("SELECT p FROM Upload p WHERE p.id = ?1 OR p.fileName = ?1 OR p.urlName = ?1")
    Upload getByColumn(String searchKey);
}
