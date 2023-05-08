import { Component, OnInit } from '@angular/core';
import { RecipeService } from '../recipe.service';

@Component({
  selector: 'app-recipe-list',
  templateUrl: './recipe-list.component.html',
  styleUrls: ['./recipe-list.component.css']
})
export class RecipeListComponent implements OnInit {
  recipes!: Array<any>;
  childRecipeList!: Array<any>;
  constructor(private recipeService: RecipeService) {

  }
  ngOnInit() {
    this.recipeService.getAll().subscribe(data => {
      this.recipes = data;
    });
  }
}
