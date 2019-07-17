/*
 * To change this template, choose Tools | Templates
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
 * @author Mario
 */
public class Pelicula {
    
    private String titulo;
    private String tituloOriginal;
    private int añoEstreno;
    private int duracion;
    private String guion;
    private String musica;
    private String pais;
    private String webOficial;
    private String productora;
    private String sinopsis;
    private double recaudacion;
    private double valoracionMedia;
    
    private List <Genero> misGeneros = new ArrayList();
    private Map <String,Director> misDirectores = new HashMap();
    private Map <String, Actor> misActores = new HashMap();
    private List<Premio> misPremios = new ArrayList();
    private Map <String,Critica> misCriticas = new HashMap();
    
    Pelicula(String titulo, String tituloOriginal, int fechaEstreno, int duracion, String guion, String musica, String pais, String webOficial, String productora, String sinopsis, double recaudacion){
        
        this.titulo=titulo;
        this.tituloOriginal=tituloOriginal;
        this.añoEstreno=fechaEstreno;
        this.duracion=duracion;
        this.guion=guion;
        this.musica=musica;
        this.pais=pais;
        this.webOficial=webOficial;
        this.productora=productora;
        this.sinopsis=sinopsis;
        this.recaudacion=recaudacion;
        this.valoracionMedia=0;
    
    }
    
    String getTitulo(){
        return titulo;
    }
    
    Map<String,Director> getDirectores(){
        return misDirectores;
    }
    
    Map<String,Actor> getActores(){
        return misActores;
    }
    
    List<Genero> getGeneros(){
        return misGeneros;
    }
    
    int getAño(){
        return añoEstreno;
    }
    
    void vincularGenero(Genero miGenero){
        misGeneros.add(miGenero);
    }
    
    void vincularDirector(Director miDirector){
        misDirectores.put(miDirector.getNombre(),miDirector);
    }
    void vincularActor (Actor miActor){
        misActores.put(miActor.getNombre(), miActor);
    }
    
    void incluirPremio(FestivalPremio premioFestival, String categoria, int año){
        misPremios.add(new Premio(premioFestival,categoria,año));
    }
    
    void incluirCritica(UsuarioVIP uVIP, String titulo, String comentario){
        misCriticas.put(titulo, new Critica(uVIP, titulo, comentario));
    }
    
    List<List> obtenerDatosBasicos(){
        
        List<List> datosBasicos = new ArrayList();
        List<String> aux = new ArrayList();
        List<String> nombreDirectores = new ArrayList();
        List<String> nombreActores = new ArrayList();
        
        aux.add(titulo);
        aux.add(Integer.toString(añoEstreno));
        aux.add(Integer.toString(duracion));
        aux.add(Double.toString(valoracionMedia));
        datosBasicos.add(aux);
        
        String nombreD;
        for(String key: misDirectores.keySet()){
             nombreD=misDirectores.get(key).getNombre();
             nombreDirectores.add(nombreD);
        }
        
        /*Set setD = misDirectores.entrySet();
        Iterator iterD = setD.iterator();
        String nombreD;
        while(iterD.hasNext()){
            Map.Entry entryD =(Map.Entry) iterD.next();
            nombreD=((Director)(entryD.getValue())).obtenerNombre();
            nombreDirectores.add(nombreD);
        }*/
        datosBasicos.add(nombreDirectores);
        
        String nombreA;
        for(String key: misActores.keySet()){
             nombreA=misActores.get(key).getNombre();
             nombreActores.add(nombreA);
        }
        /*
        Set setA = misActores.entrySet();
        Iterator iterA = setA.iterator();
        String nombreA;
        while(iterA.hasNext()){
            Map.Entry entryA =(Map.Entry) iterA.next();
            nombreA=((Actor)(entryA.getValue())).obtenerNombre();
            nombreDirectores.add(nombreA);
        }*/
        datosBasicos.add(nombreActores);
        
        return datosBasicos;
        
    }
    
    List<List> obtenerDatosComplementarios(){
        List<List> datosComplementarios = new ArrayList();
        List datosPremio = new ArrayList();
        List<List> premios = new ArrayList();
        List datosCritica = new ArrayList();
        List<List> criticas = new ArrayList();
        
        List<String> aux = new ArrayList();
        
        datosComplementarios.add(misGeneros);
        aux.add(sinopsis);
        datosComplementarios.add(aux);
        
        for(Premio premio:misPremios){
            datosPremio=premio.obtenerDatos();
            premios.add(datosPremio);
        }
        
        datosComplementarios.add(premios);
        
        
        for(String key : misCriticas.keySet()){
            datosCritica = misCriticas.get(key).obtenerDatosCritica();
            criticas.add(datosCritica);
        }
        
        datosComplementarios.add(criticas);
        
        return datosComplementarios;
    }
   
    
    
}
