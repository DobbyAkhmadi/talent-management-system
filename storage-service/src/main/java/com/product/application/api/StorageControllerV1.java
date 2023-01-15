package com.product.application.api;

import com.product.application.request.StorageRequestDto;
import com.product.application.usecase.IStorageUseCase;
import com.product.exception.NotFoundException;
import com.product.exception.SystemException;
import com.product.utility.CustomResponse;
import com.product.utility.RequestPaginate;
import com.product.utility.ResponsePaginate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.http.MediaType.*;

@RestController
@RequestMapping("/api/v1/storage")
@RequiredArgsConstructor
public class StorageControllerV1 {

    private final IStorageUseCase storageUseCase;

    @PostMapping(value = "", consumes = MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<CustomResponse> store(@Validated  StorageRequestDto storageRequestDTO) throws SystemException {
        CustomResponse customResponse = storageUseCase.storeStorage(storageRequestDTO);

        return new ResponseEntity<>(customResponse, HttpStatus.CREATED);
    }

    @GetMapping(value = "", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponsePaginate> getPagination(RequestPaginate requestPaginate) throws SystemException {
        ResponsePaginate storageResponseList = storageUseCase.getPagination(requestPaginate);

        return new ResponseEntity<>(storageResponseList, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomResponse> getById(@PathVariable String id) throws NotFoundException {
        CustomResponse customResponse = storageUseCase.getStorageById(UUID.fromString(id));

        return new ResponseEntity<>(customResponse, HttpStatus.OK);
    }
}
