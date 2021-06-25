/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.metropolitan.cs230.jpa.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import rs.ac.metropolitan.cs230.jpa.entity.Overa;

/**
 *
 * @author korisnik
 */
@Stateless
public class OveraFacade extends AbstractFacade<Overa> {

    @PersistenceContext(unitName = "CS230-DZ08-3860-JovanVujovicPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OveraFacade() {
        super(Overa.class);
    }
    
}
