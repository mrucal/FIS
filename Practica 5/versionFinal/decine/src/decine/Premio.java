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
public class Premio {
    
    private String categoriaPremio;
    private int año;
    
    FestivalPremio miFestivalPremio;
    
    Premio(FestivalPremio premio,String categoriaPremio, int año){
        this.miFestivalPremio=premio;
        this.categoriaPremio=categoriaPremio;
        this.año=año;
    }
    
    List obtenerDatos(){
        List datosPremio = new ArrayList();
        
        String nombreFP = miFestivalPremio.getNombre();
        datosPremio.add(nombreFP);
        datosPremio.add(categoriaPremio);
        datosPremio.add(año);       
        
        return datosPremio;
    }
}
