
package josejhovangallardovaldez_proyectofinal;
import java.util.Comparator;
/**
 *Clase OrdenarPorObjetosDesc
 * @author: Jhovan Gallardo
 * @version: 12/06/2016/
 */
public class OrdenarPorObjetosDesc implements Comparator<Contenedor> {

    /**
     * Compara contenedores por numero de objetos
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(Contenedor o1, Contenedor o2) {
        return o2.getObjetos() - o1.getObjetos(); 
    }
}
