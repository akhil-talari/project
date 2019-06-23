package accademy.ennate.service;

import accademy.ennate.entity.Alerts;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;

@Component
public class AlertService {
    @PersistenceContext
    private EntityManager em;


    @Transactional
    public ArrayList<Object> createalert(){

        Logger logger = Logger.getLogger("testing");
        FileHandler f = null;
        try {
            f = new FileHandler("C:\\Users\\akhil\\project\\src\\main\\java\\accademy\\ennate\\entity\\testing.log");
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.addHandler(f);
        //logger.info("end");

        Query query_high = em.createQuery("SELECT b.vin FROM Vehicle b inner join Readings a ON b.vin = a.vin AND a.engineRpm > b.redlineRpm");

        Query query_medium = em.createQuery("SELECT b.vin FROM Vehicle b inner join Readings a ON b.vin = a.vin AND a.fuelVolume < 0.1 * b.maxFuelVolume");

        Query query_low = em.createQuery("SELECT a.vin FROM Readings a WHERE a.tires.frontLeft < 32 OR a.tires.frontRight < 32 OR a.tires.rearLeft < 32 OR a.tires.rearRight < 32 OR a.tires.frontLeft > 36 OR a.tires.frontRight > 36 OR a.tires.rearLeft > 36 OR a.tires.rearRight > 36 ");

        Query query_low_2 = em.createQuery("SELECT a.vin FROM Readings a WHERE a.checkEngineLightOn = true OR a.engineCoolantLow = true");


        //Query query = em.createQuery("SELECT a.vin FROM Alerts a");
        Alerts a = new Alerts();
        List<Object> list = query_high.getResultList();
        List<Object> list2 = query_medium.getResultList();
        List<Object> list3 = query_low.getResultList();
        List<Object> list4 = query_low_2.getResultList();

        for(Object o: list) {
            a.setVin(o.toString());
            a.setHighAlert("1");
            em.merge(a);
        }

        for(Object o: list2) {
            a.setVin(o.toString());
            a.setMediumAlert("1");
            em.merge(a);
        }

        for(Object o: list3) {
            a.setVin(o.toString());
            a.setLowAlert("1");
            em.merge(a);
        }

        for(Object o: list4) {
            a.setVin(o.toString());
            a.setLowAlert("1");
            em.merge(a);
        }

        ArrayList<Object> listobject =new ArrayList<Object>();
        listobject.add(list);
        listobject.add(list2);
        listobject.add(list3);
        listobject.add(list4);

        return listobject;


//        if(readings.getEngineRpm() > vehicle.getRedlineRpm() ){
//
//        }
    }

}
