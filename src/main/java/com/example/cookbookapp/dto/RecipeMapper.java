package com.example.cookbookapp.dto;

import com.example.cookbookapp.model.Recipe;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public class RecipeMapper implements RequestDtoMapper<RecipeRequestDto, Recipe>,
        ResponseDtoMapper<RecipeResponseDto, Recipe> {

    @Override
    public Recipe mapToModel(RecipeRequestDto dto) {
        Recipe recipe = new Recipe();
        recipe.setDescription(dto.getDescription());
        recipe.setDateCreated(LocalDateTime.now());
        return recipe;
    }

    @Override
    public RecipeResponseDto mapToDto(Recipe recipe) {
        RecipeResponseDto dto = new RecipeResponseDto();
        dto.setId(recipe.getId());
        dto.setDescription(recipe.getDescription());
        dto.setDateCreated(recipe.getDateCreated());
        dto.setChildList(recipe.getChildRecipeList());
        return dto;
    }
}
