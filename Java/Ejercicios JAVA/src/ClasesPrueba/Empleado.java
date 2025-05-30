package ClasesPrueba;
import java.util.Scanner;

public class Empleado {
	private String dni;
	private String nombre;
	private String apellido;
	private String email;
	private float sueldoBase;
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public float getSueldoBase() {
		return sueldoBase;
	}
	public void setSueldoBase(float sueldoBase) {
		this.sueldoBase = sueldoBase;
	}
	
	public void cargarDatos() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Nombre: "); this.setNombre(scanner.nextLine());
    	System.out.println("Apellido: "); this.setApellido(scanner.nextLine());
    	System.out.println("Dni: "); this.setDni(scanner.nextLine());
    	System.out.println("Email: "); this.setEmail(scanner.nextLine());
    	System.out.println("Sueldo base: "); this.setSueldoBase(scanner.nextFloat());
    	
	}
	
	public float getSueldo() {return 0;}
}
