import { Component } from '@angular/core';
import { RecipeService } from '../recipe.service';
import { Recipe } from '../recipe';

@Component({
  selector: 'app-recipe-update',
  templateUrl: './recipe-update.component.html',
  styleUrls: ['./recipe-update.component.css']
})
export class RecipeUpdateComponent {
  id!: number;
  description!: string;
  constructor(private recipeService: RecipeService) {}

  onSubmit() {
    const recipe = { description: this.description };
    this.recipeService.update(this.id, recipe)
      .subscribe((updatedRecipe: Recipe) => {
        // Handle the updated recipe data here
      });
  }
}
