package com.product.API;

import com.product.dto.PartnerResponse;
import com.product.service.IPartnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1/partner")
@RequiredArgsConstructor
public class PartnerControllerV1 {
    private final IPartnerService iPartnerService;

    @RequestMapping(method = RequestMethod.GET, value = "", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPagination() {
        List<PartnerResponse> partnerResponseList = iPartnerService.getAll();
        return new ResponseEntity<>(partnerResponseList.toArray(), HttpStatus.OK);
    }

    @GetMapping("/test")
    public String qintil() {
        return "Hello this is test";
    }
}
