package com.ims.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductDTO {
	
	private int productId;
	
	@Size(max=255)
	@NotBlank(message="Product name cannot be blank")
	private String productName;
	
	@Size(max=255)
	@NotBlank(message="Product description cannot be blank")
	private String productDescription;
	
	@Size(max=25)
	@NotBlank(message="Product category cannot be blank")
	private String productCategory;
	
	@Size(max=25)
	@NotNull(message="Product quantity cannot be null")
	private int productQuantity;
	
	@Size(max=8)
	@NotNull(message="Product price cannot be null")
	private double productPrice;
}
