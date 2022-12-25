package com.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PartnerResponseDTO {
    private UUID id;
    private String name;
    private String address;
    private Date createdAt;
    private String updatedAt;
}
