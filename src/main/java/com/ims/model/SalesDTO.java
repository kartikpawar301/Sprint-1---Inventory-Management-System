package com.ims.model;

import java.sql.Date;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SalesDTO {

	private int saleId;
	
	private Date purchaseDate;
	
	@Size(max=8)
	@NotNull(message="Total price cannot be null")
	private double totalAmount;
}
