/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package decine;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mario
 */
public class Critica {
    
    private String titulo;
    private String comentario;
    
    private UsuarioVIP miUsuarioVIP;
    
    Critica(UsuarioVIP uVIP, String titulo, String comentario){
        miUsuarioVIP = uVIP;
        this.titulo=titulo;
        this.comentario=comentario;
    }
    
    List obtenerDatosCritica(){
        
        List datosCritica = new ArrayList();
        String nombreVIP = miUsuarioVIP.getNombre();
        
        datosCritica.add(titulo);
        datosCritica.add(comentario);
        datosCritica.add(nombreVIP);
        
        return datosCritica;
        
    }
}
