package accademy.ennate.service;

import accademy.ennate.controller.ReadingsController;
import accademy.ennate.entity.Readings;
import accademy.ennate.repository.ReadingsRepository;
import accademy.ennate.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ReadingsServiceImpl implements ReadingsService{

    @Autowired
    ReadingsRepository readingsRepository;

    @Transactional
    @Override
    public Readings create(Readings readings) {

        return readingsRepository.create(readings);
    }
}
