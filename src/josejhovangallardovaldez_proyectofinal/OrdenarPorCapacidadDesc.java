
package josejhovangallardovaldez_proyectofinal;
import java.util.Comparator;

/**
 *Clase OrdenarPorCapacidadDesc
 * @author: Jhovan Gallardo
 * @version: 12/06/2016/
 */
public class OrdenarPorCapacidadDesc implements Comparator<Contenedor> {

    /**
     * Compara contenedores por Capacidad descendientemente
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(Contenedor o1, Contenedor o2) {
        return o2.getCapD()- o1.getCapD(); 
    }
}
