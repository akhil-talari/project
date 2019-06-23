package accademy.ennate.service;

import accademy.ennate.entity.Vehicle;
import accademy.ennate.exception.VehicleNotFoundException;
import accademy.ennate.exception.ResourceNotFoundException;
import accademy.ennate.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;
    @Override
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle findOne(String id) {
        Vehicle vehicle = vehicleRepository.findOne(id);
        if(vehicle == null){
            throw new VehicleNotFoundException("Vehicle with id ="+ id +" NOT FOUND IN DATABASE");
        }else
            return vehicle;
    }

    @Transactional
    @Override
    public Vehicle create(Vehicle emp) {
//        Vehicle existing = vehicleRepository.findByEmail(emp.getEmail());
//        if(existing != null){
//            throw new ResourceNotFoundException("Vehicle with eamil ="+ emp.getEmail() +" already exists");
//        }
//        return vehicleRepository.create(emp);
        return null;
    }

    @Transactional
    @Override
    public List<Vehicle> update(List<Vehicle> vch) {
            return vehicleRepository.update(vch);
    }

    @Transactional
    @Override
    public void delete(String id) {
        Vehicle vehicle = vehicleRepository.findOne(id);
        if(vehicle == null){
            throw new VehicleNotFoundException("Vehicle with id ="+ id +" doesn't exist");
        }else
            vehicleRepository.delete(vehicle);

    }
}
