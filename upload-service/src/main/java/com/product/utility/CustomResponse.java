package com.product.utility;

import lombok.*;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomResponse {
    private HttpStatus status;
    private int code;
    private Object data;
}