package josejhovangallardovaldez_proyectofinal.util;


/**
 *Esta interfaz define el tipo de dato abstracto arbol.
 * @param <E> es el tipo deel arbol
 * @author: Jhovan Gallardo
 * @version: 05/05/2016/
 */
public interface Arbol<E> {
     /**
     * Agrega un elemento al arbol
     * @param elemento es el valor a agregar
     */
    public void agregar(E elemento);

    /**
     * Elimina un elemento y devuelve si pudo hacerlo
     * @return devuelve true si lo elimina, y false si no
     * @param elemento es el valor a eliminar
     */
    public boolean eliminar(E elemento);

    /**
     * Nos devuelve true si un elemento pertenece al arbol
     * @return devuelve true si lo encuentra, y false si no
     * @param elemento es el valor a eliminar
     */
    public boolean buscarElemento(E elemento);

     /**
     * Devuelve una lista con el recorrido en preorden del arbol
     * @return devuelve la lista con el recorrido
     */
    public Lista<E> recorridoPreOrden();

     /**
     * Devuelve una lista con el recorrido en inorden del arbol
     * @return devuelve la lista con el recorrido
     */
    public Lista<E> recorridoInOrden();

     /**
     * Devuelve una lista con el recorrido en postorden del arbol
     * @return devuelve la lista con el recorrido
     */
    public Lista<E> recorridoPostOrden();
}