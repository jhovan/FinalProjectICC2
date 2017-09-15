
package josejhovangallardovaldez_proyectofinal;
import java.util.Comparator;

/**
 *Clase OrdenarObjetosPorId
 * @author: Jhovan Gallardo
 * @version: 12/06/2016/
 */
public class OrdenarObjetosPorId implements Comparator<Objeto> {

    /**
     * Compara objetos por Id
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(Objeto o1, Objeto o2) {
        return o1.getId()- o2.getId(); 
    }
}
