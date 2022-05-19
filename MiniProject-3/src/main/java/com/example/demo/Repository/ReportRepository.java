package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Entity.EntityGen;

public interface ReportRepository extends JpaRepository<EntityGen, Integer> {

	@Query("select  distinct(plan_Name) from EntityGen ")
	public List<String> getAllPLANNAME();

	@Query("select  distinct(plan_Status) from EntityGen ")
	public List<String> getAllPLANSTATUS();
	
	 
}
