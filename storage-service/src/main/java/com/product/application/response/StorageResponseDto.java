package com.product.application.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StorageResponseDto {
    private UUID id;
    private String flagCode;
    private String fileUrl;
    private String fileName;
    private String contentType;
    private String fileSize;
}
