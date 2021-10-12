/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreriajpa;

import java.util.Scanner;
import libreriajpa.servicio.AutorServicio;
import libreriajpa.servicio.EditorialServicio;
import libreriajpa.servicio.LibroServicio;

/**
 *
 * @author Maugouber
 */
public class LibreriaJPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        
        AutorServicio autorS = new AutorServicio();
        EditorialServicio editorialS = new EditorialServicio();
        LibroServicio libroS = new LibroServicio();
        
        System.out.println("Bienvenido a libreria");
        
        System.out.println("Seleccione una opcion del menu para realizar:");
        System.out.println("");
        int opcion = 0;
        do {            
            System.out.println("1. para ver todos los libros disponibles.");
            System.out.println("2. para ver todos los autores");
            System.out.println("3. para ver todas las editoriales.");
            System.out.println("4. para agregar un nuevo elemento.");
            System.out.println("5. para buscar.");
            System.out.println("9. para salir");
            opcion = sc.nextInt();
            
            switch(opcion){
                case 1: 
                    libroS.buscarTodos();
                    break;
                    
                case 2:
                    autorS.ListadeAutores();
                    break;
                    
                case 3:
                    editorialS.Listar();
                    break;
                    
                case 4:
                    System.out.println("Ingrese una opcion para agregar: ");
                    System.out.println("1. Para nuevo libro.");
                    System.out.println("2. Para nuevo autor.");
                    System.out.println("3. Para nueva editorial.");
                    opcion = sc.nextInt();
                    switch(opcion){
                        case 1: 
                            System.out.println("Nuevo libro.");
                            libroS.crearLibro();
                            break;
                            
                        case 2:
                            System.out.println("Nuevo autor.");
                            autorS.crearAutor();
                            break;
                        case 3:
                            System.out.println("Nueva Editorial.");
                            editorialS.crearEditorial();
                            break;
                            
                        default:
                            System.out.println("Ingrese una opcion valida.");
                            break;
                    }
                    break;
                    
                case 5:
                    System.out.println("Buscar");
                    System.out.println("1. Buscar libro por nombre.");
                    System.out.println("2. buscar libro por autor");
                    System.out.println("3. buscar por editorial");
                    opcion = sc.nextInt();
                    switch(opcion){
                        case 1: 
                            System.out.println("Buscar por nombre");
                            libroS.buscarNombre();
                            break;
                            
                        case 2:
                            System.out.println("Buscar por autor");
                            libroS.buscarPorAutor();
                            break;
                            
                        case 3:
                            System.out.println("Buscar por editorial");
                            libroS.buscarPorEditorial();
                            break;
                            
                        default:
                            System.out.println("Ingrese una opcion valida.");
                            break;
                    }
                    break;
                    
                case 9:
                    System.out.println("Saliendo....");
                    break;
                    
                default: 
                    System.out.println("Ingrese una opcion valida");
                    break;
            }
        } while (opcion != 9);
    }
    
}
