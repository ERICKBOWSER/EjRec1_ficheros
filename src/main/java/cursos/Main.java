/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cursos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;

/**
 *
 * @author guerig
 */
public class Main {
    public static void main(String[] args) {
        List<Ejrec1_GuerigEri> lista = new ArrayList();
                
        lista = Ficheros.leer("RegActForCep.csv");
        
        System.out.println("Lectura desde el main: ");
        for (Ejrec1_GuerigEri l : lista) {
            System.out.println(l);
        }
        
 
        //Lista ordenada por fecha y titulo        
        List<Ejrec1_GuerigEri> listaOrdenada = lista.stream()
                .sorted(Comparator.comparing(Ejrec1_GuerigEri :: getFechaInicio)
                        .thenComparing(Ejrec1_GuerigEri :: getTitulo))
                .toList();
                
        System.out.println("Lista ordenada: \t");
        listaOrdenada.forEach(System.out :: println);
        
        
        // Método para crear los cursos acabados
        Ficheros.escribir("CursosAcabados.txt");
        
        // Método para leer el fichero de cursos acabados
        List<String> listaCursos = new ArrayList();
        listaCursos = Ficheros.leerCursosAcabados("CursosAcabados.txt");
        
        System.out.println("Lista de cursos acabados: \t");
        listaCursos.forEach(System.out :: println);
        
        
        System.out.println("Contador de cursos: ");
        Ficheros.numeroCursosCentro(listaCursos);
        
    }
}
