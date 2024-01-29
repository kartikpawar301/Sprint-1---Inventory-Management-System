package com.ims.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sales {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int saleId;
	
	private Date purchaseDate;
	
	@Column(length=11, nullable = false)
	@NotNull(message="Total price cannot be null")
	private double totalAmount;

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="productId")
    private Product product;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="customerId")
    private Customer customer;
}
