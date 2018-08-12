package com.drachnyen.tuskat.dao;

import java.util.List;
import java.util.Optional;

import com.drachnyen.tuskat.model.Spieler;
import com.drachnyen.tuskat.repository.SpielerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SpielerService {
	
	@Autowired
	SpielerRepository employeeRepository;
	
	/*to save an employee*/
	
	public Spieler save(Spieler emp) {
		return employeeRepository.save(emp);
	}
	
	
	/* search all employees*/
	
	public List<Spieler> findAll(){
		return employeeRepository.findAll();
	}
	
	
	/*get an employee by id*/
	public Spieler findOne(Long empid) {
		Optional<Spieler> byId = employeeRepository.findById(empid);
		return byId.get();
	}
	
	
	/*delete an employee*/
	
	public void delete(Spieler emp) {
		employeeRepository.delete(emp);
	}
	

}
