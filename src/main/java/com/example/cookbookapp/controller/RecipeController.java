package com.example.cookbookapp.controller;

import com.example.cookbookapp.dto.RecipeRequestDto;
import com.example.cookbookapp.dto.RecipeResponseDto;
import com.example.cookbookapp.dto.RequestDtoMapper;
import com.example.cookbookapp.dto.ResponseDtoMapper;
import com.example.cookbookapp.model.Recipe;
import com.example.cookbookapp.service.RecipeService;
import java.util.Comparator;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Recipe> getAll() {
        return sortList(recipeService.getAll()) ;
    }

    @PostMapping("/add")
    @CrossOrigin(origins = "http://localhost:4200")
    public RecipeResponseDto add(@RequestBody RecipeRequestDto dto) {
        Recipe recipe = recipeService.add(requestDtoMapper.mapToModel(dto));
        return responseDtoMapper.mapToDto(recipe);
    }

    @PostMapping("/add-child")
    @CrossOrigin(origins = "http://localhost:4200")
    public RecipeResponseDto addChild(@RequestParam Long id, @RequestBody RecipeRequestDto dto) {
        Recipe recipe = recipeService.addChild(id, requestDtoMapper.mapToModel(dto));
        return responseDtoMapper.mapToDto(recipe);
    }

    @PutMapping("/update")
    @CrossOrigin(origins = "http://localhost:4200")
    public RecipeResponseDto update(@RequestParam Long id, @RequestBody RecipeRequestDto dto) {
        Recipe recipe = requestDtoMapper.mapToModel(dto);
        recipe.setId(id);
        return responseDtoMapper.mapToDto(recipeService.update(recipe));
    }

    private List<Recipe> sortList(List<Recipe> recipe) {
        return recipe.stream()
                .sorted(Comparator.comparing(Recipe::getDescription))
                .toList();
    }
}
