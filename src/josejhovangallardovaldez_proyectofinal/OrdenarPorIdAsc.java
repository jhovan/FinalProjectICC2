
package josejhovangallardovaldez_proyectofinal;
import java.util.Comparator;

/**
 *Clase OrdenarPorIdAsc
 * @author: Jhovan Gallardo
 * @version: 12/06/2016/
 */
public class OrdenarPorIdAsc implements Comparator<Contenedor> {

    /**
     * Compara contenedores por Id ascendientemente
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(Contenedor o1, Contenedor o2) {
        return o1.getId()- o2.getId(); 
    }
}
