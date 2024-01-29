package com.ims.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SupplierDTO 
{
	private int supplierId;
	
	@Size(max=25)
	@NotBlank(message="Supplier name cannot be blank")
	private String supplierName;
	
	@Size(max=25)
	@NotBlank(message="Supplier address cannot be blank")
	private String supplierAddress;
	
	@Size(max=10)
	@NotNull(message="Supplier mobile number cannot be null")
	private long supplierMobileNumber;

}
