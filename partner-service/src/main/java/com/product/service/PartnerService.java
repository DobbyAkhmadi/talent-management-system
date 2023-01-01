package com.product.service;

import com.product.converter.PartnerMapper;
import com.product.domain.Partner;
import com.product.dto.PartnerRequestDTO;
import com.product.repository.port.LoadPartnerPort;
import com.product.repository.port.SavePartnerPort;
import com.product.utility.CustomResponse;
import com.product.utility.RequestPaginate;
import com.product.utility.ResponsePaginate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RequiredArgsConstructor
@Slf4j
@Service
public class PartnerService {
    private final LoadPartnerPort loadPartnerPort;
    private final SavePartnerPort savePartnerPort;
    private final PartnerMapper partnerMapper;

    public ResponsePaginate getPagination(RequestPaginate requestPaginate) throws Exception {
        Page<Partner> partners = loadPartnerPort.loadAllPartnerPagination(requestPaginate);
        assert partners != null;
        List<Partner> content = partners.getContent();

        ResponsePaginate responsePaginate = new ResponsePaginate();
        responsePaginate.setStatus(HttpStatus.OK);
        responsePaginate.setCode(HttpStatus.OK.value());
        responsePaginate.setData(Collections.singletonList(partnerMapper.toPartnerDtoList(content)));
        responsePaginate.setPageIndex(partners.getNumber());
        responsePaginate.setPageSize(partners.getSize());
        responsePaginate.setTotalElements(partners.getTotalElements());
        responsePaginate.setTotalPages(partners.getTotalPages());
        responsePaginate.setNextPage(partners.getPageable().next().getPageNumber());
        responsePaginate.setPreviousPage(partners.getPageable().previousOrFirst().getPageNumber());

        return responsePaginate;
    }

    public CustomResponse storePartner(PartnerRequestDTO requestDTO) throws Exception {
        try {
            Partner partner = new Partner();
            partner.setName(requestDTO.getName());
            partner.setAddress(requestDTO.getAddress());

            Partner partner2 = savePartnerPort.store(partner);

            CustomResponse customResponse = new CustomResponse();
            customResponse.setStatus(HttpStatus.CREATED);
            customResponse.setCode(HttpStatus.CREATED.value());
            customResponse.setData(partnerMapper.toPartner(partner2));
            return customResponse;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public CustomResponse updatePartner(UUID id, PartnerRequestDTO requestDTO) throws Exception {
        try {

            Partner partner1 = new Partner();
            partner1.setName(requestDTO.getName());
            partner1.setAddress(requestDTO.getAddress());

            Partner partner2 = savePartnerPort.update(id, partner1);

            CustomResponse customResponse = new CustomResponse();
            customResponse.setStatus(HttpStatus.ACCEPTED);
            customResponse.setCode(HttpStatus.ACCEPTED.value());
            customResponse.setData(partnerMapper.toPartner(partner2));
            return customResponse;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }


    public CustomResponse getPartnerById(UUID uuid) throws Exception {
        try {
            Optional<Partner> employeeOptional = loadPartnerPort.loadPartnerById(uuid);
            CustomResponse customResponse = new CustomResponse();
            if (employeeOptional.isPresent()) {
                customResponse.setStatus(HttpStatus.OK);
                customResponse.setCode(HttpStatus.OK.value());
                customResponse.setData(partnerMapper.toPartner(employeeOptional.get()));
            }

            return customResponse;
        } catch (Exception e) {
            throw new Exception(e);
        }

    }

}
