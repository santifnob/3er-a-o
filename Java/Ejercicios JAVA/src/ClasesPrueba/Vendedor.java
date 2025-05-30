package ClasesPrueba;

import java.util.Scanner;

public class Vendedor extends Empleado {
	private int porcenComision;
	private int totalVentas;
	
	public int getPorcenComision() {
		return porcenComision;
	}
	public void setPorcenComision(int porcenComision) {
		this.porcenComision = porcenComision;
	}
	public int getTotalVentas() {
		return totalVentas;
	}
	public void setTotalVentas(int totalVentas) {
		this.totalVentas = totalVentas;
	}
		
	public void cargarDatos() {
		Scanner scanner = new Scanner(System.in);
		
		super.cargarDatos();
		System.out.println("Ingresar un porcentaje de comision: "); this.setPorcenComision(scanner.nextInt());
		System.out.println("Ingresar el total de ventas: "); this.setTotalVentas(scanner.nextInt());

		
	}
	
	public float getSueldo() {
		return((float) (getSueldoBase() + (porcenComision*totalVentas/100)));
	}
}
