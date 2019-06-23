package accademy.ennate.repository;

import accademy.ennate.entity.Readings;
import accademy.ennate.entity.Vehicle;

import java.util.List;

public interface VehicleRepository {
    List<Vehicle>  findAll();
    Vehicle findOne(String id);
    Vehicle findByEmail(String email);
    Vehicle create(Vehicle emp);
    List<Vehicle> update(List<Vehicle> vch);
    void delete(Vehicle emp);
}
