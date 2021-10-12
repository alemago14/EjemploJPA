/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreriajpa.persistencia;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import libreriajpa.entidades.Editorial;

/**
 *
 * @author Maugouber
 */
public class EditorialDAO extends DAO{
    
    public void crear(Editorial editorial) throws Exception{
        try {
            em.getTransaction().begin();
            em.persist(editorial);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception("Error al crear la editorial");
        }
    }
    
    //metodo para modificar un autor
    public void modificar(Editorial editorial) throws Exception{
        try {
            em.getTransaction().begin();
            em.merge(editorial);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception("Error al modificar al autor");
        }
    }
    
    //metodo para eliminar un autor
    public void eliminar(Editorial editorial) throws Exception{
        try {
            em.getTransaction().begin();
            em.remove(editorial);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception("Error al eliminar al autor");
        }
    }
    
    //buscar por nombre
    public Editorial buscarXNombre(String nombre) throws Exception{
        if (nombre == null || nombre.isEmpty()) {
            throw new Exception("Debe ingresar un nombre a buscar");
        }
        Editorial e1;
        try {
            Query q = em.createQuery("SELECT e FROM Editorial e WHERE e.nombre LIKE '"+nombre+"'", Editorial.class);
            e1 = (Editorial) q.getSingleResult();
            return e1;
        } catch (NoResultException e) {
            e1 = null;
            return e1;
        }
    }
    
    //buscar todas las editoriales
    public List<Editorial> ListarTodo() throws Exception{
        try{
        Query q = em.createQuery("SELECT e FROM Editorial e", Editorial.class);
        List<Editorial> edi = q.getResultList();
        return edi;
        }catch(Exception e){
            throw new Exception("no arreglaste nada");
        }
    }
    
    
}
