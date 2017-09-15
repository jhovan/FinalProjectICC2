
package josejhovangallardovaldez_proyectofinal;
import java.util.Comparator;
/**
 *Clase OrdenarPorObjetosAsc
 * @author: Jhovan Gallardo
 * @version: 12/06/2016/
 */
public class OrdenarPorObjetosAsc implements Comparator<Contenedor> {

    /**
     * Compara contenedores por numero de objetos
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(Contenedor o1, Contenedor o2) {
        return o1.getObjetos() - o2.getObjetos(); 
    }
}
