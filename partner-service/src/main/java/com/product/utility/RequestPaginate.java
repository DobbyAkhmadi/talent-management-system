package com.product.utility;

import jakarta.validation.constraints.Null;
import lombok.Data;


@Data
public class RequestPaginate {
    Integer pageIndex = 0;
    Integer pageSize = 5;
    @Null
    String sortBy;
    @Null
    String search;
}