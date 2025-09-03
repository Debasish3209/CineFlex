package com.debasish.dto;

import java.util.ArrayList;
import java.util.List;

import com.debasish.model.FeedBack;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CustomerDto {


	private String custId;
	
	private String custName;
	
	private String custEmail;
	
	private String custPh;
	
	private String custAddress;
	
	private List<FeedBack> feedBacks = new ArrayList<>();
}
