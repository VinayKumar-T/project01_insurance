package com.vinay.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vinay.insurance.entity.Plan;
@Repository
public interface PlanRepository extends JpaRepository<Plan, Integer>{
	
	

}