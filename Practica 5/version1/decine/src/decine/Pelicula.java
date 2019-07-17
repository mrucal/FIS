/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package decine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Mario
 */
public class Pelicula {
    
    private String titulo;
    private String tituloOriginal;
    private int fechaEstreno;
    private int duracion;
    private String guion;
    private String musica;
    private String pais;
    private String webOficial;
    private String productora;
    private String sinopsis;
    private double recaudacion;
    
    private List <Genero> misGeneros = new ArrayList();
    private Map <String,Director> misDirectores = new HashMap();
    
    Pelicula(String titulo, String tituloOriginal, int fechaEstreno, int duracion, String guion, String musica, String pais, String webOficial, String productora, String sinopsis, double recaudacion){
        
        this.titulo=titulo;
        this.tituloOriginal=tituloOriginal;
        this.fechaEstreno=fechaEstreno;
        this.duracion=duracion;
        this.guion=guion;
        this.musica=musica;
        this.pais=pais;
        this.webOficial=webOficial;
        this.productora=productora;
        this.sinopsis=sinopsis;
        this.recaudacion=recaudacion;
    
    }
    
    void vincularGenero(Genero miGenero){
        misGeneros.add(miGenero);
    }
    
    void vincularDirector(Director miDirector){
        misDirectores.put(miDirector.obtenerNombre(),miDirector);
    }

    
}
