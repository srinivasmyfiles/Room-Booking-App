package com.team.application;

import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class RestfulController {

	@Autowired
	private UnitService unitService;
	
	@GetMapping("/units")
	public List<Unit> getUnits(){
		return unitService.getAllUnits();
	}
	
	@GetMapping("/units/{id}")
	public Unit getUnit(@PathVariable int id){
		return unitService.getUnit(id);
	}
	
	@DeleteMapping("/units/{id}")
	public boolean deleteUnit(@PathVariable int id){
		unitService.deleteUnit(id);
		return true;
	}
	
	@PostMapping("/units")
	public Unit saveUnit( Unit unit){
		return unitService.addUnit(unit);
	}
	
	@PutMapping("/units")
	public Unit updateUnit( Unit unit){
		return unitService.updateUnit(unit);
	}
}