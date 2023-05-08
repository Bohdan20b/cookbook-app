import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable, map } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RecipeService {
  public BASE_URL = '//localhost:8080/recipes';
  public UPDATE = this.BASE_URL + '/update?id=';
  public ADD = this.BASE_URL + '/add';
  public ADD_CHILD = this.BASE_URL + '/add-child?id=';



  constructor(private http: HttpClient) {
}

getAll() : Observable<any> {
  return this.http.get(this.BASE_URL);
}

save(recipe: any): Observable<any> {
  const url = this.ADD;
  return this.http.post(url, recipe, { observe: 'response' })
      .pipe(
        map(response => response.body)
      );
}

update(id: number, recipe: any): Observable<any> {
  const url = `${this.UPDATE}` + id;
  return this.http.put(url, recipe);
}

addChild(id: number, recipe: any): Observable<any> {
  const url = `${this.ADD_CHILD}` + id;
  return this.http.post(url,recipe);
}
}
