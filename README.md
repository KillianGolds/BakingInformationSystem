# Baking Information System

The **Baking Information System** is a Java application designed to serve as a comprehensive tool for managing baking-related information. It allows users to efficiently organize and track bakery goods, ingredients, and recipes. Below, you'll find an overview of the system:

## System Overview

### Entities

The Baking Information System encompasses the following core entities:

- **Bakery Good**: Represents a wide range of bakery products, each defined by attributes such as type, item name, origin, description, and an image URL.

- **Ingredient**: Represents the fundamental building blocks of recipes, including attributes like ingredient name, description, calorie count, and quantity measurement unit (grams or milliliters).

- **Recipe**: Represents a combination of ingredients necessary to create a specific baked item, characterized by properties like name, description, total calorie count, and a list of constituent ingredients.

### Functionality

The system offers a variety of features and functionalities to facilitate the effective management of bakery-related data:

#### Bakery Good Management:

- Add, edit, and delete bakery goods.
- View a comprehensive list of all bakery goods.
- Efficiently query bakery goods using a hash table.

#### Ingredient Management:

- Add, edit, and delete ingredients.
- Access a complete list of all available ingredients.
- Easily add ingredients to recipes.

#### Recipe Management:

- Create and manage recipes by selecting and combining ingredients.
- Calculate the total calorie count for each recipe.
- Add, edit, and delete recipes.

#### Hash Table Integration:

- Utilizes a hash table for efficient storage and retrieval of objects.

#### Graphical User Interface (GUI):

- Implemented using JavaFX to provide a user-friendly interface for interactions.

## Implementation Details

- This project was developed as an individual exercise for a college module assignment.

- Custom data structures and algorithms are employed to efficiently manage data, without relying on existing Java collections.
