package com.vinay.insurance.entity;

import java.time.LocalDate;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Data
@Setter
@Getter
@NoArgsConstructor
@Builder
@Entity
@Table(name = "plan")
public class Plan {
	@Id
	@GeneratedValue
	private Integer planId;
	
	private String planName;
	
	private LocalDate planEndDate;
	
	private Integer categoryId;
	
	private String activeSwitch;
	
	
	@Column(updatable = false)
	private LocalDate startdate;
	@UpdateTimestamp
	@Column(insertable = false)
	private LocalDate updateDate;
	private String createdBy;
	private String updatedBy;
	
	
}
