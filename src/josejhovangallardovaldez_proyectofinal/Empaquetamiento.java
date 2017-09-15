
package josejhovangallardovaldez_proyectofinal;
import  josejhovangallardovaldez_proyectofinal.util.*;
import  java.io.*;
import java.util.Comparator;

/**
 *Clase Empaquetamiento que organiza objetos
 * en contenedores
 * @author: Jhovan Gallardo
 * @version: 12/06/2016/
 */
public class Empaquetamiento {
    
    private int capacidad,contador, objetos;
    private Contenedor aux;
    private ArbolAVL<Contenedor> arbol;
    private ListaLigada<Contenedor> contenedores;
    
    

    /**
     * Crea un empaquetamiento partiendo de los objetos
     * leidos desde un archivo de texto
     */
        public Empaquetamiento() {
        aux = new Contenedor(-1,capacidad);
        arbol = new ArbolAVL();
        contador = 1;
        objetos = 0;
        contenedores = new ListaLigada();
         try {

            int id, tamano;
            String nombre, descripcion;
            Objeto objeto;
            
            String directorioActual = System.getProperty("user.dir");
        //String directorioActual = LeerArchivo.class.getProtectionDomain().getCodeSource().getLocation().getPath();        

            String ruta = directorioActual + File.separator + "src" + File.separator + "data" + File.separator + "entrada.txt";
            System.out.println("Ruta: " + ruta);

            // Cargamos el buffer con el contenido del archivo
            BufferedReader br = new BufferedReader(new FileReader(ruta));

            StringBuffer bs = new StringBuffer();
            String linea;
            linea=br.readLine();
            capacidad = Integer.parseInt(linea);
            
            System.out.print("\nObjetos:");
            
            while ((linea = br.readLine()) != null) {
                String[] parametros = linea.split(" ");
                id = Integer.parseInt(parametros[0]);
                nombre = parametros[1];
                tamano = Integer.parseInt(parametros[2]);
                descripcion="";
                for(int i=3;i<parametros.length;i++){
                    descripcion+=parametros[i]+" ";
                }
                objeto = new Objeto(id,nombre, tamano, descripcion);
                agregar(objeto);
            }
            System.out.println(bs);
            br.close();            
        } catch (IOException e) {
            System.out.println("Archivo no encontrado");
            System.out.println("El error es"+e.toString());
        }
    }
    
    /**
     * Agrega un objeto al empaquetamiento
     * @param objeto es el objeto a agregar
     */
    public final void agregar(Objeto objeto) {
        System.out.print("\n");
        System.out.print(objeto.toString());
        objetos++;
        for(int i=objeto.getTamano();i<=capacidad;i++){
            aux.setCapD(i);
            if(arbol.buscarSimilar(aux)!=null){
                Contenedor elemento = arbol.buscarSimilar(aux);
                arbol.eliminar(elemento);
                elemento.agregar(objeto);
                //System.out.print("AGREGAR:" + elemento.toString());
                arbol.agregar(elemento);
                //System.out.println("AGREGADO CORRECTAMENTE");
                return;
            }
        }
        Contenedor nuevo = new Contenedor(contador,capacidad);
        nuevo.agregar(objeto);
        // System.out.println("Inorden:" + arbol.recorridoInOrden().toString());
        //System.out.println("Nuevo elemento:" + objeto.toString());
        arbol.agregar(nuevo);
        //System.out.println("Nuevo inorden:" + arbol.recorridoInOrden().toString());
        contenedores.agregar(nuevo);
        contador++;
    }
    
    /**
     * Devuelve una cadena ordenada del empaquetamiento
     * @param comparador define la forma de ordenar
     * @return una cadena
     */
    public String toString(Comparator comparador){
        StringBuilder cadena = new StringBuilder();
        cadena.append("\nTamaño:" + capacidad + "\tObjetos:" + objetos + "\tContenedores usados:" + (contador-1));
        cadena.append("\n\n");
        ListaLigada.quicksort(contenedores, comparador);
        for(int i = 0;i<contenedores.longitud();i++){
            cadena.append(contenedores.obtener(i).toString());
            cadena.append("\n");
            cadena.append("\n");
        }
        return cadena.toString();
    }
    
    /**
     * Escribe en un archivo de texto el empaquetamiento
     * @param comparador define la forma en que se ordena
     */
    public void escribirArchivo(Comparator comparador){
            try {

            String directorioActual = System.getProperty("user.dir");     

            String rutaArchivo = directorioActual + File.separator + "src" + File.separator + "data" + File.separator + "archivo.txt";
            System.out.println("Ruta: " + rutaArchivo);

             BufferedWriter out = new BufferedWriter(new FileWriter(rutaArchivo, false));
             out.write(toString(comparador));
             out.close();
            
            
        } catch (IOException e) {
            System.out.println("Archivo no encontrado");
            System.out.println("El error es"+e.toString());
        }

    }
    
    /**
     * Busca un contenedor por id y muestra
     * su contenido
     * @param id del contenedor
     */
    public void buscarContenedor(int id) {
        if(id >=0 && id < contenedores.longitud()){
            System.out.println(contenedores.obtener(id-1));
        } else {
            System.out.println("Contenedor no encontrado");
        }
    }
    
    /**
     * Busca un objeto por su Id en los contenedores
     * y devuelve el contenedor donde se encuentra
     * @param id del objeto
     */
    public void buscarObjetoId(int id) {
        Objeto aux = new Objeto(id,"",-1,"");
        System.out.println("\nEl objeto se encuentra en los contenedores:\n");
        for(int i = 0;i < contenedores.longitud();i++) {
            if(contenedores.obtener(i).contiene(aux)){
                System.out.println("Conteneodor:" + (i+1) + "\n");
            }
        }
    }
}
