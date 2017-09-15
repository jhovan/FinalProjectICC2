
package josejhovangallardovaldez_proyectofinal;
import josejhovangallardovaldez_proyectofinal.util.*;
import java.io.*;
import java.util.Scanner;
import java.util.Comparator;
/**
 *
 * @author Jhovan
 */
public class JoseJhovanGallardoValdez_ProyectoFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int op;
        Scanner sc = new Scanner(System.in);
        Empaquetamiento empaquetamiento = new Empaquetamiento();
        while(true){
            System.out.println("\nSelecciona una opcion:\n1)Mostrar empaquetamiento\n2)Buscar por contenedor\n3)Buscar por objeto\n4)Guardar archivo\n5)Salir");
            op = sc.nextInt();
            switch(op){
                case 1:System.out.println(empaquetamiento.toString(menuComparador()));
                    break;
                case 2:System.out.println("Introduce el id:");
                    op = sc.nextInt();
                    empaquetamiento.buscarContenedor(op);
                    break;
                case 3:System.out.println("Introduce el id:");
                    op = sc.nextInt();
                    empaquetamiento.buscarObjetoId(op);
                    break;
                case 4: empaquetamiento.escribirArchivo(menuComparador());
                    break;
                default:System.exit(0);
                    break;
            }
        }
    }
    
    private static Comparator menuComparador(){
        int op;
        Scanner sc = new Scanner(System.in);
        System.out.println("Selecciona un orden:\n1)Por objetos ascendente\n2)Por objetos descendente\n3)Por capacidad ascendente\n4)Por capacidad descendente\n5)Por Id ascendente\n6)Por Id descendente");
        op = sc.nextInt();
        Comparator comparador;
        switch(op){
            case 1:comparador = new OrdenarPorObjetosAsc();
                break;
            case 2:comparador = new OrdenarPorObjetosDesc();
                break;
            case 3:comparador = new OrdenarPorCapacidadAsc();
                break;
            case 4:comparador = new OrdenarPorCapacidadDesc();
                break;
            case 5:comparador = new OrdenarPorIdAsc();
                break;
             default:comparador = new OrdenarPorIdDesc();
                break;
        }
        return comparador;
    }
           
}
