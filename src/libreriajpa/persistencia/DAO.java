/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreriajpa.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Maugouber
 */
public abstract class DAO {
    protected EntityManager em = Persistence.createEntityManagerFactory("LibreriaJPAPU").createEntityManager();
}
