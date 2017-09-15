
package josejhovangallardovaldez_proyectofinal;
import josejhovangallardovaldez_proyectofinal.util.*;
/**
 *Clase contenedor que guarda objetos
 * @author: Jhovan Gallardo
 * @version: 12/06/2016/
 */
public class Contenedor implements Comparable<Contenedor>{
    private int capI,capD,id;
    private final ListaLigada<Objeto> lista;
    
    /**
     * Constructor de la clase contenedor
     * @param id del contenedor
     * @param capI capacidad inicial del contenedor
     */
    public Contenedor(int id, int capI) {
        this.capI = capI;
        this.capD = capI;
        this.id = id;
        this.lista = new ListaLigada();
    }
    
    /**
     * Agrega un objeto al contenedor
     * @param objeto a agregar
     */
    public void agregar(Objeto objeto) {
        lista.agregar(objeto);
        capD-=objeto.getTamano();
        ListaLigada.quicksort(lista, new OrdenarObjetosPorId());
    }
    
    /**
     * Compara dos contenedores por su capacidad
     * disonible
     * @param o contenedor a comparar
     * @return -1 si es menor, 1 si es mayor, y 0 si son iguales
     */
    @Override
     public int compareTo(Contenedor o) {
        int resultado = 0;
        if (this.capD<o.getCapD()) {   resultado = -1;      }
        else if (this.capD>o.getCapD()) {    resultado = 1;      }
        else {
            resultado = 0;
        }
        return resultado;
    }
     
    /**
     * Regresa verdadero si contiene el ojeto
     * @param o objeto a buscar
     * @return vrdadero o falso
     */
    public boolean contiene(Objeto o) {
         return lista.contiene(o);
     }
     
    /**
     * Cambia la capacidad inicial
     * @param capI
     */
    public void setCapI(int capI) {
         this.capI = capI;
     }
     
    /**
     * Cambia la capacidad disponible
     * @param capD
     */
    public void setCapD(int capD) {
         this.capD = capD;
     }
     
    /**
     * Cambia el id del contenedor
     * @param id
     */
    public void setId(int id) {
         this.id = id;
     }
     
    /**
     * Regresa la capacidad inicial
     * @return un entero
     */
    public int getCapI() {
         return capI;
     }
     
    /**
     * Rgresa la capacidad disponible
     * @return un entero
     */
    public int getCapD() {
         return capD;
     }
     
    /**
     * Regresa la capacidad disponible
     * @return un entero
     */
    public int getId(){
         return id;
     }
     
    /**
     * Regresa el numero de objetos que contiene
     * @return un entero
     */
    public int getObjetos(){
         return lista.longitud();
     }
     
    /**
     * Regresa una cadena que representa al contenedor
     * @return una cadena
     */
    @Override
     public final String toString() {
        StringBuilder cadena = new StringBuilder();
        cadena.append("\nContenedor " + id + "\t" + " Capacidad disponible: " + capD + "\tObjetos: " + lista.longitud());
        cadena.append("\nContenido:");
        for(int i = 0;i<lista.longitud();i++){
            cadena.append("\n");
            cadena.append(lista.obtener(i).toString());
        }
        return cadena.toString();
    }

}
