package Entities;
public class Product {
	private int id;
	private String description;
	private String name;
	private double precio;
	private int stock;
	private boolean shippingIncluded;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public boolean isShippingIncluded() {
		return shippingIncluded;
	}
	public void setShippingIncluded(boolean shippingIncluded) {
		this.shippingIncluded = shippingIncluded;
	}

	public Product(int id, String description, String name, double precio, int stock, boolean shippingIncluded) {
		this.id = id;
		this.description = description;
		this.name = name;
		this.precio = precio;
		this.stock = stock;
		this.shippingIncluded = shippingIncluded;
	}
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
