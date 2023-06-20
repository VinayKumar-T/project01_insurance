package com.vinay.insurance.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vinay.insurance.dto.PlanDto;
import com.vinay.insurance.service.InsuranceService;

@RestController
public class InsuranceController {
	@Autowired
	private InsuranceService insuranceService;

	@GetMapping(path = "/categories")
	public ResponseEntity<Map<Integer, String>> getPlanCategories() {
		Map<Integer, String> allCategories = insuranceService.getAllCategories();
		return new ResponseEntity<Map<Integer, String>>(allCategories, HttpStatus.OK);

	}

	@PostMapping("/plan")
	public ResponseEntity<String> savePlan(@RequestBody PlanDto planDto) {
		String response = " ";
		Boolean isSaved = insuranceService.addPlan(planDto);
		if (isSaved) {
			response = "PlanSaved";
		} else {
			response = "Plan Not Saved";
		}
		return new ResponseEntity<String>(response, HttpStatus.CREATED);

	}

	@GetMapping("plans")
	public ResponseEntity<List<PlanDto>> getPlans() {
		List<PlanDto> plans = insuranceService.getPlans();
		if (plans != null) {
			return new ResponseEntity<List<PlanDto>>(plans, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<PlanDto>>(HttpStatus.BAD_GATEWAY);
		}

	}

	@GetMapping("plan/{planId}")
	public ResponseEntity<PlanDto> getPlan(@PathVariable Integer planId) {
		PlanDto planDto = insuranceService.getPlan(planId);
		return new ResponseEntity<PlanDto>(planDto, HttpStatus.OK);

	}

	@DeleteMapping("plan/{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer planId) {
		String msg = " ";
		Boolean isDeleted = insuranceService.deletePlan(planId);
		if (isDeleted) {
			msg = "Plan Deleted";
		} else {
			msg = "Plan Not Deleted";
		}
		return new ResponseEntity<>(msg, HttpStatus.OK);

	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updatePlan(@RequestBody PlanDto planDto) {
		String msg=" ";
		Boolean updatePlan = insuranceService.updatePlan(planDto);
		if(updatePlan) {
			msg="upated";
		}
		{
			msg="NOt updated";
		}
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	@PutMapping("/status/{planId}/{status}")
	public ResponseEntity<String> statusChange(@PathVariable("planId") Integer planId,@PathVariable("status") String status) {
		String msg=" ";
		Boolean statusChange = insuranceService.controlPlanStatus(planId, status);
		if(statusChange) {
			msg="status changed";
		}else{
			msg=" status NOt changed"; 
		}
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
}
