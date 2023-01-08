package com.product.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v2/partner")
public class PartnerControllerV2 {
    @GetMapping("")
    public String test() {
        return "Hello this is Service";
    }

    @GetMapping("/test")
    public String qintil() {
        return "Hello this is test";
    }
}
