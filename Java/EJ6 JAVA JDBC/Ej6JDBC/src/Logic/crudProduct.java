package Logic;

import java.util.LinkedList;

import Entities.Product;
import Data.DataProduct;

public class crudProduct {
		
	public static LinkedList<Product> list() {
		LinkedList<Product> prods = new LinkedList<Product>();
		DataProduct.findAll(prods); //no deberia hacer falta retornar ya que se manda por referencia 
		
		return prods;
	}
	
	public static Product search(int idProduct) {
		Product p = new Product();
		p.setId(idProduct);
		p = DataProduct.getOne(p);
		return p;
	
		} 
	
	
	public static Product insert(Product p) {
		p = DataProduct.add(p);
		return p;
	}
	
	public static Product deleteAnUser(Product p) {
		p = DataProduct.delete(p);
		return p;
	}
	
	public static Product updateAnUser(Product p) {
		p = DataProduct.update(p);
		return p;
		
	}
}