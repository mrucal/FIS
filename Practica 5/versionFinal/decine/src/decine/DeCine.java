/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package decine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
    public Set<String> obtenerDirectores(){
     return  misDirectores.keySet();    
    }
    public Set<String> obtenerPeliculas(){
     return  misPeliculas.keySet();    
    }
    public Set<String> obtenerActores(){
     return  misActores.keySet();    
    }
    public Set<String> obtenerGeneros(){
        Set<String> generos=new HashSet();
        generos.add(Genero.Aventura.toString());
        generos.add(Genero.CienciaFiccion.toString());
        generos.add(Genero.Comedia.toString());
        generos.add(Genero.Drama.toString());
        generos.add(Genero.Terror.toString());
        return generos;
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
    
    private FestivalPremio buscarPremio(String nombre) throws Exception{
        if(!misFestivales.containsKey(nombre)) throw new Exception ("No existe el festival con ese nombre");
        return misFestivales.get(nombre);
    }
    
    private UsuarioVIP buscarUsuarioVIP(String correo) throws Exception{
        if(!misUsuarios.containsKey(correo)) throw new Exception ("No existe el usuarioVIP con ese correo");
        return misUsuarios.get(correo);
    }
    
     public void nuevaPelicula(String titulo, String tituloOriginal, int fechaEstreno, int duracion, String guion, String musica, String pais, String webOficial, String productora, String sinopsis, double recaudacion) throws Exception{
        if(misPeliculas.containsKey(titulo))
            throw new Exception("Esa pelicula ya está incluida en el sistema");
         misPeliculas.put(titulo, new Pelicula(titulo, tituloOriginal, fechaEstreno, duracion, guion, musica, pais, webOficial, productora, sinopsis, recaudacion));
     }
     
     public void nuevoDirectorPelicula(String tituloPelicula,String nombreDirector) throws Exception{
         Pelicula miPelicula = buscarPelicula(tituloPelicula);
         Director miDirector = buscarDirector(nombreDirector);
         miPelicula.vincularDirector(miDirector);
     }
     
     public void nuevoActorPelicula(String tituloPelicula,String nombreActor) throws Exception{
         Pelicula miPelicula = buscarPelicula(tituloPelicula);
         Actor miActor = buscarActor(nombreActor);
         miPelicula.vincularActor(miActor);
     }
     
     public void nuevGeneroPelicula(String tituloPelicula,String idGenero) throws Exception{
         Pelicula miPelicula = buscarPelicula(tituloPelicula);
         miPelicula.vincularGenero(Genero.valueOf(idGenero));
     }
     
     public void nuevoPremio(String titulo, String nombreFP, String categoria, int año) throws Exception{
         Pelicula pelicula = buscarPelicula(titulo);
         FestivalPremio premioFestival = buscarPremio(nombreFP);
         pelicula.incluirPremio(premioFestival,categoria,año);
     }
     
     private boolean existePelicula(String titulo){
         return misPeliculas.containsKey(titulo);
     }
     
     private Map<String,Pelicula> seleccionarPeliculas(String[] criterioBusqueda){
         
         Map <String, Pelicula> listaPeliculas = new HashMap();
         
         for(String key: misPeliculas.keySet()){
             Pelicula pelicula = misPeliculas.get(key);
             
             if(criterioBusqueda[0].equals("1") && criterioBusqueda[1].equals(pelicula.getTitulo())){
                 listaPeliculas.put(pelicula.getTitulo(), pelicula);
             }
             if(criterioBusqueda[0].equals("2")){
                 for(String keyD: pelicula.getDirectores().keySet()){
                     Director director = pelicula.getDirectores().get(keyD);
                     if(criterioBusqueda[1].equals(director.getNombre()))
                         listaPeliculas.put(pelicula.getTitulo(), pelicula);
                 }
             }
             if(criterioBusqueda[0].equals("3")){
                 for(String keyA: pelicula.getActores().keySet()){
                     Actor actor = pelicula.getActores().get(keyA);
                     if(criterioBusqueda[1].equals(actor.getNombre()))
                         listaPeliculas.put(pelicula.getTitulo(), pelicula);
                 }
             }
             if(criterioBusqueda[0].equals("4")){
                 for(Genero g: pelicula.getGeneros()){
                     if(criterioBusqueda[1].equals(g.toString())){
                         listaPeliculas.put(pelicula.getTitulo(), pelicula);
                     }
                 }
             }
             if(criterioBusqueda[0].equals("5") && criterioBusqueda[1].equals(String.valueOf(pelicula.getAño()))){
                 listaPeliculas.put(pelicula.getTitulo(), pelicula);
             }
             
         }
         return listaPeliculas;
     }
     
     public List<List<List>> busquedaPelicula(String[] criterioBusqueda){
         
         List<List<List>> resultadoBusqueda = new ArrayList();
         List<List> datosComplementarios = new ArrayList();      
         List<List> datosBasicos = new ArrayList();
         Map <String, Pelicula> listaPeliculas = seleccionarPeliculas(criterioBusqueda);
         
         for(String key: listaPeliculas.keySet()){
             List<List> datosPelicula = new ArrayList();
             Pelicula pelicula=listaPeliculas.get(key);
             datosBasicos=pelicula.obtenerDatosBasicos();
             datosPelicula.add(datosBasicos);
             
             if(criterioBusqueda[0].equals("1")){
                datosComplementarios=pelicula.obtenerDatosComplementarios();
                datosPelicula.add(datosComplementarios);
             }
             resultadoBusqueda.add(datosPelicula);
         }
         return resultadoBusqueda;
     }
     
     public void criticaPelicula(String correo, String titulo, String tituloCritica, String comentario) throws Exception{
         UsuarioVIP uVIP = buscarUsuarioVIP(correo);
         Pelicula peli = buscarPelicula(titulo);
         peli.incluirCritica(uVIP,tituloCritica,comentario);
     }
}