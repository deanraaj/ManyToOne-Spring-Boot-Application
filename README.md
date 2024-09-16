# ManyToOne-Spring-Boot-Application
This is a Spring Boot application demonstrating a Many-to-One relationship between two entities: Product and Category. Each Product belongs to one Category, while a Category can have multiple Products.
# Entities
## ProductProduct
* int id: Unique identifier for the product.
* String name: Name of the product.
* double price: Price of the product.
* int quantity: Quantity of the product.
* Category category: The category to which the product belongs.
## Category
* int id: Unique identifier for the category.
* String name: Name of the category.
# Features
## Add Product
* Adds a new product with details such as name, price, quantity, and category.
* Maps the product to a specific category.
## Get Product by Category ID
* Retrieves all products associated with a particular category by its id.
## Get Product by Product ID
* Retrieves a single product by its unique id.
## Delete Product by ID
* Deletes a product by its unique id.
## Exception Handling
* This application handles the following custom exceptions:

CategoryNotFoundException: Thrown when a category with the specified id is not found.
ProductNotFoundException: Thrown when a product with the specified id is not found.
