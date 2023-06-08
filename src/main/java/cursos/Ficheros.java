/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cursos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author guerig
 */
public class Ficheros {
    
    public static List<Ejrec1_GuerigEri> leer(String nombre){
        // Fichero a leer con datos de ejemplo
        String idFichero = nombre;

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;
        
        List<Ejrec1_GuerigEri> lista = new ArrayList(); // Array para guardar los datos del fichero

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Formato para la fecha

        
        System.out.println("Leyendo el fichero: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try (Scanner datosFichero = new Scanner(new File(idFichero), "UTF8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            
            // Contador para saltarme la primera linea
            int contador = 0;
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(";");
                
                // Creamos una nueva instancia con cada repetición para añadir uno nuevo
                Ejrec1_GuerigEri dato = new Ejrec1_GuerigEri();
                
                // Condicional para saltar la primera linea
                if(contador > 5){
                    // Insertamos los datos en la instancia de Deportivo
                    dato.setCentro(tokens[0]);
                    dato.setCodigo(tokens[1]);
                    dato.setTitulo(tokens[2]);
                    dato.setModalidad(tokens[3]);
                    dato.setEstado(tokens[4]);
                    
                    LocalDate fecha1 = LocalDate.parse(tokens[5], formato);
                    LocalDate fecha2 = LocalDate.parse(tokens[6], formato);

                    
                    dato.setFechaInicio(fecha1);
                    dato.setFechaFin(fecha2);
                    dato.setDirigido(tokens[7]);                    

                    lista.add(dato);
                
                }else{
                    contador++;
                }
                
                
//                for (String token : tokens) {
//                    System.out.println(token);
//                }
            }

            
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
    
    
    public static void escribir(String nombre){
        
        String tmp = "";
        String ruta = nombre;
        
        // Lista para meter los datos del fichero
        List<Ejrec1_GuerigEri> lista = new ArrayList(); 
        
        // Metemos los datos en la lista
        lista = Ficheros.leer("RegActForCep.csv");
        
        try(BufferedWriter flujo = new BufferedWriter(new FileWriter(ruta))){
              
            // Bucle para obtener cada dato de la lista
            for (Ejrec1_GuerigEri l : lista) {
                
                // Obtenemos la fecha y comprobamos si es menor que la fecha comparada
                if(l.getFechaFin().isBefore(LocalDate.of(2020, Month.MARCH, 1))){
                    
                    // Guardamos en un string los datos que se piden
                    String resultado = l.getTitulo() + ";" + l.getFechaFin();
                    
                    flujo.write(resultado); // Escritura
                    
                    flujo.newLine(); // Nueva linea 
                    
                  //  System.out.println(resultado);
                }
                
                
            }
                // Guardar cambios en el disco
                flujo.flush();
                
            } catch(IOException e){
                System.out.println(e.getMessage());
            }   

    }
    
    public static List<String> leerCursosAcabados(String nombre){
        // Fichero a leer con datos de ejemplo
        String idFichero = nombre;

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;
        
        List<String> lista = new ArrayList(); // Array para guardar los datos del fichero

        
        System.out.println("Leyendo el fichero: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try (Scanner datosFichero = new Scanner(new File(idFichero), "UTF8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                                
                lista.add(linea);
//                for (String token : tokens) {
//                    System.out.println(token);
//                }
            }

            
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }


    public static void numeroCursosCentro(List<String> cursos){

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;
        
        /*
        Crea un método para que, pasando la lista anterior, devuelva una estructura Map 
        para saber el número de cursos por Centro de Profesorado (CEP) diferente. Guarda 
        la información anterior en un fichero JSON.
        */
        
        Map<String, Integer> mapCursos = new HashMap();
        
        // Creamos una lista y almacenamos los datos que se le pasa 
        for(String curso : cursos){
            
            tokens = curso.split(";");
            
            System.out.println(tokens[0]);
            
//            if(mapCursos.containsKey(tokens[0])){
//                mapCursos.put((tokens[0]), mapCursos.get(tokens[0]) + 1);
//                
//                for (Map.Entry<String, Integer> entry : mapCursos.entrySet()) {
//                    Object key = entry.getKey();
//                    Object val = entry.getValue();
//                    System.out.println(key + "-" + val);                    
//                }
//            }else{
//                mapCursos.put(curso, 1);
//                
//                for (Map.Entry<String, Integer> entry : mapCursos.entrySet()) {
//                    Object key = entry.getKey();
//                    Object val = entry.getValue();
//                    System.out.println(key + "-" + val);                    
//                }
//            }
            
        }
        
                
                
//        return mapCursos;
    }

    
    
}
