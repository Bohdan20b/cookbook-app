package com.example.cookbookapp.dto;

import com.example.cookbookapp.model.Recipe;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecipeResponseDto {
    private Long id;
    private String description;
    private LocalDateTime dateCreated;
    private List<Recipe> childList;
}
