package com.example.cookbookapp.controller;

import com.example.cookbookapp.dto.RecipeRequestDto;
import com.example.cookbookapp.dto.RecipeResponseDto;
import com.example.cookbookapp.dto.RequestDtoMapper;
import com.example.cookbookapp.dto.ResponseDtoMapper;
import com.example.cookbookapp.model.Recipe;
import com.example.cookbookapp.service.RecipeService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recipes")
public class RecipeController {
    private final RecipeService recipeService;
    private final RequestDtoMapper<RecipeRequestDto, Recipe> requestDtoMapper;
    private final ResponseDtoMapper<RecipeResponseDto, Recipe> responseDtoMapper;

    public RecipeController(RecipeService recipeService,
            RequestDtoMapper<RecipeRequestDto, Recipe> requestDtoMapper,
            ResponseDtoMapper<RecipeResponseDto, Recipe> responseDtoMapper) {
        this.recipeService = recipeService;
        this.requestDtoMapper = requestDtoMapper;
        this.responseDtoMapper = responseDtoMapper;
    }

    @GetMapping
    public List<Recipe> getAll() {
        return recipeService.getAll();
    }

    @PostMapping("/add")
    public RecipeResponseDto add(@RequestBody RecipeRequestDto dto) {
        Recipe recipe = recipeService.add(requestDtoMapper.mapToModel(dto));
        return responseDtoMapper.mapToDto(recipe);
    }

    @PostMapping("/add-child")
    public RecipeResponseDto addChild(@RequestParam Long id, @RequestBody RecipeRequestDto dto) {
        Recipe recipe = recipeService.addChild(id, requestDtoMapper.mapToModel(dto));
        return responseDtoMapper.mapToDto(recipe);
    }

    @PostMapping("/update/{id}")
    public RecipeResponseDto update(@PathVariable Long id, @RequestBody RecipeRequestDto dto) {
        Recipe recipe = requestDtoMapper.mapToModel(dto);
        recipe.setId(id);
        return responseDtoMapper.mapToDto(recipeService.update(recipe));
    }
}
