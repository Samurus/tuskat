package com.drachnyen.tuskat.controller;


import com.drachnyen.tuskat.dao.SpielService;
import com.drachnyen.tuskat.model.Spiel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/spiele")
public class SpielController {

    @Autowired
    SpielService spielService;

    /* to save an employee*/
    @PostMapping("/spiel")
    public Spiel createEmployee(@Valid @RequestBody Spiel emp) {
        return spielService.save(emp);
    }

    /*get all employees*/
    @GetMapping("/spiel")
    public List<Spiel> getAllEmployees(){
        return spielService.findAll();
    }

    /*get employee by empid*/
    @GetMapping("/spiel/{id}")
    public ResponseEntity<Spiel> getEmployeeById(@PathVariable(value="id") Long empid){

        Spiel emp= spielService.findOne(empid);

        if(emp==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(emp);

    }


    /*update an employee by empid*/
    @PutMapping("/spiel/update/{id}")
    public ResponseEntity<Spiel> updateEmployee(@PathVariable(value="id") Long empid, @Valid @RequestBody Spiel empDetails){

        Spiel emp= spielService.findOne(empid);
        if(emp==null) {
            return ResponseEntity.notFound().build();
        }

      emp.setFaktor(empDetails.getFaktor());
        emp.setRunde(empDetails.getRunde());
        emp.setSpielerId(empDetails.getSpielerId());
        emp.setWert(empDetails.getWert());
        Spiel updateEmployee= spielService.save(emp);
        return ResponseEntity.ok().body(updateEmployee);



    }

    /*Delete an employee*/
    @DeleteMapping("/spiel/{id}")
    public ResponseEntity<Spiel> deleteEmployee(@PathVariable(value="id") Long empid){

        Spiel emp= spielService.findOne(empid);
        if(emp==null) {
            return ResponseEntity.notFound().build();
        }
        spielService.delete(emp);

        return ResponseEntity.ok().build();


    }
}
