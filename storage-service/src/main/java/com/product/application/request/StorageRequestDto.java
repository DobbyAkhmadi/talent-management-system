package com.product.application.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class StorageRequestDto {
    private MultipartFile file;
    private String flagCode;
}
