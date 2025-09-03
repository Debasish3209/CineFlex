package com.debasish.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name="cust-info")

public class Customer {

	@Id
	@Column(name = "Id")
	private String custId;
	
	@Column(name= "Name", length = 20)
	private String custName;
	
	@Column(name= "Email")
	private String custEmail;
	
	@Column(name= "Ph")
	private String custPh; 
	
	@Column(name= "Address")
	private String custAddress;
	

	//@Transient  //
	//private List<FeedBack> feedBacks = new ArrayList<>();
	
}
