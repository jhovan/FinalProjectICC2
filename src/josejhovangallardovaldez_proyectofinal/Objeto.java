
package josejhovangallardovaldez_proyectofinal;
import josejhovangallardovaldez_proyectofinal.util.*;

/**
 *Clase objeto 
 * @author: Jhovan Gallardo
 * @version: 12/06/2016/
 */
public class Objeto {
    private int tamano,id;
    private String nombre,descripcion;
    
    /**
     * Constructor de la clase Objeto
     * @param id
     * @param nombre
     * @param tamano
     * @param descripcion
     */
    public Objeto(int id, String nombre, int tamano, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.tamano = tamano;
        this.descripcion = descripcion;
    }
    
    /**
     * Cambia el id del objeto
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Cambia el nombre del objeto
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Cambia el tamaño del objeto
     * @param tamano
     */
    public void setTamano(int tamano) {
        this.tamano = tamano;
    }
    
    /**
     * Cambia la descripcion del objeto
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion=descripcion;
    }
    
    /**
     * Regresa el id del objeto
     * @return entero
     */
    public int getId() {
        return id;
    }
    
    /**
     * Regresa el nombre del objeto
     * @return cadena de texto
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Regresa el tamaño del objeto
     * @return entero
     */
    public int getTamano() {
        return tamano;
    }
    
    /**
     * Regresa la descripcion del objeto
     * @return cadena de texto
     */
    public String getDescripcion() {
        return descripcion;
    }
    
    /**
     * Regresa una cadena que representa al objeto
     * @return cadena de texto
     */
    @Override
    public final String toString() {
        StringBuilder cadena = new StringBuilder();
        cadena.append("Id:" + id);
        cadena.append("\t");
        cadena.append("Nombre:" + nombre);
        cadena.append("\t");
        cadena.append("Tamano:" + tamano);
        cadena.append("\t");
        cadena.append("Desripcion:" + descripcion);
        return cadena.toString();
    }

    /**
     * Rgresa verdadero si dos objetos tienen el mismo id
     * y falso en caso contrario
     * @param o objeto a comarar
     * @return verdadero o falso
     */
    @Override
    public boolean equals(Object o){
        if (!(o instanceof Objeto))return false;
        else{ 
            Objeto objeto = (Objeto)o;
            return id == objeto.getId();
        }
    }
    
}
