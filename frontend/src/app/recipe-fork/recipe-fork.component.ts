import { Component } from '@angular/core';
import { RecipeService } from '../recipe.service';
import { Recipe } from '../recipe';

@Component({
  selector: 'app-recipe-fork',
  templateUrl: './recipe-fork.component.html',
  styleUrls: ['./recipe-fork.component.css']
})
export class RecipeForkComponent {
  id!: number;
  description!: string;
  constructor(private recipeService: RecipeService) {}

  onSubmit() {
    const recipe = { description: this.description };
    this.recipeService.addChild(this.id, recipe)
      .subscribe((updatedRecipe: Recipe) => {
        // Handle the updated recipe data here
      });
  }
} 
