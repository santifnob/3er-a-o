package ClasesPrueba;
import java.util.Scanner;

public class Administrativo extends Empleado {
	
	private int hsExtra;
	private int hsMes;
	 	
	public int getHsExtra() {
		return hsExtra;
	}
	public void setHsExtra(int hsExtra) {
		this.hsExtra = hsExtra;
	}
	public int getHsMes() {
		return hsMes;
	}
	public void setHsMes(int hsMes) {
		this.hsMes = hsMes;
	}
	
	public void cargarDatos() {
		Scanner scanner = new Scanner(System.in);
		super.cargarDatos();
		
		System.out.println("Ingresar horas extra: "); this.setHsExtra(scanner.nextInt());
		System.out.println("Ingresar horas mes: "); this.setHsMes(scanner.nextInt());
		
	}
	
	public float getSueldo() {
		return((float) (getSueldoBase() * ((hsExtra * 1.5)+hsMes) / hsMes));
	}
}
