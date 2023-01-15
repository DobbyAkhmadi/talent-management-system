package com.product.repository.base;

import com.product.domain.Storage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BaseRepository extends JpaRepository<Storage, UUID> {
    @Query("SELECT p FROM Storage p WHERE p.fileName LIKE %?1% OR p.flagCode LIKE %?1% OR p.contentType LIKE %?1%")
    Page<Storage> searchByColumn(String searchKey, Pageable pageable);

    @Query("SELECT p FROM Storage p WHERE :columnName = :values")
    Storage getByColumns(String columnName, String values);
}
