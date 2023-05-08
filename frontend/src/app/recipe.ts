export interface Recipe {
    id: number;
    description: string;
    dateCreated: Date;
    childRecipeList: []
}