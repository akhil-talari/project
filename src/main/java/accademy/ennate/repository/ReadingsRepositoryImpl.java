package accademy.ennate.repository;

import accademy.ennate.entity.Readings;
import accademy.ennate.service.AlertService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class ReadingsRepositoryImpl implements ReadingsRepository {

    @PersistenceContext
    private EntityManager em;


    @Override
    public Readings create(Readings readings) {
        em.merge(readings);
        return readings;
    }
}
