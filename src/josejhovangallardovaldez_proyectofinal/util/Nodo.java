
package josejhovangallardovaldez_proyectofinal.util;

/**
 * Clase nodo para la implementacion de arboles AVL
 * @param <E> es el tipo deel nodo
 * @author: Jhovan Gallardo
 * @version: 05/05/2016/
 */
public class Nodo<E> {
    
    private E valor;
    private Nodo hijoIzquierdo;
    private Nodo hijoDerecho;
    private int altura;

    public Nodo(E valor){
        this.valor=valor;
    }

    public E getValor() {
        return valor;
    }

    public void setValor(E valor) {
        this.valor = valor;
    }

    public Nodo getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(Nodo hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public Nodo getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(Nodo hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura=altura;
    }
}