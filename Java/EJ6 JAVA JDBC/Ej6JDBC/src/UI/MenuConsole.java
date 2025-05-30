package UI;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.LinkedList;
import Logic.crudProduct;
import Data.DataProduct;
import Entities.Product;

public class MenuConsole {

	public static void main(String[] args) {
		
		DataProduct.registerDriver();
		showMenu();
		menuChoice();
			
	}

	public static void menuChoice() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Option number: ");
		int choice = scanner.nextInt();
		
		while (choice != 0) {
			switch (choice) {
			case 1: {
				showProducts();
				break;
				}
			case 2: showSearchedProduct(scanner);break;
			case 3: inputNewProduct(scanner);break;
			case 4: inputDeletePerson(scanner);break;
			case 5: inputUpdatePerson(scanner);break;
			default: System.out.println("That option doesnt exists");break;
			}
			
			try {
				showMenu();
				System.out.println("Option number: ");
				choice = scanner.nextInt();
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
		}
		
		System.out.println("Saliendo..");
		scanner.close();
		
	}

	
	public static void showMenu() {
		System.out.println("MENU\n1- list \n2- search \n3- new \n4- delete \n5- update\n0- exit");
	}
	
	public static void showProducts() {
		LinkedList<Product> prods = crudProduct.list();
		if(prods.isEmpty()) {
			System.out.println("There are no availabre products for the moment");
		} else {
			System.out.println("Available products list:");
			//prods.forEach(p -> System.out.printf("ID: %d NOMBRE: %s PRECIO: %f \n", p.getId(), p.getName(), p.getPrecio()));
			prods.forEach(p -> System.out.println(
					"ID: " + p.getId() +
					"\tName: " + p.getName() +
					"\tPrice: " + p.getPrecio()));
		}
	}
	
	public static void showSearchedProduct(Scanner scan) {
		System.out.println("Ingresar un id: ");
		int selecId = scan.nextInt();
		
		Product p = crudProduct.search(selecId);
		
		if(p == null) {
			System.out.println("There isnt a produc with that id");
		} else {
			System.out.println(
					"Id: " + p.getId() +
					"\tName: " + p.getName() +
					"\tDescription: " + p.getDescription() +
					"\tPrice: " + p.getPrecio() +
					"\tStock: " + p.getStock() + 
					"\tShipping included: " + p.isShippingIncluded());
		}
	}
	
	public static void inputNewProduct(Scanner scan) {
		Product p = new Product();
		System.out.println("Product's name: ");scan.nextLine();p.setName(scan.nextLine()); //Limpiar el buffer
		System.out.println("Product's description: ");p.setDescription(scan.nextLine());
		System.out.println("Product's price: ");p.setPrecio(scan.nextDouble());
		System.out.println("Product's stock: ");p.setStock(scan.nextInt());
		try {
			System.out.println("Shipping included? ");p.setShippingIncluded(scan.nextBoolean());
		} catch (InputMismatchException e) {
			System.out.println(e.getMessage());	
		}
		
		crudProduct.insert(p); //Se autogenera el ID
		
		System.out.println("Product's generated id: " + p.getId());
	}
	
	public static void inputDeletePerson(Scanner scan) {
		System.out.println("Produt id: ");
		
		Product p = new Product(); 
		
		p.setId(scan.nextInt());
		p = crudProduct.deleteAnUser(p); //Devuelvo el producto para que funcione el null (se pasa por copia de referencia)
		
		if(p == null) {
			System.out.println("That id doesnt match with any product");
		}else {System.out.printf("Product with id number %d was succesfully deleted\n", p.getId());}
		
	}
	
	public static void inputUpdatePerson(Scanner scan) {
		System.out.println("Ingresar un id: ");
		int selecId = scan.nextInt();
		
		Product p = crudProduct.search(selecId);
		
		if(p == null) {
			System.out.println("There isnt a produc with that id");
		} 
		else{System.out.println("New name: ");scan.nextLine();p.setName(scan.nextLine());
		System.out.println("New description: ");p.setDescription(scan.nextLine());
		System.out.println("New price: "); p.setPrecio(scan.nextDouble());
		System.out.println("New stock: ");p.setStock(scan.nextInt());
		System.out.println("New shipping include: "); p.setShippingIncluded(scan.nextBoolean());
		
		p = crudProduct.updateAnUser(p);
		}
		
		
	}
	
}
