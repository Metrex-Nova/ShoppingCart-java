# E-Commerce Shopping Cart in Java

This is a simple Java program that demonstrates a **shopping cart system** using object-oriented programming concepts and the Java Collections framework. It allows you to add products, remove products by ID, update quantities, calculate the total cost, and print the cart contents.

---

## Features

- Create `Product` objects with `id`, `name`, `price`, and `quantity`.
- `ShoppingCart` class manages products using an `ArrayList`.
- Add new products or update quantity if the product already exists.
- Remove products by their unique ID.
- Calculate the total cost of all products in the cart.
- Print the cart contents in a readable format.

---

## Classes

### `Product`
Represents an item in the shopping cart.

**Fields:**
- `id` (String): Unique identifier for the product.
- `name` (String): Name of the product.
- `price` (double): Price per unit.
- `quantity` (int): Number of units.

**Methods:**
- Getters and setters for all fields.
- `toString()` for printing in `Name (xQuantity)` format.

### `ShoppingCart`
Manages the collection of `Product` objects.

**Methods:**
- `addItem(Product product)`: Adds a new product or updates quantity if it already exists.
- `removeItemByID(String id)`: Removes a product by its ID.
- `totalCartCost()`: Returns the total cost of all items.
- `printCart()`: Prints all items in the cart.

---

## Example Usage

```java
public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Product laptop = new Product("1", "Laptop", 1000.0, 1);
        Product mouse = new Product("2", "Mouse", 50.0, 2);

        cart.addItem(laptop);
        cart.addItem(mouse);

        // Add more laptops (updates quantity)
        Product moreLaptops = new Product("1", "Laptop", 1000.0, 2);
        cart.addItem(moreLaptops);

        cart.removeItemByID("2"); // removes mouse

        System.out.println("Total Cost: $" + cart.totalCartCost());
        cart.printCart();
    }
}

Expected Output:

Added new product: Laptop
Added new product: Mouse
Updated quantity of Laptop
Removed: Mouse
Total Cost: $3000.0
Laptop (x3)

Requirements

Java 8 or higher

No external libraries required

Notes

The cart ensures no duplicate products by ID; quantities are updated automatically.

The program demonstrates OOP principles, ArrayList usage, for-each loops, and Iterator removal.


