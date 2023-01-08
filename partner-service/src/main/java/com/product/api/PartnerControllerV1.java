package com.product.api;

import com.product.dto.PartnerRequestDTO;
import com.product.service.PartnerService;
import com.product.utility.CustomResponse;
import com.product.utility.RequestPaginate;
import com.product.utility.ResponsePaginate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1/partner")
@RequiredArgsConstructor
public class PartnerControllerV1 {
    private final PartnerService partnerService;

    @GetMapping("")
    public ResponseEntity<ResponsePaginate> getPagination(RequestPaginate requestPaginate) throws Exception {
        ResponsePaginate partnerResponseList = partnerService.getPagination(requestPaginate);

        return new ResponseEntity<>(partnerResponseList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse> getById(@PathVariable String id) throws Exception {
        CustomResponse customResponse = partnerService.getPartnerById(UUID.fromString(id));

        return new ResponseEntity<>(customResponse, HttpStatus.OK);
    }

    @PostMapping(value = "", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomResponse> store(@Validated @RequestBody PartnerRequestDTO partnerRequestDTO) throws Exception {
        CustomResponse customResponse = partnerService.storePartner(partnerRequestDTO);

        return new ResponseEntity<>(customResponse, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomResponse> update(@PathVariable String id, @Validated @RequestBody PartnerRequestDTO partnerRequestDTO) throws Exception {
        CustomResponse customResponse = partnerService.updatePartner(UUID.fromString(id), partnerRequestDTO);

        return new ResponseEntity<>(customResponse, HttpStatus.CREATED);
    }

}
