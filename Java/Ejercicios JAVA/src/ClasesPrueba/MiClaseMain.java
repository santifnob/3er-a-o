package ClasesPrueba;

import java.util.Scanner;

public class MiClaseMain {
	
	public static void main(String[] args) {
        Empleado[] empleados = new Empleado[20];
        Scanner scanner = new Scanner(System.in);
        int contador = 0;
        System.out.println("Agregar empleado (0 para salir) 1- Administrativo 2- Vendedor");
        int opc = scanner.nextInt();
        
        while(contador < 20 && opc !=0) {
        	Empleado e = null;
        	
        	if(opc == 1) {
        		e = new Administrativo();
        	}
        	
        	if (opc == 2) {
        		e = new Vendedor();
        	}
        	
        	e.cargarDatos();
        	empleados[contador] = e;
        	contador++;
        	System.out.println("Agregar otro empleado (0 para salir) 1- Administrativo 2- Vendedor");
        	opc = scanner.nextInt();
        }

        for(int i = 0; i < contador; i++) {
        	System.out.println("Nombre: " + empleados[i].getNombre() + ".Apellido: " + empleados[i].getApellido() + ".DNI: " + empleados[i].getDni()
        	+ ".Sueldo: " + empleados[i].getSueldo());
        }
        
        scanner.close();
    }
}	


