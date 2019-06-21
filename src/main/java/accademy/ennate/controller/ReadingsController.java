package accademy.ennate.controller;

import accademy.ennate.entity.Readings;
import accademy.ennate.entity.Vehicle;
import accademy.ennate.service.ReadingsService;
import accademy.ennate.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "vehicle")
public class ReadingsController {

    @Autowired
    private ReadingsService service;

    @CrossOrigin(origins = "http://mocker.ennate.academy")
    @RequestMapping(method = RequestMethod.POST)
    public Readings update(@RequestBody Readings readings){
        return service.create(readings);
    }

}
