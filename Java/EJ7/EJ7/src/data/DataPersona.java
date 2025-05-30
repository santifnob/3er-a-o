package data;
//orig
import entities.*;

import java.sql.*;
import java.util.LinkedList;

public class DataPersona {
	
	public LinkedList<Persona> getAll(){
		DataRol dr=new DataRol();
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Persona> pers= new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select id,nombre,apellido,tipo_doc,nro_doc,email,tel,habilitado from persona");
			//intencionalmente no se recupera la password
			if(rs!=null) {
				while(rs.next()) {
					Persona p=new Persona();
					p.setDocumento(new Documento());
					p.setId(rs.getInt("id"));
					p.setNombre(rs.getString("nombre"));
					p.setApellido(rs.getString("apellido"));
					p.getDocumento().setTipo(rs.getString("tipo_doc"));
					p.getDocumento().setNro(rs.getString("nro_doc"));
					p.setEmail(rs.getString("email"));
					p.setTel(rs.getString("tel"));
					
					p.setHabilitado(rs.getBoolean("habilitado"));
					
					dr.setRoles(p);
					
					pers.add(p);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return pers;
	}
	
	public Persona getByUser(Persona per) {
		DataRol dr=new DataRol();
		Persona p=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select id,nombre,apellido,tipo_doc,nro_doc,email,tel,habilitado from persona where email=? and password=?"
					);
			stmt.setString(1, per.getEmail());
			stmt.setString(2, per.getPassword());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				p=new Persona();
				p.setDocumento(new Documento());
				p.setId(rs.getInt("id"));
				p.setNombre(rs.getString("nombre"));
				p.setApellido(rs.getString("apellido"));
				p.getDocumento().setTipo(rs.getString("tipo_doc"));
				p.getDocumento().setNro(rs.getString("nro_doc"));
				p.setEmail(rs.getString("email"));
				p.setTel(rs.getString("tel"));
				p.setHabilitado(rs.getBoolean("habilitado"));
				//
				dr.setRoles(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return p;
	}
	
	public Persona getByDocumento(Persona per) {
		DataRol dr=new DataRol();
		Persona p=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select id,nombre,apellido,tipo_doc,nro_doc,email,tel,habilitado from persona where tipo_doc=? and nro_doc=?"
					);
			stmt.setString(1, per.getDocumento().getTipo());
			stmt.setString(2, per.getDocumento().getNro());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				p=new Persona();
				p.setDocumento(new Documento());
				p.setId(rs.getInt("id"));
				p.setNombre(rs.getString("nombre"));
				p.setApellido(rs.getString("apellido"));
				p.getDocumento().setTipo(rs.getString("tipo_doc"));
				p.getDocumento().setNro(rs.getString("nro_doc"));
				p.setEmail(rs.getString("email"));
				p.setTel(rs.getString("tel"));
				p.setHabilitado(rs.getBoolean("habilitado"));
				//
				dr.setRoles(p);
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return p;
	}
	
	public void add(Persona p, Rol r) {
		PreparedStatement stmt= null;
		PreparedStatement stmt2= null;
		ResultSet keyResultSet=null;
		DataRol dr = new DataRol();
		r = dr.getById(r);
		Connection conn = null;
		
		if (r != null) {
			try {
				p.addRol(r);
				conn = DbConnector.getInstancia().getConn();
				
				stmt = conn.prepareStatement(
						"insert into persona(nombre, apellido, tipo_doc, nro_doc, email, password, tel, habilitado) values(?,?,?,?,?,?,?,?)",
						PreparedStatement.RETURN_GENERATED_KEYS);
				stmt.setString(1, p.getNombre());
				stmt.setString(2, p.getApellido());
				stmt.setString(3, p.getDocumento().getTipo());
				stmt.setString(4, p.getDocumento().getNro());
				stmt.setString(5, p.getEmail());
				stmt.setString(6, p.getPassword());
				stmt.setString(7, p.getTel());
				stmt.setBoolean(8, p.isHabilitado());
				
				stmt.executeUpdate();
				
				keyResultSet = stmt.getGeneratedKeys();
				if (keyResultSet != null && keyResultSet.next()) {
					p.setId(keyResultSet.getInt(1));
				}
				
				stmt2 = conn.prepareStatement("insert into rol_persona (id_persona, id_rol) values (?,?)");
		
				stmt2.setInt(1, p.getId());
				stmt2.setInt(2, r.getId());
				
				stmt2.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (keyResultSet != null)
						keyResultSet.close();
					if (stmt != null && stmt2 != null)
						stmt.close();
						stmt2.close();
					
					DbConnector.getInstancia().releaseConn();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} 
		}else {System.out.println("No se pudo crear la persona ya que no existe ningun rol con ese id.");}
    }

	public LinkedList<Persona> getByApellido(Persona p) {
		DataRol dr = new DataRol();
		ResultSet rs = null;
		PreparedStatement pst = null;
		LinkedList<Persona> personas = new LinkedList<Persona>();
		String aStmnt = "SELECT id,nombre,apellido,tipo_doc,nro_doc,email,tel,habilitado "
				+ "FROM Persona WHERE apellido = ?";
		
		try {
			pst = DbConnector.getInstancia().getConn().prepareStatement(aStmnt);
			pst.setString(1, p.getApellido());
			rs = pst.executeQuery();
			
			if(rs != null && rs.next()) {
				Persona aPerson = new Persona();
				
				aPerson.setDocumento(new Documento());
				aPerson.setId(rs.getInt("id"));
				aPerson.setNombre(rs.getString("nombre"));
				aPerson.setApellido(rs.getString("apellido"));
				aPerson.getDocumento().setTipo(rs.getString("tipo_doc"));
				aPerson.getDocumento().setNro(rs.getString("nro_doc"));
				aPerson.setEmail(rs.getString("email"));
				aPerson.setTel(rs.getString("tel"));
				aPerson.setHabilitado(rs.getBoolean("habilitado"));
				//
				dr.setRoles(aPerson);
				personas.add(aPerson);
				
			}
		} catch(SQLException e){
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
			System.out.println(e.getSQLState());
		} finally {
			try {
				if(rs != null) rs.close();
				if(pst != null) pst.close();
				DbConnector.getInstancia().releaseConn();
			} catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		if(personas.isEmpty()) {
			return null;
		}else {return personas;}
		
	}
	
	public String update(Persona p, Rol r, Persona per) {
		ResultSet rs = null;
		PreparedStatement pst = null;
		PreparedStatement pst2 = null;
		String resultText = null;
		Connection conn = null;
		
		try {
			conn = DbConnector.getInstancia().getConn();
			pst = conn.prepareStatement(""
					+ " UPDATE Persona"
					+ " SET nombre = ?,"
					+ " apellido = ?,"
					+ " email = ?,"
					+ " password = ?,"
					+ " tel = ?,"
					+ " habilitado = ?"
					+ " WHERE tipo_doc = ? AND nro_doc = ?");
			
			pst.setString(1, p.getNombre());
			pst.setString(2, p.getApellido());
			pst.setString(3, p.getEmail());
			pst.setString(4, p.getPassword());
			pst.setString(5, p.getPassword());
			pst.setBoolean(6, p.isHabilitado());
			pst.setString(7, p.getDocumento().getTipo());
			pst.setString(8, p.getDocumento().getNro());
			
			int result = pst.executeUpdate();
			if(result == 0) {
				resultText = "No existen personas con ese documento";
				//aca lo ideal seria que se haga antes (previo a la carga de todos los datos)
			} else {
				resultText = "Update realizado con exito";
				pst2 = conn.prepareStatement("UPDATE rol_persona SET id_rol=? WHERE id_persona = ?");
				pst2.setInt(1, r.getId());
				
				pst2.setInt(2, per.getId());
				pst2.executeUpdate();

				}
			//los prints anteriores realmente se deberian volver para la UI								
		}catch(SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pst != null) {
					pst.close();
				}
				if(pst2!= null) {pst2.close();}
				DbConnector.getInstancia().releaseConn();
			}catch(SQLException ex){
				ex.printStackTrace();
			}
			}
		return resultText;
		}
	
	public Persona delete(Persona p) {
		PreparedStatement pst = null;
		PreparedStatement pst2 = null;
		Connection conn = null;
		
		try {
			conn = DbConnector.getInstancia().getConn();
			pst = conn.prepareStatement("delete from rol_persona where id_persona = ?");
			pst.setInt(1, p.getId());
			pst.executeUpdate();
			pst2 = conn.prepareStatement("delete from persona where id = ?");
			pst2.setInt(1, p.getId());
			pst2.executeUpdate();
			
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if(pst2 != null) {pst2.close();}
				if(pst != null) {pst.close();}
				if(conn != null) {
					conn.close();
					DbConnector.getInstancia().releaseConn();
				}	
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
		return p;
	}
	}

