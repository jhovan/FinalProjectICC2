
package josejhovangallardovaldez_proyectofinal;
import java.util.Comparator;

/**
 *Clase OrdenarPorIdDesc
 * @author: Jhovan Gallardo
 * @version: 12/06/2016/
 */
public class OrdenarPorIdDesc implements Comparator<Contenedor> {

    /**
     * Comapra contenedores por Id descendientemente
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(Contenedor o1, Contenedor o2) {
        return o2.getId()- o1.getId(); 
    }
}
