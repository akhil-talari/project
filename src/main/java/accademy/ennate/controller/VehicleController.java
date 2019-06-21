package accademy.ennate.controller;

import accademy.ennate.entity.Vehicle;
import accademy.ennate.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "vehicle")
public class VehicleController {

    @Autowired
    private VehicleService service;

    @RequestMapping(method = RequestMethod.GET)
    public List<Vehicle> findAll(){
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public Vehicle findOne(@PathVariable("id") String empId){
        return service.findOne(empId);
    }

//    @RequestMapping(method = RequestMethod.POST)
//    public Vehicle create(@RequestBody Vehicle vehicle){
//        return service.create(vehicle);
//    }

    @CrossOrigin(origins = "http://mocker.ennate.academy")
    @RequestMapping(method = RequestMethod.PUT)
    public List<Vehicle> update(@RequestBody List<Vehicle> vehicles){
        return service.update(vehicles);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public void delete(@PathVariable("id") String empId){
        service.delete(empId);
    }

}
