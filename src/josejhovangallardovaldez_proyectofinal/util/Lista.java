
package josejhovangallardovaldez_proyectofinal.util;
/**
 *Esta interfaz define el tipo de dato abstracto Lista.
 * @param <T> es el tipo de la lista.
 * @author: Jhovan Gallardo
 * @version: 07/04/2016/
 */

public interface Lista<T> {
    /**
     * Devuelve verdadero o falso dependiendo si la lista
     * contiene elementos.
     * @return devuelve un booleano verdadero si es vacia
     * y falso si no es vacia
     */
    boolean esVacia();

    /**
     * Devuelve el número de elementos en la lista.
     * @return devuelve un enero con la longitud de la lista
     */
    int longitud();

    /**
     * Elimina el elemento de la lista si lo encuentra.
     * @param elemento es el valor del elemento a eliminar
     */
    void eliminar(T elemento);

    /**
     * Elimina el elemento en el indice indicado o
     * una excepción si el indice es mayor que la lista o negativo.
     * @param indice es un entero que representa la posicion
     */
    void eliminar(int indice);

    /**
     * Agrega un elemento al inicio de la lista.
     * @param elemento es lo que vamos a agregar a la lista
     */
    void agregarInicio(T elemento);

    /**
     * Agrega un elemento al final de la lista.
     * @param elemento es lo que vamos a agregar a la lista
     */
    void agregar(T elemento);

    /**
     * Devuelve verdadero o falso si el elemento esta contenido en la lista.
     * @return devuelve un booleano que es verdadero si el elemento esta
     * contenido en la lista, o falso en caso contrario.
     * @param elemento es el valor del que queremos comprobar su contencion
     */
    boolean contiene(T elemento);

    /**
     * Nos regresa el elemento en la posición del indice o una excepción si
     * el indice es mayor al tamaño de la lista.
     * @return devuelve un el valor de tipo T en la posicion indicada
     * @param indice es un entero indicando la posicion
     */
    T obtener(int indice);

    /**
     * Nos devuelve el indice en el cual se encuentra el elemento o un valor
     * negativo si no se encontró el elemento.
     * @return devuelve un entero indicando la posicion
     * @param elemento es un valor de tipo T del cual queremos la posicion
     */
    int obtenerPosicion(T elemento);

    /**
     * Elimina todos los elementos de la lista.
     */
    void limpiar();
}
