
package josejhovangallardovaldez_proyectofinal.util;
import java.util.Comparator;
/**
 * Clase lista ligada.
 * @param <T> es el tipo de la lista.
 * @author: Jhovan Gallardo
 * @version: 07/04/2016/
 */


public class ListaLigada<T> implements Lista<T> {
    /**
    * Cabeza de la lista.
    */
    private Celda<T> cabeza;

    /**
    * Ultima celda de la lista.
    */
    private Celda<T> centinela;

    /**
    * Entero que representa el no. de elementos.
    */
    private int longitud;

    /**
    * Constructor vacio de la lista.
    */
    public ListaLigada() {
        longitud = 0;
    }

    /**
     * Devuelve verdadero o falso dependiendo si la lista
     * contiene elementos.
     * @return devuelve un booleano verdadero si es vacia
     * y falso si no es vacia.
     */
    @Override
    public final boolean esVacia() {
        if (longitud == 0) {
            return true;
        }
        return false;
    }

    /**
     * Devuelve el número de elementos en la lista.
     * @return devuelve un enero con la longitud de la lista
     */
    @Override
    public final int longitud() {
        return longitud;
    }

    /**
     * Elimina el elemento de la lista si lo encuentra.
     * @param elemento es el valor del elemento a eliminar
     */
    @Override
    public final void eliminar(final T elemento) {
        if (!esVacia()) {
            if (cabeza.getValor().equals(elemento)) {
                cabeza = cabeza.getSiguiente();
                longitud--;
            } else {
                Celda<T> actual = cabeza;
                Celda<T> siguiente = cabeza.getSiguiente();
                while (siguiente != null) {
                    if (siguiente.getValor().equals(elemento)) {
                        actual.setSiguiente(siguiente.getSiguiente());
                        if (actual.getSiguiente() == null) {
                            centinela = actual;
                        }
                        longitud--;
                        return;
                    }
                    actual = siguiente;
                    siguiente = actual.getSiguiente();
                }
            }
        }
    }

