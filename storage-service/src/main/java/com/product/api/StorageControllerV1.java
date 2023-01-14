package com.product.api;

import com.product.dto.StorageRequestDTO;
import com.product.exception.NotFoundException;
import com.product.exception.SystemException;
import com.product.service.StorageService;
import com.product.utility.CustomResponse;
import com.product.utility.RequestPaginate;
import com.product.utility.ResponsePaginate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1/storage")
@RequiredArgsConstructor
public class StorageControllerV1 {

    private final StorageService storageService;

    @PostMapping(value = "", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomResponse> store(@Validated @RequestBody StorageRequestDTO storageRequestDTO) throws SystemException {
        CustomResponse customResponse = storageService.storeStorage(storageRequestDTO);

        return new ResponseEntity<>(customResponse, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomResponse> update(@PathVariable String id, @Validated @RequestBody StorageRequestDTO storageRequestDTO) throws SystemException {
        CustomResponse customResponse = storageService.updateStorage(UUID.fromString(id), storageRequestDTO);

        return new ResponseEntity<>(customResponse, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<ResponsePaginate> getPagination(RequestPaginate requestPaginate) throws SystemException {
        ResponsePaginate storageResponseList = storageService.getPagination(requestPaginate);

        return new ResponseEntity<>(storageResponseList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse> getById(@PathVariable String id) throws NotFoundException {
        CustomResponse customResponse = storageService.getStorageById(UUID.fromString(id));

        return new ResponseEntity<>(customResponse, HttpStatus.OK);
    }
}
