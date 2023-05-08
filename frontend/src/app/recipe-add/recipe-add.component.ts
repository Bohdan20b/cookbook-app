import { Component } from '@angular/core';
import { RecipeService } from '../recipe.service';
@Component({
  selector: 'app-recipe-add',
  templateUrl: './recipe-add.component.html',
  styleUrls: ['./recipe-add.component.css']
})
export class RecipeAddComponent {
  isFormValid: boolean = false;
  description!: string;
  constructor(private recipeService: RecipeService) {}

  onSubmit() {
    const recipe = { description: this.description };
    this.recipeService.save(recipe).subscribe(
      response => {
        console.log('Recipe added successfully!', response);
        // Handle any success action here
      },
      error => {
        console.error('Error adding recipe:', error);
        // Handle any error action here
      }
    )
  }
}
