/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.metropolitan.cs230.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import rs.ac.metropolitan.cs230.jpa.entity.Angazovanje;

/**
 *
 * @author korisnik
 */
@Stateless
public class AngazovanjeFacade extends AbstractFacade<Angazovanje> {

    @PersistenceContext(unitName = "CS230-DZ07-3860-JovanVujovicPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AngazovanjeFacade() {
        super(Angazovanje.class);
    }
    
}
