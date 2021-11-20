/***********************************************************************
 * Module:  IzvestajOPredmetu.java
 * Author:  Tomislav Zivadinovic
 * Purpose: Defines the Class IzvestajOPredmetu
 ***********************************************************************/

import java.util.*;

/** @pdOid c4b83ac0-5a28-4069-8429-40bb38ede9ed */
public class IzvestajOPredmetu extends IzvestajBuilder {
   /** @pdOid e778d50e-14ec-4e3f-957d-c7832550dce1 */
   private Student student;
   /** @pdOid 29c1abee-2164-47a8-aabb-c22e6262af0f */
   private Date datum;
   
   /** @pdRoleInfo migr=no name=Predmet assc=association1 mult=0..* type=Aggregation side=A */
   public Predmet[] predmet;

}