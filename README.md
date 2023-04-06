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

### 🔨 ***Project launch:***

1. Clone this project from GitHub. *Hint: If you use IntelliJ IDEA, use only Ultimate version*
2. Open [pom.xml](pom.xml) and reload all maven dependencies.
3. Open [application.properties](src/main/resources/application.properties) and set up your username and password for DB.
4. In terminal enter the following command: ```mvn clean package```.
5. After success, you can start a CookBookApplication class in order to launch a web application.
6. Now you can test the program in your browser using Postman API: [http://localhost:8080/recipes]([http://localhost:8080/recipes])

### 🧰 Application technologies:
* **[JDK 17](https://www.oracle.com/cis/java/technologies/javase/jdk11-archive-downloads.html)**
* **[Spring Boot](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web)**
* **[MySQL](https://www.mysql.com/)**
