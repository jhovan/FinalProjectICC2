package josejhovangallardovaldez_proyectofinal.util;

/**
 *Clase celda.
 * @param <T> es el tipo de la celda.
 * @author: Jhovan Gallardo
 * @version: 07/04/2016/
 */

public class Celda<T> {
    /**
    * Valor que almacena la celda.
    */
    private T valor;

    /**
    * Referencia de la celda siguiente.
    */
    private Celda siguiente;

    /**
    * Constructor de la clase celda.
    * @param valorN es el valor que se le asigna a la
    * celda
    */
    public Celda(final T valorN) {
        valor = valorN;
    }

    /**
    * Devuelve el valor almacenado en la celda.
    * @return devuelve un valor tipo T de la celda.
    */
    public final T getValor() {
        return valor;
    }

    /**
    * Asigna un valor a la celda.
    * @param valorN es el valor que se le asigna a la
    * celda
    */
    public final void setValor(final T valorN) {
        valor = valorN;
    }

    /**
    * Devuelve la celda a la que apunta la referencia siguiente.
    * @return devuelve la celda siguiente.
    */
    public final Celda getSiguiente() {
        return siguiente;
    }

    /**
    * Asigna una referencia a la celda siguiente.
    * @param siguienteN es la celda a la que va a apuntar adelante.
    */
    public final void setSiguiente(final Celda siguienteN) {
        siguiente = siguienteN;

    }

    /**
    * Devuelve el valor de la celda en cadena.
    * @return devuelve una cadena que contiene todos los elementos
    */
    public final String toString() {
        return valor.toString();
     }
}
