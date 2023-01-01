package com.product.API;

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
    public ResponseEntity<?> getPagination(RequestPaginate requestPaginate) throws Exception {
        ResponsePaginate partnerResponseList = partnerService.getPagination(requestPaginate);

        if (partnerResponseList.getData() == null) {
            return new ResponseEntity<>("No Content!", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(partnerResponseList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable UUID id) throws Exception {
        CustomResponse customResponse = partnerService.getPartnerById(id);

        if (customResponse.getData() == null) {
            return new ResponseEntity<>("No Content!", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(customResponse, HttpStatus.OK);
    }

    @PostMapping(value = "", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> store(@Validated @RequestBody PartnerRequestDTO partnerRequestDTO) throws Exception {
        CustomResponse customResponse = partnerService.storePartner(partnerRequestDTO);

        return new ResponseEntity<>(customResponse, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@PathVariable UUID id, @Validated @RequestBody PartnerRequestDTO partnerRequestDTO) throws Exception {
        CustomResponse customResponse = partnerService.updatePartner(id, partnerRequestDTO);

        return new ResponseEntity<>(customResponse, HttpStatus.CREATED);
    }

}
