package com.product.service;

import com.product.converter.PartnerMapper;
import com.product.domain.Partner;
import com.product.dto.PartnerRequest;
import com.product.dto.PartnerResponse;
import com.product.repository.PartnerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Slf4j
@Service
@Component
public class PartnerService implements IPartnerService{
    private final PartnerMapper partnerMapper;
    private final PartnerRepository partnerRepository;

    public List<PartnerResponse> getAll() {
        List<Partner> partnerList = partnerRepository.findAll();
        log.info("load from repository");
        return partnerMapper.toPartnerDtoList(partnerList);
    }
}