    /**
     * Elimina el elemento en el indice indicado o
     * una excepción si el indice es mayor que la lista o negativo.
     * @param indice es un entero que representa la posicion
     */
    @Override
    public final void eliminar(final int indice) {
        if (indice < longitud && indice >= 0) {
            if (indice == 0) {
                cabeza = cabeza.getSiguiente();
            } else {
                Celda<T> actual = cabeza;
                for (int i = 1; i < indice; i++) {
                    actual = actual.getSiguiente();
                }
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                if (indice == longitud - 1) {
                    centinela = actual;
                }
            }
            longitud--;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Agrega un elemento al inicio de la lista.
     * @param elemento es lo que vamos a agregar a la lista
     */
    @Override
    public final void agregarInicio(final T elemento) {
        Celda<T> nueva = new Celda(elemento);
        if (esVacia()) {
            cabeza = nueva;
            centinela = nueva;
        } else {
            nueva.setSiguiente(cabeza);
            cabeza = nueva;
        }
        longitud++;
    }

    /**
     * Agrega un elemento al final de la lista.
     * @param elemento es lo que vamos a agregar a la lista
     */
    @Override
    public final void agregar(final T elemento) {
        Celda<T> nueva = new Celda(elemento);
        if (esVacia()) {
            cabeza = nueva;
            centinela = nueva;
        } else {
            centinela.setSiguiente(nueva);
            centinela = nueva;
        }
        longitud++;
    }

    /**
     * Devuelve verdadero o falso si el elemento esta contenido en la lista.
     * @return devuelve un booleano que es verdadero si el elemento esta
     * contenido en la lista, o falso en caso contrario.
     * @param elemento es el valor del que queremos comprobar su contencion
     */
    @Override
    public final boolean contiene(final T elemento) {
        Celda<T> actual = cabeza;
        while (actual != null) {
            if (actual.getValor().equals(elemento)) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    /**
     * Nos regresa el elemento en la posición del indice o una excepción si
     * el indice es mayor al tamaño de la lista.
     * @return devuelve un el valor de tipo T en la posicion indicada
     * @param indice es un entero indicando la posicion
     */
    @Override
    public final T obtener(final int indice) {
        if (indice < longitud && indice >= 0) {
            Celda<T> actual = cabeza;
            for (int i = 0; i < indice; i++) {
                actual = actual.getSiguiente();
            }
            return actual.getValor();
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
    
    private Celda<T> obtenerCelda(final int indice) {
        if (indice < longitud && indice >= 0) {
            Celda<T> actual = cabeza;
            for (int i = 0; i < indice; i++) {
                actual = actual.getSiguiente();
            }
            return actual;
        } else {
            return null;
        }
    }

    /**
     * Nos devuelve el indice en el cual se encuentra el elemento o un valor
     * negativo si no se encontró el elemento.
     * @return devuelve un entero indicando la posicion
     * @param elemento es un valor de tipo T para del cual queremos posicion
     */
    @Override
    public final int obtenerPosicion(final T elemento) {
        Celda<T> actual = cabeza;
        int pos = 0;
        while (actual != null) {
            if (actual.getValor().equals(elemento)) {
                return pos;
            }
            actual = actual.getSiguiente();
            pos++;
        }
        return -1;
    }

    /**
     * Elimina todos los elementos de la lista.
     */
    @Override
    public final void limpiar() {
        cabeza = null;
        longitud = 0;
        centinela = null;
    }

    /**
    * Devuelve la lista en forma de cadena.
    * @return devuelve una cadena que contiene todos los elementos
    */
    @Override
    public final String toString() {
        StringBuilder cadena = new StringBuilder();
        cadena.append("\n");
        Celda<T> actual = cabeza;
        while (actual != null) {
            cadena.append(actual.toString());
            actual = actual.getSiguiente();
            if (actual != null) {
                cadena.append(" -> ");
            }
        }
        return cadena.toString();
    }


    /**
     * Devuelve la cabeza de la lista.
     * @return devuelve una Celda con la cabeza de la lista.
     */
    public final Celda<T> getCabeza() {
        return cabeza;
    }

    /**
     * Devuelve el centinela de la lista.
     * @return devuelve una Celda con la centinela de la lista.
     */
    public final Celda<T> getCentinela() {
        return centinela;
    }
    
    /**
     * Ordena una lista segun el comarador dado
     * @param lista es la lista a orden
     * @param c es el comparador que define la comparacion
     */
    public static void quicksort(ListaLigada lista,Comparator c){
        quicksort(lista,0,lista.longitud()-1,c);
    }
    
     /**
     * Version recursiva de quicksort
     * @param lista es la lista a orden
     * @param c es el comparador que define la comparacion
     */
    private static void quicksort(ListaLigada lista,int p, int r,Comparator c){
        if(p<r) {
            int q = lista.Particion(p, r, c);
            quicksort(lista,p,q-1,c);
            quicksort(lista,q+1,r,c);
        }
    }
    
      /**
     * Particina la lista para quicksort
     * @param p el indice inferior
     * @param r es el indice superior
     * @param c es el comparador que define la comparacion
     */
    private int Particion(int p, int r, Comparator c) {
        T x=obtener(r);
        int i = p-1;
        for(int j=p;j<r;j++){
            if(c.compare(obtener(j), x)<=0){
                i++;
                swap(i,j);
            }
        }
        swap(i+1, r);
        return i+1;
    }
    
     /**
     * Cambia de lugar dos elementos
     * @param i es el indice del primer elemento
     * @param j es el indice del segundo elemento
     */
    private void swap(int i, int j){
        if(i!=j){
            Celda<T> c1 = obtenerCelda(i);
            Celda<T> c2 = obtenerCelda(j);
            Celda<T> c1ant = obtenerCelda(i-1);
            Celda<T> c1sig = c1.getSiguiente();
            Celda<T> c2ant = obtenerCelda(j-1);
            Celda<T> c2sig = c2.getSiguiente();
            if(c1sig == c2) {
                if(c1ant != null) c1ant.setSiguiente(c2);
                else cabeza = c2;
                c2.setSiguiente(c1);
                c1.setSiguiente(c2sig);
            }
            else if(c2sig == c1) {
                if(c2ant!=null) c2ant.setSiguiente(c1);
                else cabeza = c1;
                c1.setSiguiente(c2);
                c2.setSiguiente(c1sig);
            }
            else{
                c1.setSiguiente(c2sig);
                c2.setSiguiente(c1sig);
                if(c1ant!=null) c1ant.setSiguiente(c2);
                else cabeza = c2;
                if(c2ant!=null) c2ant.setSiguiente(c1);
                else cabeza = c1;
            }
        }
    }

}
