/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreriajpa.servicio;

import java.util.List;
import java.util.Scanner;
import libreriajpa.entidades.Autor;
import libreriajpa.entidades.Editorial;
import libreriajpa.entidades.Libro;
import libreriajpa.persistencia.AutorDAO;
import libreriajpa.persistencia.EditorialDAO;
import libreriajpa.persistencia.LibroDAO;

public class LibroServicio {
    private LibroDAO libroD = new LibroDAO();
    private AutorDAO autorD = new AutorDAO();
    private EditorialDAO ediD = new EditorialDAO();
    
    private AutorServicio autorServ = new AutorServicio();
    private EditorialServicio ediServ = new EditorialServicio();
    
    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    
    public void crearLibro() throws Exception{
        System.out.println("Crear Libro: ");
        System.out.println("Ingrese el cod ISBN:");
        Long isbn = sc.nextLong();
        
        System.out.println("Ingrese el nombre del libro");
        String nombre = sc.next();
        
        System.out.println("Ingrese el año de publicacion");
        int anio = sc.nextInt();
        
        System.out.println("Cant de ejemplares: ");
        int ejemplares = sc.nextInt();
        
       /* if (libroD.buscarPorCod(isbn) != null) {
            throw new Exception("El codigo ISBN ya existe");
        }*/
        
       /* if (libroD.buscarXNombre(nombre) != null) {
            throw new Exception("Este libro ya existe en la bd");
        }*/
        
        Libro l1 = new Libro();
        
        System.out.println("Ingrese el nombre del autor");
        String nombreAutor = sc.next();
        
        if (autorD.buscarXnombre(nombreAutor) == null) {
            System.out.println("El autor no existe se creara uno");
            autorServ.crearAutor();
        }
        
        Autor a1 = autorD.buscarXnombre(nombreAutor);
        
        System.out.println("Ingrese el nombre de la editorial");
        String nombreEdi = sc.next();
        
        if (ediD.buscarXNombre(nombreEdi) == null) {
            System.out.println("La editorial no existe, se creara a continuacion");
            ediServ.crearEditorial();
        }
        
        Editorial e1 = ediD.buscarXNombre(nombreEdi);
        
        l1.setAutor(a1);
        l1.setEditorial(e1);
        l1.setIsbn(isbn);
        l1.setTitulo(nombre);
        l1.setAnio(anio);
        l1.setEjemplares(ejemplares);
        l1.setEjemplaresRestantes(ejemplares);
        l1.setEjeplaresPrestados(0);
        
        libroD.crearLibro(l1);
    }
    
    public void buscarTodos(){
        List<Libro> libros = libroD.buscarTodos();
        for (Libro libro : libros) {
            System.out.println(libro.toString());
        }
    }
    
    public void buscarNombre(){
        System.out.println("Ingrese el nombre del libro a buscar");
        String nombre = sc.next();
        Libro libros = libroD.buscarXNombre(nombre);
        
        if (libros != null) {
            System.out.println(libros.toString());
        } else {
            System.out.println("El libro no existe en la base de datos.");
        }
    }
    
    public void buscarPorAutor(){
        System.out.println("Ingrese el nombre del autor.");
        String nombre = sc.next();
        List<Libro> libros = libroD.buscarLibrosPorAutor(nombre);
        
        if (libros != null) {
            System.out.println("Lista de libros de "+ nombre +":");
            for (Libro libro : libros) {
                System.out.println(libro.toString());
            }
        } else {
            System.out.println("El autor no se encuantra en la bd o no tiene libros aun");
        }
    }
    
    public void buscarPorEditorial(){
        System.out.println("Ingrese el nombre de la editorial.");
        String nombre = sc.next();
        List<Libro> libros = libroD.buscarLibrosPorEditorial(nombre);
        
        if (libros != null) {
            System.out.println("Lista de libros de "+ nombre +":");
            for (Libro libro : libros) {
                System.out.println(libro.toString());
            }
        } else {
            System.out.println("La editorial no se encuentra o no tiene libros publicados");
        }
    }
}
