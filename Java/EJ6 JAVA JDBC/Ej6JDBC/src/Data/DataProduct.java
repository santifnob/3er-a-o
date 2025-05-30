package Data;
import java.sql.*;
import java.util.LinkedList;

import Entities.Product;

public class DataProduct {
	public static void registerDriver(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static LinkedList<Product> findAll(LinkedList<Product> prods) {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/javaMarket", "usuario","2005");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT id,name,price FROM Product");
			
			while(rs.next()) {
				Product p = new Product();
				
				p.setId((rs.getInt("id"))); 
				p.setName(rs.getString("name"));
				p.setPrecio(rs.getDouble("price"));
				
				prods.add(p);
			}
			
			st.close();
			rs.close();
			conn.close();
			} catch(SQLException ex){
			    
			    System.out.println("SQLException: " + ex.getMessage());
			    System.out.println("SQLState: " + ex.getSQLState());
			    System.out.println("VendorError: " + ex.getErrorCode());
			}
		
		return prods;
	}

	public static Product getOne(Product p) {
		Connection conn = null;
	
		try {
			conn = DriverManager.getConnection("jdbc:mySql://localhost/javaMarket", "usuario", "2005");
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM Product WHERE id = ?");
			pst.setInt(1, p.getId());
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				p.setDescription(rs.getString("description"));
				p.setPrecio(rs.getDouble("price"));
				p.setName(rs.getString("name"));
				p.setStock(rs.getInt("stock"));
				p.setShippingIncluded(rs.getBoolean("shippingIncluded"));
				
			} else {return null;}
			
			pst.close();
			rs.close();
			conn.close();
		} catch(SQLException e){
			System.out.println("SQLException: " + e.getMessage());
		    System.out.println("SQLState: " + e.getSQLState());
		    System.out.println("VendorError: " + e.getErrorCode());
		}
				
		return p;
	}
	
	public static Product add(Product p) { //No devuelvo producto porque el parametro es por referencia, haria falta cambiarlo tambien en los demas metodos realizados
		Connection conn = null;

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/javaMarket","usuario","2005");
			PreparedStatement pst = conn.prepareStatement("INSERT INTO Product(name,description,price,stock,shippingIncluded) values (?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setString(1, p.getName());
			pst.setString(2, p.getDescription());
			pst.setDouble(3, p.getPrecio());
			pst.setInt(4, p.getStock());
			pst.setBoolean(5, p.isShippingIncluded());
			
			pst.executeUpdate();
			ResultSet keySet = pst.getGeneratedKeys();
			
			if(keySet != null && keySet.next()) {
				p.setId(keySet.getInt(1));
				
			}
			
			if(keySet != null) {keySet.close();}
			if(pst != null) {pst.close();}
		
			conn.close();
			
			
		}catch(SQLException ex) {
			System.out.println("Error message: "+ ex.getMessage());
			System.out.println("Error code: "+ ex.getErrorCode());
			System.out.println("Vendor error:"+ex.getSQLState());
			
		}
		return p;
	}
	
	public static Product delete(Product p) {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/javaMarket", "usuario", "2005");
			PreparedStatement pst = conn.prepareStatement("delete from Product where id = ?");
			pst.setInt(1, p.getId());
			
			int success = pst.executeUpdate();
			
			if(success == 0) {
				p = null;
			}
			
			pst.close();
			
			conn.close();
		}catch(SQLException ex){
			System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}	
		return p;
	}
	
	public static Product update(Product p) {
		
		if (p.getId() != 0) {
			Connection conn = null;

			try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost/javaMarket", "usuario", "2005");
				PreparedStatement st = conn.prepareStatement("update Product set name = ?, description = ?, price = ?, stock = ?, shippingIncluded = ? where id = ?");
				st.setString(1, p.getName());
				st.setString(2, p.getDescription());
				st.setDouble(3, p.getPrecio());
				st.setInt(4, p.getStock());
				st.setBoolean(5, p.isShippingIncluded());
				st.setInt(6, p.getId());
				
				st.executeUpdate();
				
				
				st.close();
				conn.close();
				
			} catch (SQLException ex) {
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
			} 
		}
		return p;
	}
}
