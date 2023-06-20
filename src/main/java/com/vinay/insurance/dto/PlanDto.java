package com.vinay.insurance.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Builder

public class PlanDto {
	
	private String planName;
	private LocalDate planEndDate;
	private Integer categoryId;
	private LocalDate startdate;

	private String activeSwitch;
	
	private String createdBy;
	private String updatedBy;
	
	
}
