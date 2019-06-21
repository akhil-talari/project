package accademy.ennate.service;

import accademy.ennate.entity.Vehicle;

import java.util.List;

public interface VehicleService {
    List<Vehicle> findAll();
    Vehicle findOne(String id);
    Vehicle create(Vehicle emp);
    List<Vehicle> update(List<Vehicle> vch);
    void delete(String id);

}
