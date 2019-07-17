/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package decine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author ana
 */
public class DeCine { 
    
    // Definición de atributos 
    private Map<String,UsuarioVIP> misUsuarios = new HashMap();
    private Map<String, Actor> misActores = new HashMap();
    private Map <String, Director> misDirectores = new HashMap();
    private Map <String, FestivalPremio> misFestivales = new HashMap();
    private Map <String, Pelicula> misPeliculas = new HashMap();
    // incluir los que faltan
    
    // implementación del Singleton
    private static DeCine instancia = new DeCine();
    public static DeCine getDeCine(){
        return instancia;
    }
    private DeCine(){}
    
    // Búsqueda de un determinado elemento en un Map
    private UsuarioVIP buscarUsuario(String correo) throws Exception{    
        if (!misUsuarios.containsKey(correo)) throw new Exception ("no existe el usuario con ese correo");
        return misUsuarios.get(correo);
    }
    
    // Obtener todos los id (key) de una lista de objetos.
    public Set<String> obtenerUsuariosVIP(){
     return  misUsuarios.keySet();    
    }
     // .... Para todos los demas igual la busqueda de uno concreto o de todas sus claves
   
    // Inicialización del sistema 
    public void incluirActor(String nombre, String nacionalidad, String web){
        misActores.put(nombre, new Actor(nombre,nacionalidad, web));
    }
    public void incluirDirector(String nombre, String nacionalidad, String web){
        misDirectores.put(nombre, new Director(nombre,nacionalidad, web));
    }
    public void incluirFestivalPremio(String nombre){
        misFestivales.put(nombre, new FestivalPremio(nombre));
    }
     public void incluirUsuario(String nombre, String correo){
        misUsuarios.put(correo, new UsuarioVIP(nombre,correo));
    }
    
    private Pelicula buscarPelicula(String titulo) throws Exception{
        if (!misPeliculas.containsKey(titulo)) throw new Exception ("No existe la pelicula con ese titulo.");
        return misPeliculas.get(titulo);
    }
    
    private Director buscarDirector(String nombre) throws Exception{
        if (!misDirectores.containsKey(nombre)) throw new Exception ("No existe el director con ese nombre");
        return misDirectores.get(nombre);
    }
    
    private Actor buscarActor(String nombre) throws Exception{
        if (!misActores.containsKey(nombre)) throw new Exception ("No existe el actor con ese nombre");
        return misActores.get(nombre);
        
    }
     public void nuevaPelicula(String titulo, String tituloOriginal, int fechaEstreno, int duracion, String guion, String musica, String pais, String webOficial, String productora, String sinopsis, double recaudacion) throws Exception{
        if(misPeliculas.containsKey(titulo))
            throw new Exception("Esa pelicula ya está incluida en el sistema");
         misPeliculas.put(titulo, new Pelicula(titulo, tituloOriginal, fechaEstreno, duracion, guion, musica, pais, webOficial, productora, sinopsis, recaudacion));
     }
     
     public void nuevoDirectorPelicula(String tituloPelicula,String nombreDirector) throws Exception{
         Pelicula miPeli = buscarPelicula(tituloPelicula);
         Director miDirector = buscarDirector(nombreDirector);
         miPeli.vincularDirector(miDirector);
     }
     
     public void nuevoActorPelicula(String tituloPelicula,String nombreActor) throws Exception{
         Pelicula miPeli = buscarPelicula(tituloPelicula);
         Actor miActor = buscarActor(nombreActor);
         miPeli.vincularActor(miActor);
     }
     
     public List<List<List>> busquedaPelicula(int criterioBusqueda, String cBusquedaS){
         
         List<List<List>> resultadoBusqueda = new ArrayList();
         List<List> datosPelicula = new ArrayList();
         List<List> datosComplementarios = new ArrayList();      
         List<List> datosBasicos = new ArrayList();
         Map <String, Pelicula> listaPeliculas = seleccionarPeliculas(criterioBusqueda);
         
      /*   
         Set set = listaPeliculas.entrySet();
         Iterator iter = set.iterator();
         while(iter.hasNext()){
             Map.Entry entry = (Map.Entry) iter.next();
             Pelicula pelicula = ((Pelicula)entry.getValue());
             datosBasicos=pelicula.obtenerDatosBasicos();
             datosPelicula.add(datosBasicos);
             if(criterioBusqueda==1){
                 datosComplementarios=pelicula.obtenerDatosComplementarios();
             }
         
         */for(String key: listaPeliculas.keySet()){
             Pelicula pelicula=listaPeliculas.get(key);
             datosBasicos=pelicula.obtenerDatosBasicos();
             datosPelicula.add(datosBasicos);
             
             if(criterioBusqueda==1){
             datosComplementarios=pelicula.obtenerDatosComplementarios();
             datosPelicula.add(datosComplementarios);
             }
             resultadoBusqueda.add(datosPelicula);
         }
         return resultadoBusqueda;
     }
}
