/***********************************************************************
 * Module:  PredispitnaObaveza.java
 * Author:  Tomislav Zivadinovic
 * Purpose: Defines the Class PredispitnaObaveza
 ***********************************************************************/

import java.util.*;

/** @pdOid 5ece74aa-515d-4e92-8022-47e809e8b9f4 */
public abstract class PredispitnaObaveza {
   /** @pdOid 65cbddb8-ae87-4fe8-84ab-eb71f3f659bc */
   private String tip;
   /** @pdOid d8e9b13f-601a-4fae-b370-8161fa0dc7f2 */
   private Double brojPoena;
   /** @pdOid 0f1b6e2c-3b47-4e7e-b0a3-d7819ecef43a */
   private Student student;
   
   /** @pdRoleInfo migr=no name=Predmet assc=association3 coll=java.util.Collection impl=java.util.HashSet mult=1..* type=Aggregation */
   public java.util.Collection<Predmet> predmet;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Predmet> getPredmet() {
      if (predmet == null)
         predmet = new java.util.HashSet<Predmet>();
      return predmet;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorPredmet() {
      if (predmet == null)
         predmet = new java.util.HashSet<Predmet>();
      return predmet.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newPredmet */
   public void setPredmet(java.util.Collection<Predmet> newPredmet) {
      removeAllPredmet();
      for (java.util.Iterator iter = newPredmet.iterator(); iter.hasNext();)
         addPredmet((Predmet)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newPredmet */
   public void addPredmet(Predmet newPredmet) {
      if (newPredmet == null)
         return;
      if (this.predmet == null)
         this.predmet = new java.util.HashSet<Predmet>();
      if (!this.predmet.contains(newPredmet))
         this.predmet.add(newPredmet);
   }
   
   /** @pdGenerated default remove
     * @param oldPredmet */
   public void removePredmet(Predmet oldPredmet) {
      if (oldPredmet == null)
         return;
      if (this.predmet != null)
         if (this.predmet.contains(oldPredmet))
            this.predmet.remove(oldPredmet);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllPredmet() {
      if (predmet != null)
         predmet.clear();
   }

}