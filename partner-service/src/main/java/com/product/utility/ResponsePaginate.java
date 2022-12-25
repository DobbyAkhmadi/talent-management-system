package com.product.utility;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@RequiredArgsConstructor
public class ResponsePaginate {
    private HttpStatus status;
    private int code;
    private List<Object> data;
    private int currentPageIndex;
    private int currentPageSize;
    private long totalElements;
    private int totalPages;
    private int nextPage;
    private int previousPage;
}