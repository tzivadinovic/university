/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.metropolitan.cs230.jpa.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import rs.ac.metropolitan.cs230.jpa.entity.Predmet;

/**
 *
 * @author korisnik
 */
@Stateless
public class PredmetFacade extends AbstractFacade<Predmet> {

    @PersistenceContext(unitName = "CS230-DZ08-3860-JovanVujovicPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PredmetFacade() {
        super(Predmet.class);
    }
    
}
