import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

public class Prueba{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> lista = new LinkedList<>();

        System.out.println("Ingresar un numero: ");
        int numElegido = scanner.nextInt();
        
        System.out.println("Ahora, ingresar 5 diferentes numeros: ");
        for(int i = 0; i<5; i++){
            int num = scanner.nextInt();
            if (num > numElegido) {
                lista.add(num);    
            }
        }

        System.out.println("Los numeros guardados en la lista son: " + lista);
        
    }
}
