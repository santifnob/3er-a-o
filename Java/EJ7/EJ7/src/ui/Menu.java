package ui;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

import entities.*;
import logic.Login;

public class Menu {
	Scanner s=null;
	Login ctrlLogin = new Login();

	public void start() {
		s = new Scanner(System.in);
		Persona p=login();
		System.out.println("Bienvenido "+p.getNombre()+" "+p.getApellido());
		System.out.println();
		
		String command;
		do {
			command=getCommand();
			executeCommand(command);
			System.out.println();
			
		}while(!command.equalsIgnoreCase("exit"));
		
		s.close();
	}

	private void executeCommand(String command) {
		switch (command) {
		case "list":
			System.out.println(ctrlLogin.getAll());
			break;
		case "find":
			System.out.println(find());
			break;
		case "search":
			System.out.println(search());
			break;
		case "new":
			newP();
			break;
		case "edit":
			System.out.println(edit());
			break;
		case "delete":
			delete();
			break;
		default:
			break;
		}
	}

	private String getCommand() {
		System.out.println("Ingrese el comando según la opción que desee realizar");
		System.out.println("list\t\tlistar todos");
		System.out.println("find\t\tbuscar por tipo y nro de documento"); //solo debe devolver 1
		System.out.println("search\t\tlistar por apellido"); //puede devolver varios
		System.out.println("new\t\tcrea una nueva persona y asigna un rol existente");
		System.out.println("edit\t\tbusca por tipo y nro de documento y actualiza todos los datos");
		System.out.println("delete\t\tborra por tipo y nro de documento");
		System.out.println();
		System.out.print("comando: ");
		return s.nextLine();
	}
	
	public Persona login() {
		Persona p=new Persona();
		
		//System.out.print("Email: ");
		//p.setEmail(s.nextLine());

		//System.out.print("password: ");
		//p.setPassword(s.nextLine());
		
		//Lines HardCodeadas para hacer mas facil el testeo
		
		p.setEmail("jp@gmail.com");
		p.setPassword("jperez");
		
		p=ctrlLogin.validate(p);
		
		return p;
		
	}
	
	private Persona find() {
		System.out.println();
		Persona p=new Persona();
		Documento d=new Documento();
		p.setDocumento(d);
		System.out.print("Tipo doc: ");
		d.setTipo(s.nextLine());

		System.out.print("Nro doc: ");
		d.setNro(s.nextLine());
		
		return ctrlLogin.getByDocumento(p);
	}

	private LinkedList<Persona> search() {
		System.out.println("Ingresar un apellido: ");
		Persona p = new Persona();
		p.setApellido(s.nextLine());
		
		return ctrlLogin.searchByApellido(p);
		
	}
	
	private void newP(){
		Persona p = new Persona();
		Documento d = new Documento();
		Rol r = new Rol();
		
		System.out.println("Ingresar un nombre: ");
		p.setNombre(s.nextLine());
		System.out.println("Ingresar un apellido: ");
		p.setApellido(s.nextLine());
		System.out.println("Ingresar un Tipo de Doc: ");
		d.setTipo(s.nextLine());
		System.out.println("Ingresar un Nro de Doc: ");
		d.setNro(s.nextLine());
		p.setDocumento(d);
		System.out.println("Ingresar un email: ");
		p.setEmail(s.nextLine());
		System.out.println("Ingresar una contrasena: ");
		p.setPassword(s.nextLine());
		System.out.println("Ingresar un telefono: ");
		p.setTel(s.nextLine());
		System.out.println("Habilitado?  ");
		try {
			p.setHabilitado(s.nextBoolean());
		} catch (InputMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Ingresar un id de un rol: ");
		r.setId(s.nextInt());
		
		ctrlLogin.newPerson(p, r);
		System.out.println("Enter para vover al menu");
		s.nextLine(); //linea para limpiar el buffer 
	}
	
	private String edit() {
		Persona p = new Persona();
		Documento d = new Documento();
		Rol r = new Rol();
		
		System.out.println("Ingresar un Tipo de Doc: ");
		d.setTipo(s.nextLine());
		System.out.println("Ingresar un Nro de Doc: ");
		d.setNro(s.nextLine());
		System.out.println("--Ingreso de los nuevos datos: ");
		System.out.println("Ingresar un nombre: ");
		p.setNombre(s.nextLine());
		System.out.println("Ingresar un apellido: ");
		p.setApellido(s.nextLine());
		System.out.println("Ingresar un email: ");
		p.setEmail(s.nextLine());
		System.out.println("Ingresar una contrasena: ");
		p.setPassword(s.nextLine());
		System.out.println("Ingresar un telefono: ");
		p.setTel(s.nextLine());
		System.out.println("Habilitado?  ");
		try {
			p.setHabilitado(s.nextBoolean());
		} catch (InputMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Ingresar un id de un rol: ");
		r.setId(s.nextInt());
		s.nextLine();
		
		p.setDocumento(d);
		
		return(ctrlLogin.updateByDoc(p,r));
		//lo mas logico seria devolver un p nulo y hacer un if para ver que imprimir
		
	}
	
	private void delete() {
		Persona p = new Persona();
		Documento d = new Documento();
		System.out.println("Ingresar nro del documento: ");
		d.setNro(s.nextLine());
		System.out.println("Ingresar tipo del documento: ");
		d.setTipo(s.nextLine());
		p.setDocumento(d);
		p = ctrlLogin.deleteByDoc(p);
		if(p == null) {
			System.out.println("No existe una persona con ese doc");
		}
		
	}
}
