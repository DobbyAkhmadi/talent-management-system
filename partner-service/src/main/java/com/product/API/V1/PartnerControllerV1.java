package com.product.API.V1;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/partner")
@RequiredArgsConstructor
public class PartnerControllerV1 {
    @GetMapping("")
    public String test() {
        return "Hello this is Service";
    }

    @GetMapping("/kintil")
    public String qintil() {
        return "Hello this is qintil";
    }
}
