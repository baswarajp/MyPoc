package com.example.demoDISetter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoDISetter.model.Vehicle;
import com.example.demoDISetter.repository.VehicleRepo;

@RestController
public class VehicleController 
{
	@Autowired
	private VehicleRepo repo;

	@PostMapping("/insert")
	public Vehicle add(@RequestBody Vehicle emp) 
	{
	//	Employee emp=new Employee(id, name, salary);
		System.out.println(emp);
		return (repo.save(emp));
	}
	
	@GetMapping("/getAll")
	public List<Vehicle> getAll()
	{
		return repo.findAll();
	}

	@GetMapping("/getByName/{firstName}")
	public Vehicle getByName(@PathVariable String firstName) 
	{
		return repo.findByFirstName(firstName);
	}
	
	@PutMapping("/update/{id}")
	public Vehicle update(@PathVariable int id) 
	{
		Vehicle v= repo.findById(id);
		v.setMobile(123456);
		return v;
		
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id)
	{
		System.out.println("deleted"+id);
		repo.deleteById(id);
		return "deleted";
		
	}
}
