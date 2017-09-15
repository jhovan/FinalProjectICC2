
package josejhovangallardovaldez_proyectofinal.util;


/**
 *Clase arbol AVL con nodos
 * @param <E> es el tipo deel arbol
 * @author: Jhovan Gallardo
 * @version: 05/05/2016/
 */

public class ArbolAVL<E extends Comparable> implements Arbol<E> {

    private Nodo<E> root;


    public ArbolAVL(){
        root=null;
    }

     /**
     * Agrega un elemento al arbol
     * @param elemento es el valor a agregar
     */
    @Override
    public void agregar(E elemento) {
        root=agregar(elemento,root);
    }


     /**
     * Version recursiva del metodo agregar
     * @param recibe el elemento y el nodo en el que se hace la recursion
     * @return regresa el subarbol
     */
    private Nodo<E> agregar(E x,Nodo<E> t){
        if(t==null){
            t=new Nodo<E>(x);
        }
        else if(x.compareTo(t.getValor())<0){
            t.setHijoIzquierdo(agregar(x,t.getHijoIzquierdo()));
            if(altura(t.getHijoIzquierdo())-altura(t.getHijoDerecho())==2){
                if(x.compareTo(t.getHijoIzquierdo().getValor())<0){
                    t=rotacionIzquierda(t);
                }
                else{
                    t=dobleRotacionIzquierda(t);
            }
            }
        }
        else if(x.compareTo(t.getValor())>0){
            t.setHijoDerecho(agregar(x,t.getHijoDerecho()));
            if(altura(t.getHijoDerecho())-altura(t.getHijoIzquierdo())==2){
                if(x.compareTo(t.getHijoDerecho().getValor())>0){
                    t=rotacionDerecha(t);
                }
                else{
                    t=dobleRotacionDerecha(t);
                }
            }
        }
        t.setAltura(max(altura(t.getHijoIzquierdo()),altura(t.getHijoDerecho()))+1);
        return t;
    }

    /**
     * Elimina un elemento y devuelve si pudo hacerlo
     * @return devuelve true si lo elimina, y false si no
     * @param elemento es el valor a eliminar
     */
    @Override
    public boolean eliminar(E elemento) {
        boolean n=buscarElemento(elemento);
        root=eliminar(elemento, root);
        return n;
    }

    /**
     * Version recursiva del metodo eliminar
     * @return devuelve un subarbol
     * @param elemento es el valor a eliminar y t es el nodo donde se hace recursion
     */
    public Nodo<E> eliminar(E x,Nodo<E> t){
        if(t==null){
            return null;
        }
        if(x.compareTo(t.getValor())<0){
            t.setHijoIzquierdo(eliminar(x,t.getHijoIzquierdo()));
            int i=t.getHijoIzquierdo()!=null ? t.getHijoIzquierdo().getAltura():0;
            if((t.getHijoDerecho()!=null)&&(t.getHijoDerecho().getAltura()-i>=2)){
                int alturaD=t.getHijoDerecho().getHijoDerecho()!=null ? t.getHijoDerecho().getHijoDerecho().getAltura():0;
                int alturaI=t.getHijoDerecho().getHijoIzquierdo() !=null ? t.getHijoDerecho().getHijoIzquierdo().getAltura():0;
                if(alturaD>=alturaI)
                    t=rotacionIzquierda(t);
                else
                    t=dobleRotacionDerecha(t);
            }
        }
        else if(x.compareTo(t.getValor())>0){
            t.setHijoDerecho(eliminar(x,t.getHijoDerecho()));
            int d = t.getHijoDerecho()!=null ? t.getHijoDerecho().getAltura():0;
            if((t.getHijoIzquierdo()!=null)&&(t.getHijoIzquierdo().getAltura()-d>=2)){
                int alturaI=t.getHijoIzquierdo().getHijoIzquierdo() != null ? t.getHijoIzquierdo().getHijoIzquierdo().getAltura():0;
                int alturaD=t.getHijoIzquierdo().getHijoDerecho() != null ? t.getHijoIzquierdo().getHijoDerecho().getAltura():0;
                if(alturaI>=alturaD)
                    t=rotacionDerecha(t);
                else
                    t=dobleRotacionIzquierda(t);
            }
        }
        else if(t.getHijoIzquierdo()!=null){
            Nodo<E> nodo=findMax(t.getHijoIzquierdo());
            E valor=nodo.getValor();
            t.setValor(valor);
            eliminar(t.getValor(),t.getHijoIzquierdo());
            if((t.getHijoDerecho()!=null)&&(t.getHijoDerecho().getAltura()-t.getHijoIzquierdo().getAltura()>=2)){
                int alturaD=t.getHijoDerecho().getHijoDerecho()!=null ? t.getHijoDerecho().getHijoDerecho().getAltura():0;
                int alturaI=t.getHijoDerecho().getHijoIzquierdo() !=null ? t.getHijoDerecho().getHijoIzquierdo().getAltura():0;
                if(alturaD>=alturaI)
                    t=rotacionIzquierda(t);
                else
                    t=dobleRotacionDerecha(t);
            }
        }
        else{
            t=t.getHijoIzquierdo()!=null ? t.getHijoIzquierdo():t.getHijoDerecho();
        }
        if(t!=null){
            int alturaI=t.getHijoIzquierdo()!=null ? t.getHijoIzquierdo().getAltura():0;
            int alturaD=t.getHijoDerecho()!=null ? t.getHijoDerecho().getAltura():0;
            t.setAltura(max(alturaD,alturaI)+1);
        }
        return t;
    }


