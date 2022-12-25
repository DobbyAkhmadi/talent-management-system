package com.product.service;

import com.product.converter.PartnerMapper;
import com.product.domain.Partner;
import com.product.dto.PartnerResponseDTO;
import com.product.repository.port.LoadPartnerPort;
import com.product.utility.RequestPaginate;
import com.product.utility.ResponsePaginate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Slf4j
@Service
public class PartnerService {
    private final LoadPartnerPort loadPartnerPort;
    private final PartnerMapper partnerMapper;

    public ResponsePaginate getPagination(RequestPaginate requestPaginate) throws Exception {
        Page<Partner> partners = loadPartnerPort.loadAllPartnerPagination(requestPaginate);
        assert partners != null;
        List<Partner> content = partners.getContent();
        ResponsePaginate responsePaginate = new ResponsePaginate();
    //    responsePaginate.getData(Arrays.asList(content).stream().collect(content));

        return responsePaginate;
    }

    private PartnerResponseDTO convertDataToDTO(Partner partner) {
        PartnerResponseDTO partnerResponseDTO = new PartnerResponseDTO();
        partnerResponseDTO.setId(partner.getId());
        partnerResponseDTO.setName(partner.getName());
        partnerResponseDTO.setAddress(partner.getAddress());
        partnerResponseDTO.setCreatedAt(partner.getCreatedAt());
        partnerResponseDTO.setUpdatedAt(partner.getUpdatedAt());
        return partnerResponseDTO;
    }

}
