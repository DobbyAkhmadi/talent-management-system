package com.product.API;

import com.product.service.PartnerService;
import com.product.utility.RequestPaginate;
import com.product.utility.ResponsePaginate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/partner")
@RequiredArgsConstructor
@Component
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
}
