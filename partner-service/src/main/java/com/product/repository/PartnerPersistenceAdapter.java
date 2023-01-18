package com.product.repository;

import com.product.domain.Partner;
import com.product.exception.SystemException;
import com.product.repository.port.DeletePartnerPort;
import com.product.repository.port.LoadPartnerPort;
import com.product.repository.port.SavePartnerPort;
import com.product.exception.NotFoundException;
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
    public Page<Partner> loadAllPartnerPagination(RequestPaginate requestPaginate) throws NotFoundException {
        try {
            Pageable pageable = PageRequest.of(requestPaginate.getPageIndex(), requestPaginate.getPageSize());
            log.info("load paginate from repository");
            return partnerRepository.findAll(pageable);
        } catch (Exception e) {
            log.info("error from loadAllPartnerPagination repository : " + e);
            throw new NotFoundException();
        }
    }

    @Override
    public Optional<Partner> loadPartnerById(UUID uuid) throws NotFoundException {
        try {
            log.info("load from repository by id : " + uuid);
            return Optional.of(partnerRepository.findById(uuid).orElseThrow(NotFoundException::new));
        } catch (Exception e) {
            log.info("error from loadPartnerById repository : " + e);
            throw new NotFoundException();
        }
    }

    @Override
    public Optional<Partner> loadPartnerByColumns(String columns,String values) throws NotFoundException {
        try {
            log.info("load from repository by " + columns+values);
            return Optional.of(partnerRepository.getByColumns(columns,values));
        } catch (Exception e) {
            log.info("error from loadPartnerByColumns repository : " + e);
            throw new NotFoundException();
        }
    }

    @Override
    public Partner store(Partner partner) throws SystemException {
        try {
            log.info("store from repository " + partner);
            return partnerRepository.save(partner);
        } catch (Exception e) {
            log.info("error from store repository : " + e);
            throw new SystemException();
        }
    }

    @Override
    public Partner update(UUID uuid, Partner partner) throws SystemException {
        try {
            Partner partner1 = loadPartnerById(uuid).orElseThrow(Exception::new);
            partner1.setName(partner.getName());
            partner1.setAddress(partner.getAddress());
            log.info("update from repository with id : " + uuid);
            return partnerRepository.save(partner1);
        } catch (Exception e) {
            log.info("error from update repository : " + e);
            throw new SystemException();
        }
    }

    @Override
    public void deletePartnerById(UUID uuid) throws NotFoundException {
        try {
            log.info("delete from repository with id : " + uuid);
            partnerRepository.deleteById(uuid);
        } catch (Exception e) {
            log.info("error from deletePartnerById repository : " + e);
            throw new NotFoundException();
        }
    }
}
