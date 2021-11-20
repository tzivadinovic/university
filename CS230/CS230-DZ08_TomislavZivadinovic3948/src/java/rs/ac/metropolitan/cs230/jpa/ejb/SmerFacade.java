/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.metropolitan.cs230.jpa.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import rs.ac.metropolitan.cs230.jpa.entity.Smer;

/**
 *
 * @author korisnik
 */
@Stateless
public class SmerFacade extends AbstractFacade<Smer> {

    @PersistenceContext(unitName = "CS230-DZ08-3860-JovanVujovicPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SmerFacade() {
        super(Smer.class);
    }
    
}
