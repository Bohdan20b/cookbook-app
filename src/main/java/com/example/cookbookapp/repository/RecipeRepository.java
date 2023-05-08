package com.example.cookbookapp.repository;

import com.example.cookbookapp.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
