package com.drachnyen.tuskat.controller;

import java.util.List;

import javax.validation.Valid;

import com.drachnyen.tuskat.dao.SpielerService;
import com.drachnyen.tuskat.model.Spieler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/tus")
public class SpielerController {
	
	@Autowired
	SpielerService spielerService;
	
	/* to save an employee*/
	@PostMapping("/spieler")
	public Spieler createEmployee(@Valid @RequestBody Spieler emp) {
		return spielerService.save(emp);
	}
	
	/*get all employees*/
	@GetMapping("/spieler")
	public List<Spieler> getAllEmployees(){
		return spielerService.findAll();
	}
	
	/*get employee by empid*/
	@GetMapping("/spieler/{id}")
	public ResponseEntity<Spieler> getEmployeeById(@PathVariable(value="id") Long empid){
		
		Spieler emp= spielerService.findOne(empid);
		
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);
		
	}
	
	
	/*update an employee by empid*/
	@PutMapping("/spieler/{id}")
	public ResponseEntity<Spieler> updateEmployee(@PathVariable(value="id") Long empid, @Valid @RequestBody Spieler empDetails){
		
		Spieler emp= spielerService.findOne(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		
		emp.setName(empDetails.getName());
		emp.setDesignation(empDetails.getDesignation());
		emp.setExpertise(empDetails.getExpertise());
		//emp.setRundenId(empDetails.getRundenId());
		
		Spieler updateEmployee= spielerService.save(emp);
		return ResponseEntity.ok().body(updateEmployee);
		
		
		
	}
	
	/*Delete an employee*/
	@DeleteMapping("/spieler/{id}")
	public ResponseEntity<Spieler> deleteEmployee(@PathVariable(value="id") Long empid){
		
		Spieler emp= spielerService.findOne(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		spielerService.delete(emp);
		
		return ResponseEntity.ok().build();
		
		
	}
	
	

}
