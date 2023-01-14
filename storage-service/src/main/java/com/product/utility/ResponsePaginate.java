package com.product.utility;

import com.product.dto.StorageResponseDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@NoArgsConstructor
public class ResponsePaginate {
    private HttpStatus status;
    private int code;
    private List<StorageResponseDTO> data;
    private int pageIndex;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private int nextPage;
    private int previousPage;
}