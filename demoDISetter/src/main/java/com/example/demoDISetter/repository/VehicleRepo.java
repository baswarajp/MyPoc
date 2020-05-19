package com.example.demoDISetter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demoDISetter.model.Vehicle;

@Repository
public interface VehicleRepo extends JpaRepository<Vehicle, Integer>
{
	Vehicle findById(int id);
	Vehicle findByFirstName(String firstName);
	
}
