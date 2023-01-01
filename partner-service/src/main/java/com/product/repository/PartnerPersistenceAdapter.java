package com.product.repository;

import com.product.domain.Partner;
import com.product.repository.port.DeletePartnerPort;
import com.product.repository.port.LoadPartnerPort;
import com.product.repository.port.SavePartnerPort;
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
public class PartnerPersistenceAdapter implements LoadPartnerPort, SavePartnerPort, DeletePartnerPort {
    private final PartnerRepository partnerRepository;

    @Override
    public Page<Partner> loadAllPartnerPagination(RequestPaginate requestPaginate) throws Exception {
        try {
            Pageable pageable = PageRequest.of(requestPaginate.getPageIndex(), requestPaginate.getPageSize());
            log.info("load from repository");
            return partnerRepository.findAll(pageable);
        } catch (Exception e) {
            log.info("error from repository : " + e);
            throw new Exception();
        }
    }

    @Override
    public Optional<Partner> loadPartnerById(UUID uuid) throws Exception {
        try {
            log.info("load from repository by id");
            return Optional.of(partnerRepository.findById(uuid).orElseThrow(Exception::new));
        } catch (Exception e) {
            log.info("error from repository : " + e);
            throw new Exception();
        }
    }

    @Override
    public Optional<Partner> loadPartnerByColumns(String columns) throws Exception {
        try {
            log.info("load from repository by " + columns);
            return Optional.of(partnerRepository.getByColumn(columns));
        } catch (Exception e) {
            log.info("error from repository : " + e);
            throw new Exception();
        }
    }

    @Override
    public Partner store(Partner partner) throws Exception {
        try {
            log.info("store from repository");
            return partnerRepository.save(partner);
        } catch (Exception e) {
            log.info("error from repository : " + e);
            throw new Exception();
        }
    }

    @Override
    public Partner update(UUID uuid, Partner partner) throws Exception {
        try {
            Partner partner1 = loadPartnerById(uuid).orElseThrow(Exception::new);
            partner1.setName(partner.getName());
            partner1.setAddress(partner.getAddress());
            log.info("update from repository");
            return partnerRepository.save(partner1);
        } catch (Exception e) {
            log.info("error from repository : " + e);
            throw new Exception();
        }
    }

    @Override
    public void deletePartnerById(UUID uuid) throws Exception {
        try {
            log.info("delete from repository");
            partnerRepository.deleteById(uuid);
        } catch (Exception e) {
            log.info("error from repository : " + e);
            throw new Exception();
        }
    }
}
