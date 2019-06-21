package accademy.ennate.repository;

import accademy.ennate.entity.Vehicle;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Iterator;
import java.util.List;

@Component
public class VehicleRepositoryImpl implements VehicleRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void findAll() {
        //Query query = em.createQuery("SELECT emp FROM Employee emp ORDER BY emp.email DESC ");
       // return query.getResultList();
    }

    @Override
    public Vehicle findOne(String id) {
        return em.find(Vehicle.class, id);
    }

    @Override
    public Vehicle findByEmail(String email) {
//        TypedQuery<Vehicle> query = em.createNamedQuery("findByEmail", Vehicle.class);
//        query.setParameter("paramEmail", "email");
//        List<Vehicle> resultList =  query.getResultList();
//        if(resultList != null && resultList.size() == 1){
//            return resultList.get(0);
//        }else {
//            return null;
//        }
        return null;
    }

    @Override
    public Vehicle create(Vehicle emp) {
        em.persist(emp);
        return emp;
    }

    @Override
    public List<Vehicle> update(List<Vehicle> vch) {

        for(Iterator<Vehicle> it = vch.iterator(); it.hasNext();) {
            Vehicle v = it.next();
            em.merge(v);
        }
         return vch;

    }

    @Override
    public void delete(Vehicle emp) {
        em.remove(emp);
    }

}
