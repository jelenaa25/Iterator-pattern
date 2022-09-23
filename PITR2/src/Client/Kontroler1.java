/* Kontroler1.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 06.11.2017
 */

package Client;


import AbstractProductA.*;
import AbstractProductB.*;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;
import DomainClasses.DKPorudzbina;  // Promenljivo
import DomainClasses.GeneralDObject;
import ConcreteCommand.SOKreiraj;
import ConcreteCommand.SONadji;
import ConcreteCommand.SOObrisi;
import ConcreteCommand.SOPromeni;
import Invoker.Dugme;
import Invoker.TekstPolje;
import Iterator.DugmeKretanja;

import Receiver.KreirajDomenskiObjekat;
import Receiver.NadjiDomenskiObjekat;
import Receiver.ObrisiDomenskiObjekat;
import Receiver.PromeniDomenskiObjekat;


public final class Kontroler1 extends Kontroler{ // Client
   
    
   
    
    public Kontroler1(EkranskaForma ef1,BrokerBazePodataka bbp1){ef=ef1;bbp=bbp1; Povezi();}
    
    void Povezi()
    {
      
      KreirajDomenskiObjekat kdo = new KreirajDomenskiObjekat(bbp,this);
      SOKreiraj sok = new SOKreiraj(kdo); // povezivanje ConcreteCommand and Receiver
      Dugme dk1 = new Dugme(sok,ef.getPanel().getKreiraj());
      
      PromeniDomenskiObjekat pdo = new PromeniDomenskiObjekat(bbp,this);
      SOPromeni sop = new SOPromeni(pdo); // povezivanje ConcreteCommand and Receiver
      Dugme dk2 = new Dugme(sop,ef.getPanel().getPromeni());
      
      ObrisiDomenskiObjekat odo = new ObrisiDomenskiObjekat(bbp,this);
      SOObrisi soo = new SOObrisi(odo); // povezivanje ConcreteCommand and Receiver
      Dugme dk3 = new Dugme(soo,ef.getPanel().getObrisi());
      
      
      NadjiDomenskiObjekat ndo = new NadjiDomenskiObjekat(bbp,this);
      SONadji son = new SONadji(ndo); // povezivanje ConcreteCommand and Receiver
      Dugme dk4 = new Dugme(son,ef.getPanel().getNadji());
      
      
      TekstPolje tp = new TekstPolje(son,ef.getPanel().getSifraPorudzbine1());
      
      it = bbp.getIterator(new DKPorudzbina());
      DugmeKretanja dprv = new DugmeKretanja(it,ef.getPanel().getPrvi(),this);
      DugmeKretanja dsl = new DugmeKretanja(it,ef.getPanel().getSledeci(),this);
      DugmeKretanja dpre = new DugmeKretanja(it,ef.getPanel().getPredhodni(),this);
      DugmeKretanja dza = new DugmeKretanja(it,ef.getPanel().getZadnji(),this);
      
     
    }
    
// Promenljivo!!!  
    @Override
    public void napuniDomenskiObjekatIzGrafickogObjekta()   {
       ip= new DKPorudzbina();
       ip.setSifraPorudzbine(getInteger(ef.getPanel().getSifraPorudzbine()));
       ip.setPalacinka(ef.getPanel().getPalacinka());
       ip.setPreliv(ef.getPanel().getPreliv());
       ip.setVoce(ef.getPanel().getVoce());
    
    }

// Promenljivo!!!
    @Override
    public void napuniGrafickiObjekatIzDomenskogObjekta(GeneralDObject gdo){
        DKPorudzbina ip = (DKPorudzbina)gdo;
       ef.getPanel().setSifraPorudzbine(Integer.toString(ip.getSifraPorudzbine()));
       ef.getPanel().setPalacinka(ip.getPalacinka());
       ef.getPanel().setPreliv(ip.getPreliv());
       ef.getPanel().setVoce(ip.getVoce());
      
    }

   
// Promenljivo!!!
    @Override
    public void isprazniGrafickiObjekat(){

 ef.getPanel().setSifraPorudzbine("");
 ef.getPanel().setPalacinka("nista");
 ef.getPanel().setPreliv("nista");
 ef.getPanel().setVoce("nista");
 
}

    @Override 
    public void prikaziPoruku(){ 
  ef.getPanel().setPoruka(poruka);
      
  Timer timer = new Timer();
  
  timer.schedule(new TimerTask() {
  @Override
  public void run() {
    ef.getPanel().setPoruka(""); 
  }
}, 3000);
  
}

 public int getInteger(String s) {
    int broj = 0;
    try
        {
            if(s != null)
                broj = Integer.parseInt(s);
        }
            catch (NumberFormatException e)
            { broj = 0;}
   
    return broj;
}


}    







