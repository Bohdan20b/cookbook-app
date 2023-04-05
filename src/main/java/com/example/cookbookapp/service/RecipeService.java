package com.example.cookbookapp.service;

import com.example.cookbookapp.model.Recipe;
import java.util.List;

public interface RecipeService {
    Recipe add(Recipe recipe);

    Recipe addChild(Long id, Recipe recipe);

    Recipe update(Recipe recipe);

    List<Recipe> getAll();
}
