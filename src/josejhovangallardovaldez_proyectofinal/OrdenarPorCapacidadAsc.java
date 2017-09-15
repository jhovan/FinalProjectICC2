
package josejhovangallardovaldez_proyectofinal;
import java.util.Comparator;

/**
 *Clase OrdenarPorCapacidadAsc
 * @author: Jhovan Gallardo
 * @version: 12/06/2016/
 */
public class OrdenarPorCapacidadAsc implements Comparator<Contenedor> {

    /**
     *Compara conenedores asc por capacidad ascendientemente
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(Contenedor o1, Contenedor o2) {
        return o1.getCapD()- o2.getCapD(); 
    }
}
