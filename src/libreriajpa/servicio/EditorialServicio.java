/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreriajpa.servicio;

import java.util.List;
import java.util.Scanner;
import libreriajpa.entidades.Editorial;
import libreriajpa.persistencia.EditorialDAO;

/**
 *
 * @author Maugouber
 */
public class EditorialServicio {
    private EditorialDAO editorialD = new EditorialDAO();
    
    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    public void crearEditorial() throws Exception{
        System.out.println("Ingrese el nombre de la editorial");
        String nombre = sc.next();
        
        if (editorialD.buscarXNombre(nombre) != null) {
            throw new Exception("Esa editorial ya existe en la base de datos");
        }
        
        Editorial e1 = new Editorial();
        e1.setNombre(nombre);
        e1.setAlta(true);
        
        editorialD.crear(e1);
        
        System.out.println("Editorial: " + e1.getNombre() +" ha sido creada.");
    }
    
    public void modificarEditorial() throws Exception{
        System.out.println("Ingrese el nombre de la editorial a modificar");
        String nombre = sc.next();
        
        if (editorialD.buscarXNombre(nombre) == null) {
            throw new Exception("No existe esa editorial en la base de datos");
        }
        
        Editorial e1 = editorialD.buscarXNombre(nombre);
        
        System.out.println("Que desea modificar. Ingrese 1 para id. Ingrese 2 para nombre. Ingrese 3 para dar de baja / alta. 0 para salir");
        int op = sc.nextInt();
        
        switch(op){
            case 1:
                System.out.println("Codigo actual: " + e1.getId() + " Codigo nuevo: ");
                e1.setId(sc.nextInt());
                break;
                
            case 2:
                System.out.println("Nombre actual: "+ e1.getNombre()+" Nombre nuevo: ");
                e1.setNombre(sc.next());
                break;
                
            case 3:
                System.out.println("Estado actual: "+e1.isAlta());
                System.out.println("Ingrese 1 para cambiar el estado del autor. O 2 para salir");
                int op1 = sc.nextInt();
        
                if (op1 == 1) {
                    if (e1.isAlta()==true) {
                        e1.setAlta(false);
                        System.out.println("El autor fue dado de baja");
                    } else {
                        e1.setAlta(true);
                        System.out.println("El autor fue dado de alta");
                    }
                } else {
                    System.out.println("Saliendo...");
                }
                
            default: 
                System.out.println("Ingrese una opcion valida");
                break;
        }
        
        editorialD.modificar(e1);
        System.out.println("Editorial "+e1.getNombre()+" modificada");
    }
    
    public void Listar(){
        System.out.println("Todas las editoriales");
        List<Editorial> edi = editorialD.ListarTodo();
        
        for (Editorial editorial : edi) {
            System.out.println(editorial.toString());
        }
    }
    
    
}
