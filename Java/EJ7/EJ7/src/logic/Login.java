package logic;

import java.util.LinkedList;

import data.*;
import entities.*;

public class Login {
	private DataPersona dp;
	private DataRol dr = new DataRol();
	
	
	public Login() {
		dp=new DataPersona();
	}
	
	public Persona validate(Persona p) {
		/* para hacer más seguro el manejo de passwords este sería un lugar 
		 * adecuado para generar un hash de la password utilizando un cifrado
		 * asimétrico como sha256 y utilizar el hash en lugar de la password en plano 
		 */
		return dp.getByUser(p);
	}

	public LinkedList<Persona> getAll(){
		return dp.getAll();
	}

	public Persona getByDocumento(Persona per) {
		return dp.getByDocumento(per);
		
	}
	
	public LinkedList<Persona> searchByApellido(Persona p){
		return dp.getByApellido(p);
	}
	
	public void newPerson(Persona p, Rol r) {
		dp.add(p,r);

	}
	
	public String updateByDoc(Persona p, Rol r) {
		Persona per = dp.getByDocumento(p);
		
		r = dr.getById(r);
		
		if(r != null) {return dp.update(p,r, per);
			}else {
				return "No existe ese rol";
		}
	}
	
	public Persona deleteByDoc(Persona p) {
		p = dp.getByDocumento(p);
		if(p == null) {return p;}
		else{
			dp.delete(p);
			return p;
		}
		
	}
}
