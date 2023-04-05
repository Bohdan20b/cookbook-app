package com.example.cookbookapp.dto;

public interface ResponseDtoMapper<D, M> {
    D mapToDto(M dto);
}
