/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreriajpa.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import libreriajpa.entidades.Autor;
import libreriajpa.persistencia.AutorDAO;

public class AutorServicio {
    AutorDAO autorD = new AutorDAO();
    
    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    public Autor crearAutor() throws Exception{
    
        System.out.println("Ingrese el nombre del autor");
        String nombre = sc.next();
        
        Autor a1 = new Autor();
        
        if (autorD.buscarXnombre(nombre) != null) {
            throw new Exception ("El autor ingresado ya existe en la base de datos");
        }
        
        a1.setNombre(nombre);
        a1.setAlta(true);
        
        autorD.crearAutor(a1);
        return a1;
    }
    
    public void ListadeAutores(){
        List<Autor> au = autorD.listar();
        for (Autor autor : au) {
            System.out.println(autor.toString());
        }
    }
    
    public void darAltaBaja(String nombre) throws Exception{
        if (autorD.buscarXnombre(nombre) == null) {
            throw new Exception ("El autor no se encuentra en la base de datos");
        }
        
        Autor a1 = autorD.buscarXnombre(nombre);
        
        System.out.println("Estado actual del autor:");
        if (a1.isAlta() == true) {
            System.out.println("Esta dado de alta");
        } else {
            System.out.println("Esta dado de baja");
        }
        
        System.out.println("Ingrese 1 para cambiar el estado del autor. O 2 para salir");
        int op = sc.nextInt();
        
        if (op == 1) {
            if (a1.isAlta()==true) {
                a1.setAlta(false);
                System.out.println("El autor fue dado de baja");
            } else {
                a1.setAlta(true);
                System.out.println("El autor fue dado de alta");
            }
        } else {
            System.out.println("Saliendo...");
        }
        
        autorD.modificar(a1);
        System.out.println(a1.getNombre() + " Modificado");
    }
}
