package com.vinay.insurance.dto;

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

public class CategoryDto {
	
	private String categoryName;
	private String status;
	
	private String createdBy;
	private String updatedBy;		
}