    /**
     * Nos devuelve true si un elemento pertenece al arbol
     * @return devuelve true si lo encuentra, y false si no
     * @param elemento es el valor a eliminar
     */
    @Override
    public boolean buscarElemento(E elemento){
        return buscarElemento(elemento,root);
    }


    /**
     * Version recursiva del metodo buscar elementos
     * @return devuelve true si lo elimina, y false si no
     * @param elemento es el valor a buscar y t el nodo a buscar
     */
    public boolean buscarElemento(E x, Nodo<E> t){
        if(t==null){
            return false;
        }
        else if(x.compareTo(t.getValor())<0){
            return buscarElemento(x,t.getHijoIzquierdo());
        }
        else if(x.compareTo(t.getValor())>0){
            return buscarElemento(x,t.getHijoDerecho());
        }
        return true;
    }

     /**
     * Devuelve una lista con el recorrido en preorden del arbol
     * @return devuelve la lista con el recorrido
     */
    @Override
    public Lista<E> recorridoPreOrden() {
        Lista<E> lista=new ListaLigada();
        recorridoPreOrden(root,lista);
        return lista;
    }


    /**
     * Version recursiva del recorrido en preorden
     * @param recibe el nodo a recorrer y la lista a modificar
     */
    private void recorridoPreOrden(Nodo<E> t,Lista<E> lista) {
        if(t!=null){
            lista.agregar(t.getValor());
            if(t.getHijoIzquierdo()!=null)
                recorridoPreOrden(t.getHijoIzquierdo(),lista);
            if(t.getHijoDerecho()!= null)
                recorridoPreOrden(t.getHijoDerecho(),lista);
        }
    }


     /**
     * Devuelve una lista con el recorrido en inorden del arbol
     * @return devuelve la lista con el recorrido
     */
    @Override
    public Lista<E> recorridoInOrden() {
        Lista<E> lista=new ListaLigada();
        recorridoInOrden(root,lista);
        return lista;
    }

    /**
     * Version recursiva del recorrido en inorden
     * @param recibe el nodo a recorrer y la lista a modificar
     */
    private void recorridoInOrden(Nodo<E> t,Lista<E> lista) {
        if(t!=null){
            if(t.getHijoIzquierdo()!=null)
                recorridoInOrden(t.getHijoIzquierdo(),lista);
            lista.agregar(t.getValor());
            if(t.getHijoDerecho()!= null)
                recorridoInOrden(t.getHijoDerecho(),lista);
        }
    }

     /**
     * Devuelve una lista con el recorrido en postorden del arbol
     * @return devuelve la lista con el recorrido
     */
    @Override
    public Lista<E> recorridoPostOrden() {
        Lista<E> lista=new ListaLigada();
        recorridoPostOrden(root,lista);
        return lista;
    }

