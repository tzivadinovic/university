/***********************************************************************
 * Module:  Student.java
 * Author:  Tomislav Zivadinovic
 * Purpose: Defines the Class Student
 ***********************************************************************/

import java.util.*;

/** @pdOid dfab3078-608f-4ba6-8732-43e363f9d721 */
public class Student {
   /** @pdOid 7177037b-4c32-44ce-a902-1cf580dc7cf9 */
   private String ime;
   /** @pdOid ec45ef9e-f57b-4b4d-a01d-d098f42ec454 */
   private String prezime;
   /** @pdOid c415e717-a97d-4240-96c9-c0357e360880 */
   private int indeks;
   /** @pdOid 6219bc43-d7b3-4a04-9f8f-f1bf7014c677 */
   private String jmbg;
   /** @pdOid 64822d5a-a95c-4bb8-b0d2-24ed2a46e094 */
   private ArrayList predmeti;
   
   /** @pdRoleInfo migr=no name=Predmet assc=association2 coll=java.util.Collection impl=java.util.HashSet mult=1..* type=Aggregation */
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