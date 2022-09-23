/* BrokerBazePodataka.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 06.11.2017
 */

package AbstractProductB;

import java.util.concurrent.atomic.AtomicInteger;
import DomainClasses.GeneralDObject;
import Iterator.Iterator;


public abstract class BrokerBazePodataka // Aggregate
{   public abstract boolean makeConnection();
    public abstract boolean insertRecord(GeneralDObject odo);
    public abstract boolean updateRecord(GeneralDObject odo,GeneralDObject odoold);
    public abstract boolean updateRecord(GeneralDObject odo); 
    public abstract boolean deleteRecord(GeneralDObject odo);
    public abstract GeneralDObject findRecord(GeneralDObject odo);
    public abstract boolean commitTransation();
    public abstract boolean rollbackTransation();
    public abstract boolean getCounter(GeneralDObject odo,AtomicInteger counter); 
    public abstract boolean increaseCounter(GeneralDObject odo,AtomicInteger counter); 
    public abstract void closeConnection();
    public abstract int getRecordsNumber(GeneralDObject odo);
    public abstract GeneralDObject getRecord(GeneralDObject odo,int index);
    public abstract Iterator getIterator(GeneralDObject odo);
}