    /**
     * Version recursiva del recorrido en postorden
     * @param recibe el nodo a recorrer y la lista a modificar
     */
    private void recorridoPostOrden(Nodo<E> t,Lista<E> lista) {
        if(t!=null){
            if(t.getHijoIzquierdo()!=null)
                recorridoPostOrden(t.getHijoIzquierdo(),lista);
            if(t.getHijoDerecho()!= null)
                recorridoPostOrden(t.getHijoDerecho(),lista);
            lista.agregar(t.getValor());
        }
    }


    /**
     * Regresa la altura de un nodo
     * @return regresa un entero con la altura
     * @param t es el nodo a obtener su altura
     */
    public int altura(Nodo<E> t){
        if(t==null) return -1;
        return t.getAltura();
    }

    /**
     * Regresa el maximo de dos numeros
     * @return devuelve el maximo valor
     * @param a y b son enteros a comporar
     */
    public int max(int a, int b ){
        if(a>b) return a;
        return b;
    }

    /**
     * Encuentra el maximo valor en el un subarbol
     * @return devuelve el nodo con el valor maximo
     * @param t es la raiz del subarbol a consultar
     */
    private Nodo<E> findMax( Nodo<E> t )
    {
        if( t == null )
            return t;

        while( t.getHijoDerecho() != null )
            t = t.getHijoDerecho();
        return t;
    }

     /**
     * Realiza la rotacion izquierda simple sobre un nodo
     * @return devuelve el subarbol rotado
     * @param recibe la raiz del subarbol a rotar
     */
    private Nodo<E> rotacionIzquierda(Nodo<E> k2){
        Nodo<E> k1=k2.getHijoIzquierdo();
        k2.setHijoIzquierdo(k1.getHijoDerecho());
        k1.setHijoDerecho(k2);
        k2.setAltura(max(altura(k2.getHijoIzquierdo()),altura(k2.getHijoDerecho()))+1);
        k1.setAltura(max(altura(k1.getHijoIzquierdo()),k2.getAltura())+1);
        return k1;
    }

     /**
     * Realiza la rotacion izquierda doble sobre un nodo
     * @return devuelve el subarbol rotado
     * @param recibe la raiz del subarbol a rotar
     */
    private Nodo<E> dobleRotacionIzquierda(Nodo<E> k3){
        k3.setHijoIzquierdo(rotacionDerecha(k3.getHijoIzquierdo()));
        return rotacionIzquierda(k3);
    }
    
     /**
     * Realiza la rotacion derecha simple sobre un nodo
     * @return devuelve el subarbol rotado
     * @param recibe la raiz del subarbol a rotar
     */
    private Nodo<E> rotacionDerecha(Nodo<E> k1){
        Nodo<E> k2=k1.getHijoDerecho();
        k1.setHijoDerecho(k2.getHijoIzquierdo());
        k2.setHijoIzquierdo(k1);
        k1.setAltura(max(altura(k1.getHijoIzquierdo()),altura(k1.getHijoDerecho()))+1);
        k2.setAltura(max(altura(k2.getHijoDerecho()),k1.getAltura())+1);
        return k2;
    }


     /**
     * Realiza la rotacion derecha doble sobre un nodo
     * @return devuelve el subarbol rotado
     * @param recibe la raiz del subarbol a rotar
     */
    private Nodo<E> dobleRotacionDerecha(Nodo<E> k1){
        k1.setHijoDerecho(rotacionIzquierda(k1.getHijoDerecho()));
        return rotacionDerecha(k1);
    }
    
     /**
     * Nos devuelve un elemento con el mismo valor (tomando en cuenta
     * el valor usado para el metodo compareTo)
     * @return devuelve true si lo encuentra, y false si no
     * @param elemento es el valor a eliminar
     */
    public E buscarSimilar(E elemento){
        return buscarSimilar(elemento,root);
    }

    /**
     * Version recursiva del metodo buscar similar
     * @return devuelve true si lo elimina, y false si no
     * @param x es el valor a eliminar y t el nodo a buscar
     */
    public E buscarSimilar(E x, Nodo<E> t){
        if(t==null){
            return null;
        }
        else if(x.compareTo(t.getValor())<0){
            t = t.getHijoIzquierdo();
            return buscarSimilar(x,t);
        }
        else if(x.compareTo(t.getValor())>0){
            t = t.getHijoDerecho();
            return buscarSimilar(x,t);
        }
        return t.getValor();
    }

}

