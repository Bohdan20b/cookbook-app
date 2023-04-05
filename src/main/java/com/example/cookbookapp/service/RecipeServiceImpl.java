package com.example.cookbookapp.service;

import com.example.cookbookapp.model.Recipe;
import com.example.cookbookapp.repository.RecipeRepository;
import java.util.Comparator;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RecipeServiceImpl implements RecipeService {
    private static final String SPACE = " ";
    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Recipe add(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public Recipe addChild(Long id, Recipe recipe) {
        Recipe parentRecipe = recipeRepository.findById(id).orElseThrow();
        Recipe childRecipe = new Recipe();
        childRecipe.setDescription(parentRecipe.getDescription() + SPACE + recipe.getDescription());
        childRecipe.setDateCreated(recipe.getDateCreated());
        parentRecipe.getChildRecipeList().add(childRecipe);
        parentRecipe.setChildRecipeList(sortList(parentRecipe.getChildRecipeList()));
        recipeRepository.save(childRecipe);
        return recipeRepository.save(parentRecipe);
    }

    @Override
    public Recipe update(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public List<Recipe> getAll() {
        return sortList(recipeRepository.findAll());
    }

    private List<Recipe> sortList(List<Recipe> recipe) {
        return recipe.stream()
                .sorted(Comparator.comparing(Recipe::getDescription))
                .toList();
    }
}
