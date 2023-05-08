# 🧑‍🍳 Cookbook application
### 📗 ***Project description***
```
It's a simple Cookbook web application. 
The application is simply a hierarchial tree of recipes.
```

List of options available:
* Display a list of recipes (date created, description)
* Add a new recipe
* Add a new recipe based on another one - culinary “fork” of a recipe (e.g. Fried Chicken ->
Fried Chicken with Mayo -> Fried Chicken with Mayo and Mustard).
* Modify existing recipe (on any depth)
* Recipes should be sorted alphabetically (on any depth).

### 💾 ***Project's structure***

Based on 3-layer architecture:
* Presentation layer - controllers.
* Application layer - services.
* Data access layer - repositories.

Project's HTTP methods supported: 
1. GET /recipes - get all recipe list
2. POST /recipes/add - add new recipe to the recipe list
3. POST /recipes/add-child - add forked recipe from an existing one
4. PUT /recipes/update - update an existing recipe in the list


### 🔨 ***Project launch:***

1. Clone this project from GitHub. *Hint: If you use IntelliJ IDEA, use only Ultimate version*
2. Open [pom.xml](pom.xml) and reload all maven dependencies.
3. Open [application.properties](src/main/resources/application.properties) and set up your username and password for DB.
4. In terminal enter the following command: ```mvn clean package```.
5. After success, you can start a CookBookApplication class in order to launch a web application.
6. After launching the backend, start the frontend part by typing ```ng serve --open``` in frontend path(Angular CLI have to be installed).


### 🧰 Application technologies:
* **[JDK 17](https://www.oracle.com/cis/java/technologies/javase/jdk11-archive-downloads.html)**
* **[Spring Boot](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web)**
* **[MySQL](https://www.mysql.com/)**
* **[Angular CLI](https://angular.io/cli)**
