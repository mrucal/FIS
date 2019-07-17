/* 
Con este main tenéis que probar todo el diseño que os hemos dejado.
Si ejecutáis este código veréis que funciona (permite incluir UsuariosVIP)
Una vez incluidos los usuarios VIP, con la opción 9 de muestran su correos, para elegir uno de ellos
*/ 

package IUDeCine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import decine.Genero;
import decine.DeCine;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author ana
 */
public class Decine {

    /**
     * @param args the command line arguments
     */
  public static void main(String[] args) throws IOException {        
      // Obtención de la única instancia de DeCine, DeCine es un singleton. 
        DeCine unaDeCine = DeCine.getDeCine();      
      
    //Definición de la variable in que va a permitir leer String desde teclado.  
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));	   
     
    // Ejemplos de lectura desde teclado con in.readLine()
	// String s = in.readLine();        //Lectura de un String
	// double d= Double.parseDouble(in.readLine());         // lectura de un duoble
	// int i = Integer.parseInt(in.readLine());         // lectura de un int               
                // Genero estado = Genero.valueOf(in.readLine());       // lectura de un enum     
       
        int opcion = 0; //variable que controla la opción de menú
          
        do{ //do-while que controlara todo el menú
                 try{ // tratamiento de las excepciones. Bloque try en el que se puede producir una excepción y la capturamos
		 
                                //Terminar de diseñar el menú (usando System.out.println(...)) con las opciones que faltan
		 // Podéis hacer vuestros propios diseños de interfaz, esta es la interfaz mínima que tenéis que entregar
                                System.out.println("******** ALTAS*****************************");
                                System.out.println( "1. Dar de alta un película \n" +
                                                             "2. Dar de alta un actor \n"  + 
                                                             "3. Dar de alta un director \n" + 
                                                             "4. Dar de alte un UsuarioVIP \n" +
                                                             "5. Dar de alta un Festival/Premio" );	
                                 
                                System.out.println("\n******  MODIFICACIONES *****************************");                              
                                 System.out.println("6. Incluir un directr en una  película \n"+
                                 	"7. Incluir un actor en una película \n"+
                                 	"8. Incluir genero de película \n"+
                                 	"9. Incluir crítica de película"
                                 );
                                   System.out.println("\n******  CONSULTA  *****************************");
                                 System.out.println( "10. Consultar película" ); 
		    System.out.println("\n****** TERMINAR *****************************");          
                                    System.out.println("0. Terminar");
		 
                                // Lectura de un int, para darle valor a opcion.
                                   opcion = Integer.parseInt(in.readLine()); 
                                   
		
                                // Estructura switch con todas las opciones de menú. Algunos de ellos ya lo tenéis hecho
                                // Tenéis que terminar las opciones que están incompletas y las que no están hechas
                                switch(opcion){
                                    case 1: /*todo lo que hay que hacer para dar de alta una película
                                                        lectura de los valores de inicialización de la pelicula, son: */    
                                                    /* Titulo: ---- */
                                                    System.out.println("Titulo:");
                                                    String Titulo = in.readLine();
                                                     /* Titulo Original ---*/
                                                    System.out.println("Titulo Original:");
                                                    String TituloOriginal = in.readLine();
                                                    /* Fecha de Estreno */
                                                    System.out.println("Año:");
                                                    int ano = Integer.parseInt(in.readLine());
                                                    /* Duracion:---- */
                                                    System.out.println("Duracion en minutos:");
                                                    int duracion = Integer.parseInt(in.readLine());
                                                    /* Guion -- */
                                                    System.out.println("Guion:");
                                                    String guion = in.readLine();
                                                    /* Musica--- */ 
                                                    System.out.println("Musica:");
                                                    String musica = in.readLine();
                                                    /* Pais:--- */
                                                    System.out.println("Pais:");
                                                    String pais = in.readLine();
                                                    /* Web oficial --- */
                                                    System.out.println("Web oficial:");
                                                    String web_oficial = in.readLine();
                                                    /* Productora -- */
                                                    System.out.println("Productora:");
                                                    String productora = in.readLine();
                                                    /* Sinopsis: ---- */
                                                    System.out.println("Sipnosis:");
                                                    String sipnosis = in.readLine();
                                                    /* Recaudacion */
                                                    System.out.println("Recaudacion en Euros:");
                                                    double recaudacion = Double.parseDouble(in.readLine());
                                                    /*Una vez leída, mensaje a unaDeCine para que incluya una nueva película */
                                                    unaDeCine.nuevaPelicula(Titulo, TituloOriginal, ano, duracion, guion, musica, pais, web_oficial, productora, sipnosis, recaudacion);
                                    break;
                                    case 2:/*Dar de alta un actor */
                                                    System.out.println("Nombre del Actor:");
                                                    String nombreA = in.readLine();
                                                    System.out.println("Nacionalidad del Actor:");
                                                    String nacionalidadA = in.readLine();
                                                    System.out.println("Web oficial del Actor:");
                                                    String webA = in.readLine();
                                                    unaDeCine.incluirActor(nombreA,nacionalidadA,webA);                 
                                    break;
                                    case 3: /*Dar de alta a un Director */                         
                                                    System.out.println("Nombre del Director:");
                                                    String nombreD = in.readLine();
                                                    System.out.println("Nacionalidad del Directorr:");
                                                    String nacionalidadD = in.readLine();
                                                    System.out.println("Web oficial del Director:");
                                                    String webD = in.readLine();
                                                    unaDeCine.incluirDirector(nombreD,nacionalidadD,webD); 
                                     break;
                                     case 4: /* Dar de alta a un usuario VIP  */
                                                    System.out.println("Nombre del Usuario VIP:");
                                                    String nombreU = in.readLine();
                                                    System.out.println("Correo del Usuario VIP:");
                                                    String correo = in.readLine(); 
                                                    unaDeCine.incluirUsuario(nombreU,correo); 
                                       break;             
                                       case 5: /* Dar de alta un Festival  o Premio  */
                                                    System.out.println("Nombre del Festival o Premio:");
                                                    String nombreF = in.readLine();                                                     
                                                    unaDeCine.incluirFestivalPremio(nombreF); 
                                       break;
                                       case 6: /* Incluir  un director en una película */
                                                    /* Obtener a todos los directores disponibles */
                                                    System.out.println("Directores en el sistema:");
                                                    Set<String> nombresD = unaDeCine.obtenerDirectores();
                                                    for(String ND:nombresD){
                                                        System.out.println("\t" + ND);
                                                    }
                                                    /* Lectura del nombre del director  */
                                                    System.out.println("Elegir un nombre de director:");
                                                    nombreD = in.readLine();
                                                    /* Obtener todas las películas disponibles */
                                                    System.out.println("Peliculas en el sistema:");
                                                    Set<String> nombresP = unaDeCine.obtenerPeliculas();
                                                    for(String NP:nombresP){
                                                        System.out.println("\t" + NP);
                                                    }
                                                    /* Lectura  del título de la pelicula. */
                                                    System.out.println("Elegir un titulo de película:");
                                                    String nombreP = in.readLine();
                                                    /* mensaje a unaDeCine para que incluya a ese director en esa película */ 
                                                    unaDeCine.nuevoDirectorPelicula(nombreP,nombreD);
                                       break;
                                       case 7: /* Incluir  un actor en una pelicula */
                                                    /* Obtener a todos los actores disponibles */
                                                    System.out.println("Actores en el sistema:");
                                                    Set<String> nombresA = unaDeCine.obtenerActores();
                                                    for(String NA:nombresA){
                                                        System.out.println("\t" + NA);
                                                    }
                                                    /* Lectura del nombre del actor */
                                                    System.out.println("Elegir un nombre de actor:");
                                                    nombreA = in.readLine();
                                                    /* Obtener todas las películas disponibles  */
                                                    System.out.println("Peliculas en el sistema:");
                                                    nombresP = unaDeCine.obtenerPeliculas();
                                                    for(String NP:nombresP){
                                                        System.out.println("\t" + NP);
                                                    }
                                                    /* Lectura  del título de la pelicula. */
                                                    System.out.println("Elegir un titulo de película:");
                                                    nombreP = in.readLine();
                                                    /* mensaje a unaDeCine para que incluya a ese actor en la pelicula  */
                                                    unaDeCine.nuevoActorPelicula(nombreP,nombreA);
                                       break;
                                       case 8: /* Incluir un genero a pelicula */
                                                    /* Obtener  los generos  disponibles en el sistema */ 
                                                    System.out.println("Generos  en el sistema:");
                                                    Set<String> nombresG = unaDeCine.obtenerGeneros();
                                                    for(String NG:nombresG){
                                                        System.out.println("\t" + NG);
                                                    }
                                                    /* Lectura del nombre del genero */
                                                    System.out.println("Elegir un genero:");
                                                    String nombreG = in.readLine();
                                                    /* Obtener todas las películas disponibles */
                                                    System.out.println("Peliculas en el sistema:");
                                                    nombresP = unaDeCine.obtenerPeliculas();
                                                    for(String NP:nombresP){
                                                        System.out.println("\t" + NP);
                                                    }
                                                    /* Lectura  del título de la pelicula. */
                                                    System.out.println("Elegir un titulo de película:");
                                                    nombreP = in.readLine();
                                                    /* mensaje a unaDeCine para que incluya  ese genero a la pelicula */ 
                                                    unaDeCine.nuevGeneroPelicula(nombreP, nombreG);
                                       break;
                                       case 9: /* Incluir una critica a pelicula */
                                                    /* Obtener los usuarios VIP disponibles en el sistema */
                                                    System.out.println("Usurios en el sistema (correo):");
                                                    Set<String> correos = unaDeCine.obtenerUsuariosVIP();
                                                    for(String cor:correos){
                                                        System.out.println("\t" + cor);
                                                    }
                                                    /* Lectura del correo del usuario */
                                                    System.out.println("Elegir un correo de usuario");
                                                    correo = in.readLine();                       
                                                    /* Obtener todas las películas disponibles  */
                                                    System.out.println("Peliculas en el sistema:");
                                                    nombresP = unaDeCine.obtenerPeliculas();
                                                    for(String NP:nombresP){
                                                        System.out.println("\t" + NP);
                                                    }
                                                    /* Lectura  del título de la pelicula. */
                                                    System.out.println("Elegir un titulo de película:");
                                                    nombreP = in.readLine();
                                                    /* Lectura del titulo de la critica. */
                                                    System.out.println("Título de la crítica:");
                                                    String nombreC = in.readLine();
                                                    /* Lectura del comentario de la critica */
                                                    System.out.println("Escriba la crítica:");
                                                    String critica = in.readLine();
                                                    /* mensaje a unaDeCine para que incluya  esa critica a la pelicula  */
                                                    unaDeCine.criticaPelicula(correo, nombreP, nombreC, critica);
                                         break;
                                         case 10: /* Consultar una pelicula por distintos criterios: */
                                                    /* Lectura del criterio de consulta 
                                                    (1 == por titulo, 1 == por Director, 3 == por Actor, 4== genero, 5 == año de estreno) */
                                                    /* Lectura del valor de la busqueda */
                                                    System.out.println("Indique el criterio de consulta (1 == por titulo, 2 == por Director, 3 == por Actor, 4== genero, 5 == año de estreno):");
                                                    String[] criterioConsulta = new String[2];
                                                    criterioConsulta[0]=in.readLine();
                                                    switch (criterioConsulta[0]){
                                                        case "1":
                                                            System.out.println("Titulo de la película:");
                                                            break;
                                                        case "2":
                                                            System.out.println("Director:");
                                                            break;
                                                        case "3":
                                                            System.out.println("Actor:");
                                                            break;
                                                        case "4":
                                                            System.out.println("Genero:");
                                                            break;
                                                        case "5":
                                                            System.out.println("Año de estreno:");
                                                            break;
                                                    }
                                                    criterioConsulta[1]=in.readLine();
                                                    /* mensaje a unaDeCine para que realice la busqueda */
                                                    List<List<List>> resultado=unaDeCine.busquedaPelicula(criterioConsulta);
                                                    /* muestra del resultado de la busqueda (esta salida tiene que estar bien elaborada) */
                                                    System.out.println("\nRESULTADO DE LA BUSQUEDA\n");
                                                    for(List<List> pelicula: resultado){
                                                        
                                                        ArrayList<String> datosBasicos=(ArrayList)pelicula.get(0).get(0);
                                                        System.out.println("\tTitulo de la pelicula: "+datosBasicos.get(0)+"\n\tAño: "+datosBasicos.get(1)+"\n\tDuración: "+datosBasicos.get(2)+"\n\tValoracion Media: "+datosBasicos.get(3));
                                                        ArrayList<String> directores=(ArrayList)pelicula.get(0).get(1);
                                                        System.out.println("\tDirectores:");
                                                        for(String director:directores){
                                                            System.out.println("\t\t"+director);
                                                        }
                                                        ArrayList<String> actores=(ArrayList)pelicula.get(0).get(2);
                                                        System.out.println("\tActores:");
                                                        for(String actor:actores){
                                                            System.out.println("\t\t"+actor);
                                                        }
//                                                        
                                                        if(criterioConsulta[0].equals("1")){
                                                            ArrayList<Genero> generos=(ArrayList)pelicula.get(1).get(0);
                                                            System.out.println("\tGeneros:");
                                                            for(Genero genero:generos){
                                                                System.out.println("\t\t"+genero.toString());
                                                            }
                                                            ArrayList<String> sinopsis=(ArrayList)pelicula.get(1).get(1);
                                                            System.out.println("\tSinopsis: "+sinopsis.get(0));
                                                            ArrayList<ArrayList<String>> premios=(ArrayList)pelicula.get(1).get(2);
                                                            System.out.println("\tPremios:");
                                                            for(ArrayList<String> premio:premios){
                                                                  System.out.println("\t\tnombre: "+premio.get(0)+"\n\t\t\tcategoria: "+premio.get(1)+"\n\t\t\taño: "+premio.get(2));
                                                            }
                                                            ArrayList<ArrayList<String>> criticas=(ArrayList)pelicula.get(1).get(3);
                                                            System.out.println("\tCritica:");
                                                            for(ArrayList<String> c:criticas){
                                                                System.out.println("\t\ttitulo: "+c.get(0)+"\n\t\t\tcomentario: "+c.get(1)+"\n\t\t\tusuario VIP: "+c.get(2));
                                                            }
                                                            
                                                        }
                                                        System.out.println();
                                                    }
                                              
                                          break;
                                }
            }catch(Exception ex){ // captura de la excepción
                System.err.println(ex);
            } 
        }while(opcion !=0);        
    } // de main(...)
    
}
