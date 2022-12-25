package com.product.repository;

import com.product.domain.Partner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, UUID> {
    @Query("SELECT p FROM Partner p WHERE p.name LIKE %?1% OR p.address LIKE %?1%")
    Page<Partner> searchByColumn(String searchKey, Pageable pageable);

    @Query("SELECT p FROM Partner p WHERE p.id = ?1 OR p.name = ?1 OR p.address = ?1")
    Partner getByColumn(String searchKey);
}
