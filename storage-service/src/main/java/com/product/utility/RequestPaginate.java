package com.product.utility;

import lombok.Data;

import javax.validation.constraints.Null;


@Data
public class RequestPaginate {
    Integer pageIndex = 0;
    Integer pageSize = 5;
    @Null
    String sortBy;
    @Null
    String search;
}