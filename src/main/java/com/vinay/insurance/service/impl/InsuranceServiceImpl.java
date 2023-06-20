package com.vinay.insurance.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.vinay.insurance.dto.PlanDto;
import com.vinay.insurance.entity.Category;
import com.vinay.insurance.entity.Plan;
import com.vinay.insurance.repository.CategoryRepository;
import com.vinay.insurance.repository.PlanRepository;
import com.vinay.insurance.service.InsuranceService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InsuranceServiceImpl implements InsuranceService {
	private final CategoryRepository categoryRepository;
	private final PlanRepository planRepository;

	@Override
	public Map<Integer, String> getAllCategories() {
		List<Category> categories = categoryRepository.findAll();

		Map<Integer, String> categoriesMap = new HashMap<>();

		categories.forEach(category -> categoriesMap.put(category.getCategoryId(), category.getCategoryName()));

		return categoriesMap;
	}

	@Override
	public Boolean addPlan(PlanDto planDto) {
		Plan plan = new Plan();
		BeanUtils.copyProperties(planDto, plan);
		Plan save = planRepository.save(plan);

		// return save.getPlanId()!=null?true:false ;

		return save.getPlanId() != null;
	}

	@Override
	public List<PlanDto> getPlans() {
		List<Plan> plans = planRepository.findAll();

		List<PlanDto> plansDto = new ArrayList<PlanDto>();
		for (Plan plan : plans) {
			PlanDto pd = new PlanDto();
			BeanUtils.copyProperties(plan, pd);
			plansDto.add(pd);
		}

		return plansDto;
	}

	@Override
	public PlanDto getPlan(Integer planId) {

		Optional<Plan> plan = planRepository.findById(planId);

		PlanDto planDto = new PlanDto();

		BeanUtils.copyProperties(plan.get(), planDto);

		return plan.isPresent() ? planDto : null;
	}

	@Override
	public Boolean deletePlan(Integer planId) {
		boolean status = false;

		try {
			planRepository.deleteById(planId);
			status = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public Boolean controlPlanStatus(Integer planId, String status) {
		Optional<Plan> planFromDb = planRepository.findById(planId);
		if (planFromDb.isPresent()) {
			planFromDb.get().setActiveSwitch(status);
			planRepository.save(planFromDb.get());
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Boolean updatePlan(PlanDto planDto) {
		Plan plan = new Plan();
		BeanUtils.copyProperties(planDto, plan);
		Plan save = planRepository.save(plan);// UPSERT METHOD

		// return save.getPlanId()!=null?true:false ;

		return save.getPlanId() != null;
	}

}
