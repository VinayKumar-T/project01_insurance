package com.vinay.insurance.service;

import java.util.List;
import java.util.Map;

import com.vinay.insurance.dto.PlanDto;

public interface InsuranceService {
	
	public Map<Integer, String> getAllCategories();
	
	public Boolean addPlan(PlanDto planDto);
	
	public List<PlanDto> getPlans(); 
 	
	public PlanDto getPlan(Integer planId);
	
	public Boolean deletePlan(Integer planId);//hard delete
	
	public Boolean controlPlanStatus(Integer planId,String status);
	
	public Boolean updatePlan(PlanDto planDto);
	
	

}
