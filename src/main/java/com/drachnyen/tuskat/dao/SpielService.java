package com.drachnyen.tuskat.dao;

import com.drachnyen.tuskat.model.Spiel;
import com.drachnyen.tuskat.repository.SpielRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpielService {

    @Autowired
    SpielRepository spielRepository;

    /*to save an employee*/

    public Spiel save(Spiel emp) {
        return spielRepository.save(emp);
    }


    /* search all employees*/

    public List<Spiel> findAll(){
        return spielRepository.findAll();
    }


    /*get an employee by id*/
    public Spiel findOne(Long empid) {
        Optional<Spiel> byId = spielRepository.findById(empid);
        return byId.get();
    }


    /*delete an employee*/

    public void delete(Spiel emp) {
        spielRepository.delete(emp);
    }

}
