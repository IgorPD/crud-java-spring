package com.example.crud.domain.product;

import jakarta.validation.constraints.NotBlank;

public record RequestCategoryDTO(
    String id,

    @NotBlank
    String name
){
}