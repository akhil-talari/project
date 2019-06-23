package accademy.ennate.controller;

import accademy.ennate.entity.Alerts;
import accademy.ennate.entity.Readings;
import accademy.ennate.entity.Vehicle;
import accademy.ennate.service.AlertService;
import accademy.ennate.service.ReadingsService;
import accademy.ennate.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "reading")
public class ReadingsController {

    @Autowired
    private ReadingsService service;

    @Autowired
    private AlertService alertService;

    @CrossOrigin(origins = "http://mocker.ennate.academy")
    @RequestMapping(method = RequestMethod.POST)
    public Readings update(@RequestBody Readings readings){

         Readings readings1 = service.create(readings);

        // alertService.createalert();
        return readings1;

    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Object> get(){
        return alertService.createalert();
    }



}
