package com.product.utility;

import lombok.Data;

@Data
public class RequestPaginate {
    Integer pageIndex = 0;
    Integer pageSize = 5;

    String sortBy;

    String search;
}