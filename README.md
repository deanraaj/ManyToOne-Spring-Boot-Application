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
* Features
