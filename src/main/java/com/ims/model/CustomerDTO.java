package com.ims.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDTO {

	private int customerId;
	
	@Size(max=25)
	@NotBlank(message="Customer name cannot be blank")
	private String customerName;
	
	@Size(max=25)
	@NotBlank(message="Customer address cannot be blank")
	private String customerAddress;
	
	@Size(max=10)
	@NotNull(message="Customer mobile number cannot be null")
	private long customerMobileNumber;
}
