package com.example.cookbookapp.dto;

public interface RequestDtoMapper<D, M> {
    M mapToModel(D dto);
}
