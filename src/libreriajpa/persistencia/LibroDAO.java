
package libreriajpa.persistencia;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import libreriajpa.entidades.Libro;

public class LibroDAO extends DAO{
    
    //metodo para crear libro
    public void crearLibro(Libro libro) throws Exception{
        try {
            em.getTransaction().begin();
            em.persist(libro);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception("Error al persitir una persona");
        }
    }
    
    //metodo para modificar un libro
    public void modificar(Libro libro) throws Exception{
        try {
            em.getTransaction().begin();
            em.merge(libro);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception("Error al modificar al autor");
        }
    }
    
    //metodo para eliminar un autor
    public void eliminar(Libro libro) throws Exception{
        try {
            em.getTransaction().begin();
            em.remove(libro);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception("Error al eliminar al autor");
        }
    }
    
    //metodo q busca un libro si existe
    public Libro buscarXNombre(String nombre){
        Libro l1;
        try {
            Query q = em.createQuery("SELECT l FROM Libro l WHERE l.titulo LIKE '"+nombre+"'", Libro.class);
            l1 = (Libro) q.getSingleResult();
            return l1;
        } catch (NoResultException e) {
            l1 = null;
            return l1;
        }
        
    }
    
    //mrtodo buscar por codigo
    public Libro buscarPorCod(Long cod){
        Query q = em.createQuery("SELECT l FROM Libro l WHERE l.isbn LIKE '"+cod+"'", Libro.class);
        Libro l1 = (Libro) q.getSingleResult();
        return l1;
    }
    
    //metodo para buscar todos los libros existentes
    public List<Libro> buscarTodos(){
        List<Libro> libros;
        try {
            Query q = em.createQuery("SELECT l FROM Libro l", Libro.class);
            libros = q.getResultList();
            return libros;
        } catch (NoResultException e) {
            libros = null;
            return libros;
        }
    }
    
    //metodo para buscar todos los libros por nombre de autor
    public List<Libro> buscarLibrosPorAutor(String nombreAutor){
        List<Libro> libros;
        try {
            Query q = em.createQuery("SELECT l FROM Libro l WHERE l.autor.nombre LIKE '%"+nombreAutor+"%'", Libro.class);
            libros = q.getResultList();
            return libros;
        } catch (NoResultException e) {
            return libros = null;
        }
    }
    
    //metodo para buscar todos los libros por nombre de editorial
    public List<Libro> buscarLibrosPorEditorial(String nombreEdi){
        List<Libro> libros;
        try {
            Query q = em.createQuery("SELECT l FROM Libro l WHERE l.editorial.nombre LIKE '%"+nombreEdi+"%'", Libro.class);
            libros = q.getResultList();
            return libros;
        } catch (NoResultException e) {
            return libros = null;
        }
    }
}
