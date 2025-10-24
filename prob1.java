import java.util.*;
class Product{
	private String id;
	private String name;
	private double price;
	private int quantity;
	
	// constructor
	public Product(String id, String name, double price, int quantity){
	this.id = id;
	this.name = name;
	this.price = price;
	this.quantity = quantity;
	}
	
	//getter functions
	public String getId(){
	return this.id;
	}
	public String getName(){
	return this.name;
	}
	public double getPrice(){
	return this.price;
	}
	public int getQuantity(){
	return this.quantity;
	}

	//setter functions
	public void setId(String id){
		this.id = id;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setPrice(double price){
		this.price = price;
	}
	public void setQuantity(int quantity){
		this.quantity = quantity;
	}
	@Override
    	public String toString() {
        return name + " (x" + quantity + ")";
    	}
}

class Shoppingcart{
	private List<Product> cart;

	//constructor
	public Shoppingcart(){
	cart = new ArrayList<Product>();
	}

	//add-item method
	public void addItem(Product newProduct){
	for(Product prod : cart){
	if(prod.getId().equals(newProduct.getId())){
		prod.setQuantity(prod.getQuantity() + newProduct.getQuantity());
		System.out.println("Updated quantity of " + prod.getName());
		return;
		}
	}
	cart.add(newProduct);
	System.out.println("Added new product: " + newProduct.getName());
	}

	// remove-item-by-id method
	public void removeItemByID(String id){
	Iterator<Product> it = cart.iterator();
		while(it.hasNext()){
			Product p = it.next();
			if(p.getId().equals(id)){
				System.out.println("Removed: " + p.getName());
				it.remove();
				return;	
			}
		}
		System.out.println("Item with ID " + id + " not found.");
	}

	// total-cost-method
	public double totalCartCost(){
	double sum = 0;
	Iterator<Product> it = cart.iterator();
		while(it.hasNext()){
		Product p = it.next();
		sum = sum +(p.getQuantity() * p.getPrice());
		}
	return sum;
	}

	// print-cart-method
	public void printCart(){
		if(cart.isEmpty()){
			System.out.println("Cart is empty.");
        		return;
		}
		for(Product p : cart){
		System.out.println(p);
		}
	}
	

}

public class prob1 {
    public static void main(String[] args) {

        // Create shopping cart
        Shoppingcart newcart = new Shoppingcart();

        // Create some products
        Product laptop = new Product("1", "Laptop", 1000.0, 1);
        Product mouse = new Product("2", "Mouse", 50.0, 2);
        Product keyboard = new Product("3", "Keyboard", 150.0, 1);

        // Test Case 1: Add new products
        newcart.addItem(laptop);    // should print "Added new product: Laptop"
        newcart.addItem(mouse);     // should print "Added new product: Mouse"
        newcart.addItem(keyboard);  // should print "Added new product: Keyboard"

        // Test Case 2: Add duplicate product (update quantity)
        Product moreLaptops = new Product("1", "Laptop", 1000.0, 2);
        newcart.addItem(moreLaptops); // should print "Updated quantity of Laptop"

        // Test Case 3: Remove a product by ID
        newcart.removeItemByID("2"); // should remove Mouse, print "Removed: Mouse"

        // Test Case 4: Remove a non-existent product
        newcart.removeItemByID("5"); // should print "Item with ID 5 not found."

        // Test Case 5: Total cart cost
        double total = newcart.totalCartCost();
        System.out.println("Total Cart Cost: $" + total);

        // Test Case 6: Print remaining products
        System.out.println("Remaining products in cart:");
        newcart.printCart();
    }
}
