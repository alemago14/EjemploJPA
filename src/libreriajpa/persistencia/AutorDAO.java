/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreriajpa.persistencia;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import libreriajpa.entidades.Autor;

/**
 *
 * @author Maugouber
 */
public class AutorDAO extends DAO{
    
    //metodo para crear autor
    public void crearAutor(Autor autor) throws Exception{
        try {
            em.getTransaction().begin();
            em.persist(autor);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception("Error al persitir una persona");
        }
    }
    
    //metodo para modificar un autor
    public void modificar(Autor autor) throws Exception{
        try {
            em.getTransaction().begin();
            em.merge(autor);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception("Error al modificar al autor");
        }
    }
    
    //metodo para eliminar un autor
    public void eliminar(Autor autor) throws Exception{
        try {
            em.getTransaction().begin();
            em.remove(autor);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception("Error al eliminar al autor");
        }
    }
    
    //metodo para buscar por id
    public Autor buscarXId(Integer id){
        return em.find(Autor.class, id);
    }
    
    //buscar por nombre
    public Autor buscarXnombre (String nombre){
        Autor a1;
        try {
            Query q = em.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE '"+nombre+"'", Autor.class);
            a1 = (Autor) q.getSingleResult();
            return a1;
        } catch (NoResultException e) {
            a1 = null;
            return a1;
        }
        
    }
    
    public List<Autor> listar (){
        Query q = em.createQuery("SELECT a FROM Autor a");
        List<Autor> au = (List<Autor>) q.getResultList();
        return au; 
    }
}
